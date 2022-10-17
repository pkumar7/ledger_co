package application.service;
import java.math.BigDecimal;

import application.factories.TransactionFactory;
import domain.entities.LoanAccount;
import domain.entities.Transaction;
import domain.enums.EntryType;
import repository.RepositoryInterface;

public class TransactionService {
    private RepositoryInterface repository;

    public TransactionService(RepositoryInterface repository) {
        this.repository = repository;
    }

    public Transaction creditAmount(LoanAccount sourceAccount, LoanAccount destinationAccount, 
    BigDecimal amount) {
        Transaction tranaction = TransactionFactory.newTransaction(sourceAccount, destinationAccount, 
                EntryType.CREDIT, amount);
        this.repository.save(tranaction);
        return tranaction;
    }

    public Transaction debitAmount(LoanAccount sourceAccount, LoanAccount destinationAccount, 
    BigDecimal amount) {
        Transaction tranaction = TransactionFactory.newTransaction(sourceAccount, destinationAccount, 
                EntryType.DEBIT, amount);
        this.repository.save(tranaction);
        return tranaction;
    }

}
