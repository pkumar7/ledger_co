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
    private TransactionService transactionService;
    private LedgerService ledgerService;

    public LoanService(RepositoryInterface repository, TransactionService transactionService, 
    LedgerService ledgerService) {
        this.repository = repository;
        this.transactionService = transactionService;
        this.ledgerService = ledgerService;
    }

    public Loan createLoanForIndividualBorrower(Account borrowerAccount, Account lenderAccount, 
    BigDecimal loanAmount, Integer numberOfYears, BigDecimal interestRate) {

        // TODO: Should add transaction here.

        Loan loan = LoanFactory.newLoan(loanAmount, interestRate, numberOfYears, 
                borrowerAccount, lenderAccount);
        this.repository.save(loan);
        Transaction firstTransaction = this.transactionService.debitAmount(lenderAccount, 
            borrowerAccount, loanAmount);
        Transaction secondTransaction = this.transactionService.creditAmount(borrowerAccount, 
            lenderAccount, loanAmount);
        this.ledgerService.AddLedgerEntry(firstTransaction, secondTransaction);
        return loan;
    }

    public Loan getLoan(String loanId) {
        Loan loan = (Loan) this.repository.get(loanId);
        return loan;
    }

}
