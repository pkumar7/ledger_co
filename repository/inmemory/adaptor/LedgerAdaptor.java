package repository.inmemory.adaptor;
import org.json.simple.JSONObject;

import domain.entities.EntityInterface;
import domain.entities.GeneralLedger;
import domain.entities.Transaction;    

public class LedgerAdaptor {
    public static JSONObject toJson(GeneralLedger ledger) {
        JSONObject obj=new JSONObject();    
        obj.put("firstTransactionId", ledger.firstTransaction.transactionId);  
        obj.put("secondTransactionId", ledger.secondTransaction.transactionId);
        obj.put("ledgerId", ledger.ledgerId);
        obj.put("firstAccountId", ledger.firstTransaction.sourceAccount.accountId);
        obj.put("secondAccountId", ledger.firstTransaction.destinationAccount.accountId);
        return obj;
    }

    public static EntityInterface toEntiy(JSONObject json, 
    Transaction firstTransaction, Transaction secondTransaction) {
        GeneralLedger ledger = new GeneralLedger(json.get("ledgerId").toString(), 
        firstTransaction, secondTransaction);
        return ledger;   
    }

}
