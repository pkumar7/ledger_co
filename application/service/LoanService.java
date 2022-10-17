package application.service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import application.factories.LoanFactory;
import domain.entities.LoanAccount;
import domain.entities.EntityInterface;
import domain.entities.GeneralLedger;
import domain.entities.Loan;
import domain.entities.Transaction;
import domain.enums.EntryType;
import repository.RepositoryInterface;

public class LoanService {
    private RepositoryInterface repository;
    private TransactionService transactionService;
    private LedgerService ledgerService;

    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock writeLock = lock.writeLock();


    public LoanService(RepositoryInterface repository, TransactionService transactionService, 
    LedgerService ledgerService) {
        this.repository = repository;
        this.transactionService = transactionService;
        this.ledgerService = ledgerService;
    }

    public Loan createLoanForIndividualBorrower(LoanAccount borrowerAccount, LoanAccount lenderAccount, 
    BigDecimal loanAmount, Integer numberOfYears, BigDecimal interestRate) {

        // TODO: Should add transaction here
        try {
         writeLock.lock();
         Loan loan = LoanFactory.newLoan(loanAmount, interestRate, numberOfYears, 
                borrowerAccount, lenderAccount);
        this.repository.save(loan);
        Transaction firstTransaction = this.transactionService.debitAmount(lenderAccount, 
            borrowerAccount, loan.totalAmount());
        Transaction secondTransaction = this.transactionService.creditAmount(borrowerAccount, 
            lenderAccount, loan.totalAmount());
        this.ledgerService.AddLedgerEntry(firstTransaction, secondTransaction, 0);
        return loan;
        }
        finally {
            writeLock.unlock();
        }
    }

    public Loan getLoan(String loanId) {
        Loan loan = (Loan) this.repository.get(loanId);
        return loan;
    }

    public BigDecimal getLoanBalance(Loan loan, LoanAccount lenderAccount, 
    LoanAccount borrowerAccount, Integer emiNumber) {
        BigDecimal balance = new BigDecimal(0);
        ArrayList<EntityInterface> loanLedgers = this.ledgerService.searchLedger(
            lenderAccount.accountId, borrowerAccount.accountId);
        GeneralLedger ledger;
        for (int i=0; i<loanLedgers.size(); i++) {
            ledger = (GeneralLedger) loanLedgers.get(i);

            if (ledger.emiNumber > emiNumber) {
                continue;
            }
            if (ledger.firstTransaction.sourceAccount.accountId.equals(
                borrowerAccount.accountId) && ledger.firstTransaction.entryType.equals(
                    EntryType.DEBIT))
            {
                balance = balance.subtract(ledger.firstTransaction.amount);
            }
            else if (ledger.secondTransaction.sourceAccount.accountId.equals(
                borrowerAccount.accountId) && ledger.secondTransaction.entryType.equals(
                    EntryType.DEBIT))
            {
                balance = balance.subtract(ledger.firstTransaction.amount);
            }
            else {
                balance = balance.add(ledger.firstTransaction.amount);
            }
        }
        return balance;
    }

    private void addPayment(Loan loan, LoanAccount lenderAccount, LoanAccount borrowerAccount, 
    Integer emiNumber, BigDecimal amount) {
        try {
            writeLock.lock();
            Transaction firstTransaction = this.transactionService.creditAmount(lenderAccount, 
            borrowerAccount, amount);
            Transaction secondTransaction = this.transactionService.debitAmount(borrowerAccount, 
            lenderAccount, amount);
            this.ledgerService.AddLedgerEntry(firstTransaction, secondTransaction, emiNumber);    
        }
        finally {
            writeLock.unlock();
        }
    }

    public void addEmi(Loan loan, LoanAccount lenderAccount, 
    LoanAccount borrowerAccount, Integer emiNumber) {
        this.addPayment(loan, lenderAccount, borrowerAccount, emiNumber, loan.monthlyEmiAmount());
    }

    public void addMonthlyEmi(Loan loan, LoanAccount lenderAccount, 
    LoanAccount borrowerAccount, Integer maxEmiCount) {
        BigDecimal balance = this.getLoanBalance(loan, lenderAccount, 
            borrowerAccount, maxEmiCount);
        Integer maxExistingEmiNumber = this.ledgerService.getMaxExistingEmiCount(
        lenderAccount, borrowerAccount);
        BigDecimal amountToPay;
        Integer numberOfEmis = loan.numberOfEmis(loan.totalAmount(), loan.monthlyEmiAmount());
        if (maxEmiCount > maxExistingEmiNumber) {
            for (int i=maxExistingEmiNumber+1; i<maxEmiCount+1; i++) {
                if (balance.subtract(loan.monthlyEmiAmount()).compareTo(BigDecimal.ZERO) > 0) {
                    amountToPay = loan.monthlyEmiAmount();
                }
                else {
                    amountToPay = balance;
                }
                this.addPayment(loan, lenderAccount, borrowerAccount, i, amountToPay);
            }
        }
    }

    public void addPrePayment(Loan loan, LoanAccount lenderAccount, LoanAccount borrowerAccount, 
    Integer emiNumber, BigDecimal amount) {
        Integer maxExistingEmiNumber = this.ledgerService.getMaxExistingEmiCount(
        lenderAccount, borrowerAccount);
        if (maxExistingEmiNumber < emiNumber) {
            for (int i=maxExistingEmiNumber+1; i<emiNumber; i++) {
                this.addEmi(loan, lenderAccount, borrowerAccount, emiNumber);
            }
        }
        this.addPayment(loan, lenderAccount, borrowerAccount, emiNumber, amount);
    }

}
