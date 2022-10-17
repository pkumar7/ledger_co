package repository.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import domain.entities.LoanAccount;
import domain.entities.AccountHolderInterface;
import domain.entities.EntityInterface;
import repository.inmemory.adaptor.AccountAdaptor;

public class AccountRepository implements InMemoryRepositoryInterface {
    public static Map<String, JSONObject> accountData = new HashMap<String, JSONObject>();

    @Override
    public void save(EntityInterface entity) {
        JSONObject json = AccountAdaptor.toJson((LoanAccount) entity);
        accountData.put(json.get("accountId").toString(), json);
    }

    @Override
    public EntityInterface get(String id) {
        JSONObject json = accountData.get(id);
        AccountHolderInterface accountHolder;
        if (json.get("accountType").toString().equals("borrower")) {
            BorrowerRepository borrowerRepo = new BorrowerRepository();
            accountHolder = (AccountHolderInterface) borrowerRepo.get(
                json.get("accountHolderId").toString());
        }
        else if (json.get("accountType").toString().equals("lender")) {
            BankRepository bankRepo = new BankRepository();
            accountHolder = (AccountHolderInterface) bankRepo.get(
                json.get("accountHolderId").toString());
        }
        else {
            return null;
        }
        return AccountAdaptor.toEntiy(json, accountHolder);
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