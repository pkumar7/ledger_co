package repository.inmemory;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import domain.entities.EntityInterface;
import domain.entities.borrowers.IndividualBorrower;
import repository.inmemory.adaptor.BorrowerAdaptor;

public class BorrowerRepository implements InMemoryRepositoryInterface {
    public static Map<String, JSONObject> borrowerData = new HashMap<String, JSONObject>();

    @Override
    public void save(EntityInterface entity) {
        JSONObject json = BorrowerAdaptor.toJson((IndividualBorrower) entity);
        borrowerData.put(json.get("borrowerId").toString(), json); 
    }

    @Override
    public EntityInterface get(String id) {
        JSONObject json = borrowerData.get(id);
        return BorrowerAdaptor.toEntiy(json);
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
