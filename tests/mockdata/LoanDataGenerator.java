package tests.mockdata;

import java.math.BigDecimal;

import application.service.LoanService;
import domain.entities.Loan;
import repository.inmemory.InMemoryRepositoryInterface;
import repository.inmemory.LoanRepository;

public class LoanDataGenerator {
    public static Loan testIndividualBorrower() {
        InMemoryRepositoryInterface loanRepository = new LoanRepository();
        LoanService loanService = new LoanService(loanRepository);
        BigDecimal loanAmount = new BigDecimal(10000);
        BigDecimal interestRate = new BigDecimal(4);
        Loan loan = (Loan) loanService.createLoanForIndividualBorrower("testBankName", 
        "testBorrowerName", loanAmount, 5, interestRate);
        return loan;
    }

}
