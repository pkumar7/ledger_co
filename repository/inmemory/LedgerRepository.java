package repository.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import domain.entities.EntityInterface;
import domain.entities.GeneralLedger;
import domain.entities.Transaction;
import repository.inmemory.adaptor.LedgerAdaptor;

public class LedgerRepository implements InMemoryRepositoryInterface {

    public static Map<String, JSONObject> ledgerData = new HashMap<String, JSONObject>();
    
    @Override
    public void save(EntityInterface entity) {
        JSONObject json = LedgerAdaptor.toJson((GeneralLedger) entity);
        ledgerData.put(json.get("ledgerId").toString(), json);   
    }

    @Override
    public EntityInterface get(String id) {
        return null;
    }

    @Override
    public EntityInterface update(EntityInterface entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<EntityInterface> search(String... queries) {
        //String... borrowerAccountId, String lenderAccountId
        String borrowerAccountId = queries[0];
        String lenderAccountId = queries[1];
        JSONObject jsonData;
        ArrayList<EntityInterface> ledgerRecords = new ArrayList<EntityInterface>();
        Transaction firstTransaction;
        Transaction secondTransaction;
        GeneralLedger tempLedger;
        for (var entry : ledgerData.entrySet()) {
            jsonData = entry.getValue();
            if ((jsonData.get("firstAccountId").toString().equals(borrowerAccountId) && 
            jsonData.get("secondAccountId").toString().equals(lenderAccountId)) || 
            jsonData.get("firstAccountId").toString().equals(lenderAccountId) && 
            jsonData.get("secondAccountId").toString().equals(borrowerAccountId))
            {
                TransactionRepository transactionRepo = new TransactionRepository();
                firstTransaction = (Transaction) transactionRepo.get(
                    jsonData.get("firstTransactionId").toString());
                secondTransaction = (Transaction) transactionRepo.get(
                        jsonData.get("secondTransactionId").toString());
                tempLedger = (GeneralLedger) LedgerAdaptor.toEntiy(jsonData, 
                    firstTransaction, secondTransaction);
                ledgerRecords.add(tempLedger);
            }
        }
        return ledgerRecords;
    }    
}
