package repository.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import domain.entities.Account;
import domain.entities.EntityInterface;
import domain.entities.Loan;
import repository.inmemory.adaptor.LoanAdaptor;

public class LoanRepository implements InMemoryRepositoryInterface {
    public static Map<String, JSONObject> loanData = new HashMap<String, JSONObject>();

    @Override
    public void save(EntityInterface entity) {
        JSONObject json = LoanAdaptor.toJson((Loan) entity);
        loanData.put(json.get("loanId").toString(), json);
    }

    @Override
    public EntityInterface get(String id) {
        JSONObject json = loanData.get(id);
        AccountRepository accountRepo = new AccountRepository();
        Account lender = (Account) accountRepo.get(json.get("lenderAccountId").toString());
        Account borrower = (Account) accountRepo.get(json.get("borrowerAccountId").toString());
        return LoanAdaptor.toEntiy(json, borrower, lender);

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
