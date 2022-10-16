package repository.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import domain.entities.Account;
import domain.entities.EntityInterface;
import domain.entities.Transaction;
import repository.inmemory.adaptor.TransactionAdaptor;

public class TransactionRepository implements InMemoryRepositoryInterface {

    public static Map<String, JSONObject> transactionData = new HashMap<String, JSONObject>();
    
    @Override
    public void save(EntityInterface entity) {
        JSONObject json = TransactionAdaptor.toJson((Transaction) entity);
        transactionData.put(json.get("transactionId").toString(), json);        
    }

    @Override
    public EntityInterface get(String id) {
        JSONObject json = transactionData.get(id);
        AccountRepository accountRepo = new AccountRepository();
        Account sourceAccount = (Account) accountRepo.get(json.get("sourceAccountId").toString());
        Account destinationAccount = (Account) accountRepo.get(
            json.get("destinationAccountId").toString());
        return TransactionAdaptor.toEntiy(json, sourceAccount, destinationAccount);
    }

    @Override
    public EntityInterface update(EntityInterface entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<EntityInterface> search(String... name) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
