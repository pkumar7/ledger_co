package domain.entities;

import java.math.BigDecimal;
import java.util.Date;

import domain.enums.EntryType;

public class Transaction implements EntityInterface{

    public String transactionId;
    public LoanAccount sourceAccount;
    public LoanAccount destinationAccount;
    public Date transactionTime;
    public EntryType entryType;
    public BigDecimal amount;

    public Transaction(String transactionId, LoanAccount sourceAccount, 
    LoanAccount destinationAccount, EntryType entry, BigDecimal amount) {
        this.transactionId = transactionId;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transactionTime = new Date();
        this.entryType = entry;
        this.amount = amount;
    }
    
}
