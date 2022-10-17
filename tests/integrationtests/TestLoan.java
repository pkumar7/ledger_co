package tests.integrationtests;
import org.junit.Test;

import application.service.LoanService;

import static org.junit.Assert.assertEquals;


import domain.entities.Loan;
import tests.mockdata.LoanDataGenerator;


public class TestLoan {
    @Test
    public void testAddLoan() {
        LoanService loanService = LoanDataGenerator.getLoanServiceInstance();
        Loan loan = LoanDataGenerator.testLoan();
        String expectedLoanId = loan.borrower.accountHolder.getAccountHolderId() + 
                        loan.lender.accountHolder.getAccountHolderId();
        Loan savedLoan = loanService.getLoan(loan.loanId);
        assertEquals(expectedLoanId, savedLoan.loanId);
        assertEquals(loan.loanAmount, savedLoan.loanAmount);
        assertEquals(loan.interestRate, savedLoan.interestRate);
        assertEquals(loan.timePeriod, savedLoan.timePeriod);
        assertEquals(loan.lender.accountId, savedLoan.lender.accountId);
        assertEquals(loan.borrower.accountId, savedLoan.borrower.accountId);
    }

}
