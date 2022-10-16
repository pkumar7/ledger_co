package repository.inmemory;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import domain.entities.Account;
import domain.entities.AccountHolderInterface;
import domain.entities.EntityInterface;
import repository.inmemory.adaptor.AccountAdaptor;

public class AccountRepository implements InMemoryRepositoryInterface {
    public static Map<String, JSONObject> accountData = new HashMap<String, JSONObject>();

    @Override
    public void save(EntityInterface entity) {
        JSONObject json = AccountAdaptor.toJson((Account) entity);
        accountData.put(json.get("AccountId").toString(), json);
    }

    @Override
    public EntityInterface get(String id) {
        JSONObject json = accountData.get(id);
        AccountHolderInterface accountHolder;
        if (json.get("accountType").toString() == "borrower") {
            BorrowerRepository borrowerRepo = new BorrowerRepository();
            accountHolder = (AccountHolderInterface) borrowerRepo.get(
                json.get("accountHolderId").toString());
        }
        if (json.get("accountType").toString() == "lender") {
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
    public EntityInterface search(String name) {
        // TODO Auto-generated method stub
        return null;
    }

}