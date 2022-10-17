package tests.integrationtests;
import org.junit.Test;

import application.service.LedgerService;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import domain.entities.EntityInterface;
import domain.entities.GeneralLedger;
import domain.entities.Loan;
import domain.enums.EntryType;
import repository.inmemory.InMemoryRepositoryInterface;
import repository.inmemory.LedgerRepository;
import tests.mockdata.LoanDataGenerator;


public class TestLedger {
    @Test
    public void testAddLedger() {
        Loan loan = LoanDataGenerator.testLoan();
        InMemoryRepositoryInterface ledgerRepo = new LedgerRepository();
        LedgerService ledgerService = new LedgerService(ledgerRepo);
        ArrayList<EntityInterface> ledgers =  ledgerService.searchLedger(loan.borrower.accountId, loan.lender.accountId);
        GeneralLedger firstLedgerEntry = (GeneralLedger) ledgers.get(0);
        BigDecimal loanAmount = new BigDecimal(12000);
        loanAmount = loanAmount.setScale(2, RoundingMode.HALF_UP); // this does change bd
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
