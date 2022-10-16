package tests.integrationtests;
import org.junit.Test;

import application.service.LedgerService;
import application.service.LoanService;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import domain.entities.EntityInterface;
import domain.entities.GeneralLedger;
import domain.entities.Loan;
import domain.enums.EntryType;
import repository.inmemory.InMemoryRepositoryInterface;
import repository.inmemory.LedgerRepository;
import tests.mockdata.LoanDataGenerator;


public class TestLoan {
    @Test
    public void testAddLoan() {
        LoanService loanService = LoanDataGenerator.getLoanServiceInstance();
        Loan loan = LoanDataGenerator.testLoan();
        String expectedLoanId = loan.borrower.accountHolder.accountHolderId + 
                        loan.lender.accountHolder.accountHolderId;
        Loan savedLoan = loanService.getLoan(loan.loanId);
        assertEquals(expectedLoanId, savedLoan.loanId);
        assertEquals(loan.loanAmount, savedLoan.loanAmount);
        assertEquals(loan.interestRate, savedLoan.interestRate);
        assertEquals(loan.timePeriod, savedLoan.timePeriod);
        assertEquals(loan.lender.accountId, savedLoan.lender.accountId);
        assertEquals(loan.borrower.accountId, savedLoan.borrower.accountId);
        InMemoryRepositoryInterface ledgerRepo = new LedgerRepository();
        LedgerService ledgerService = new LedgerService(ledgerRepo);
        ArrayList<EntityInterface> ledgers =  ledgerService.searchLedger(loan.borrower.accountId, loan.lender.accountId);
        System.out.println(ledgers);
        GeneralLedger firstLedgerEntry = (GeneralLedger) ledgers.get(0);
        BigDecimal loanAmount = new BigDecimal(10000);
        assertEquals(firstLedgerEntry.firstTransaction.amount, loanAmount);
        assertEquals(firstLedgerEntry.secondTransaction.amount, loanAmount);

        assertEquals(firstLedgerEntry.firstTransaction.sourceAccount.accountId, 
            loan.lender.accountId);
        assertEquals(firstLedgerEntry.firstTransaction.destinationAccount.accountId, 
            loan.borrower.accountId);
        assertEquals(firstLedgerEntry.firstTransaction.entryType, EntryType.DEBIT);
        assertEquals(firstLedgerEntry.secondTransaction.sourceAccount.accountId, 
            loan.borrower.accountId);
        assertEquals(firstLedgerEntry.secondTransaction.destinationAccount.accountId, 
            loan.lender.accountId);
        assertEquals(firstLedgerEntry.secondTransaction.entryType, EntryType.CREDIT);

    }

}
