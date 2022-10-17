package repository.inmemory.adaptor;

import java.math.BigDecimal;

import org.json.simple.JSONObject;

import domain.entities.LoanAccount;
import domain.entities.AccountHolderInterface;
import domain.entities.EntityInterface;

public class AccountAdaptor {

    public static JSONObject toJson(LoanAccount account) {
        JSONObject obj=new JSONObject();    
        obj.put("accountHolderId", account.accountHolder.getAccountHolderId());    
        obj.put("accountId", account.accountId);    
        obj.put("balance", account.balance);
        
        if (account.accountHolder.getClass().getSimpleName().equals("Bank")) {
            obj.put("accountType", "lender");
        }
        if (account.accountHolder.getClass().getSimpleName().equals("IndividualBorrower")) {
            obj.put("accountType", "borrower");
        }
        return obj;
    }

    //Account(String accountId, AccountHolderInterface accountHolder)
    public static EntityInterface toEntiy(JSONObject accountJson, 
    AccountHolderInterface accountHolder) {
        BigDecimal balance = new BigDecimal(accountJson.get("balance").toString());
        LoanAccount account = new LoanAccount(accountJson.get("accountId").toString(), accountHolder);
        account.setBalance(balance);
        return account;   
    }

}
