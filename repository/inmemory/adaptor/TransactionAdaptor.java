package repository.inmemory.adaptor;

import java.math.BigDecimal;

import org.json.simple.JSONObject;

import domain.entities.Account;
import domain.entities.EntityInterface;
import domain.entities.Transaction;
import domain.enums.EntryType;

public class TransactionAdaptor {
    public static JSONObject toJson(Transaction transaction) {
        JSONObject obj=new JSONObject();    
        obj.put("transactionId", transaction.transactionId);    
        obj.put("amount", transaction.amount);
        obj.put("transactionTime", transaction.transactionTime.toString());
        obj.put("destinationAccountId", transaction.destinationAccount.accountId);
        obj.put("sourceAccountId", transaction.sourceAccount.accountId);
        obj.put("entryType", transaction.entryType.toString());
        return obj;
    }

    public static EntityInterface toEntiy(JSONObject json, Account sourceAccount, 
    Account destinationAccount) {
        BigDecimal amount = new BigDecimal(json.get("amount").toString());
        Transaction transaction = new Transaction(json.get("transactionId").toString(),
        sourceAccount, destinationAccount, 
        EntryType.valueOf(json.get("entryType").toString()), amount
        );
        return transaction;
    }

}
