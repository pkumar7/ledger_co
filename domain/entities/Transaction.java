package domain.entities;

import java.math.BigDecimal;
import java.util.Date;

import domain.enums.EntryType;

public class Transaction {

    private String transactionId;
    private Account sourceAccount;
    private Account destinationAccount;
    private Date transactionTime;
    private EntryType entryType;
    private BigDecimal amount;

    public Transaction(String transactionId, Account sourceAccount, 
    Account destinationAccount, EntryType entry, BigDecimal amount) {
        this.transactionId = transactionId;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transactionTime = new Date();
        this.entryType = entry;
        this.amount = amount;
    }
    
}
