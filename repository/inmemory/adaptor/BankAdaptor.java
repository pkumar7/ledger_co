package repository.inmemory.adaptor;

import org.json.simple.JSONObject;

import domain.entities.EntityInterface;
import domain.entities.lenders.Bank;

public class BankAdaptor {
    public static JSONObject toJson(Bank bank) {
        JSONObject obj=new JSONObject();    
        obj.put("bankName", bank.bankName);    
        obj.put("bankId", bank.bankId);    
        return obj;
    }

    public static EntityInterface toEntiy(JSONObject json) {
        String accountId = json.get("accountId").toString();
        Bank bank = new Bank(json.get("bankName").toString(), json.get("bankId").toString());
        return bank;   
    }

}
