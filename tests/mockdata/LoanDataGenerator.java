package tests.mockdata;

import java.math.BigDecimal;

import application.service.LedgerService;
import application.service.LoanService;
import application.service.TransactionService;
import domain.entities.Account;
import domain.entities.Loan;
import repository.inmemory.InMemoryRepositoryInterface;
import repository.inmemory.LedgerRepository;
import repository.inmemory.LoanRepository;
import repository.inmemory.TransactionRepository;

public class LoanDataGenerator {
    public static LoanService getLoanServiceInstance() {
        InMemoryRepositoryInterface loanRepository = new LoanRepository();
        InMemoryRepositoryInterface transactionRepository = new TransactionRepository();
        TransactionService transactionService = new TransactionService(transactionRepository);
        InMemoryRepositoryInterface ledgerRepository = new LedgerRepository();
        LedgerService ledgerService = new LedgerService(ledgerRepository);
        LoanService loanService = new LoanService(loanRepository, transactionService, 
        ledgerService);
        return loanService;
    } 

    public static Loan testLoan() {
        LoanService loanService = getLoanServiceInstance();
        BigDecimal loanAmount = new BigDecimal(10000);
        BigDecimal interestRate = new BigDecimal(4);
        Account individualBorrowerAccount = AccountDataGenerator.testAccountForBorrower();
        Account lenderAccount = AccountDataGenerator.testAccountForBank();
        Loan loan = (Loan) loanService.createLoanForIndividualBorrower(individualBorrowerAccount, 
        lenderAccount, loanAmount, 5, interestRate);
        return loan;
    }

}
