package repository.inmemory;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import domain.entities.EntityInterface;
import domain.entities.lenders.Bank;
import repository.inmemory.adaptor.BankAdaptor;

public class BankRepository implements InMemoryRepositoryInterface {
    public static Map<String, JSONObject> bankData = new HashMap<String, JSONObject>();

    @Override
    public void save(EntityInterface entity) {
        JSONObject json = BankAdaptor.toJson((Bank) entity);
        bankData.put(json.get("bankId").toString(), json);
    }

    @Override
    public EntityInterface get(String id) {
        JSONObject json = bankData.get(id);
        return BankAdaptor.toEntiy(json);
    }

    @Override
    public EntityInterface update(EntityInterface entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EntityInterface search(String name) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
