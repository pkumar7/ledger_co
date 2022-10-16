package application.service;
import java.math.BigDecimal;

import application.factories.LoanFactory;
import domain.entities.Account;
import domain.entities.Loan;
import domain.entities.Transaction;
import domain.entities.borrowers.BorrowerInterface;
import domain.entities.lenders.LenderInterface;
import repository.RepositoryInterface;

public class LoanService {
    private RepositoryInterface repository;

    public LoanService(RepositoryInterface repository) {
        this.repository = repository;
    }

    public Loan createLoanForIndividualBorrower(String bankName, String borrowerName, 
    BigDecimal loanAmount, Integer numberOfYears, BigDecimal interestRate) {

        // TODO: Should add transaction here.

        BorrowerService borrowerService = new BorrowerService(this.repository);
        BorrowerInterface borrower = borrowerService.createIndividualBorrower(bankName);
        AccountService accountService = new AccountService(this.repository);
        Account borrowerAccount = accountService.createAccount(borrower);
        LenderService lenderService = new LenderService(this.repository);
        LenderInterface lender = lenderService.createBank(bankName);
        Account lenderAccount = accountService.createAccount(lender);
        Loan loan = LoanFactory.newLoan(loanAmount, interestRate, numberOfYears, 
                borrowerAccount, lenderAccount);
        this.repository.save(loan);
        TransactionService transactionService = new TransactionService(this.repository);
        Transaction firstTransaction = transactionService.debitAmount(lenderAccount, 
            borrowerAccount, loanAmount);
        Transaction secondTransaction = transactionService.creditAmount(borrowerAccount, 
            lenderAccount, loanAmount);
        LedgerService ledgerService = new LedgerService(this.repository);
        ledgerService.AddLedgerEntry(firstTransaction, secondTransaction);
        return loan;

    }

}
