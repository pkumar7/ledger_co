package repository.inmemory.adaptor;

import java.math.BigDecimal;

import org.json.simple.JSONObject;

import domain.entities.Account;
import domain.entities.AccountHolderInterface;
import domain.entities.EntityInterface;

public class AccountAdaptor {

    public static JSONObject toJson(Account account) {
        JSONObject obj=new JSONObject();    
        obj.put("accountHolderId", account.accountHolder.accountHolderId);    
        obj.put("accountId", account.accountId);    
        obj.put("balance", account.balance);
        if (account.accountHolder.getClass().getSimpleName() == "Bank") {
            obj.put("accountType", "lender");
        }
        if (account.accountHolder.getClass().getSimpleName() == "IndividualBorrower") {
            obj.put("accountType", "borrower");
        }
        return obj;
    }

    //Account(String accountId, AccountHolderInterface accountHolder)
    public static EntityInterface toEntiy(JSONObject accountJson, 
    AccountHolderInterface accountHolder) {
        BigDecimal balance = new BigDecimal(accountJson.get("balance").toString());
        Account account = new Account(accountJson.get("accountId").toString(), accountHolder);
        account.setBalance(balance);
        return account;   
    }

}
