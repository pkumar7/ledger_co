package repository.inmemory.adaptor;

import org.json.simple.JSONObject;

import domain.entities.EntityInterface;
import domain.entities.borrowers.IndividualBorrower;

public class BorrowerAdaptor {
    public static JSONObject toJson(IndividualBorrower borrower) {
        JSONObject obj=new JSONObject();    
        obj.put("borrowerName", borrower.borrowerName);    
        obj.put("borrowerId", borrower.borrowerId);    
        return obj;
    }

    public static EntityInterface toEntiy(JSONObject json) {
        IndividualBorrower borrower = new IndividualBorrower(json.get("borrowerName").toString(), 
        json.get("borrowerId").toString());
        return borrower;   
    }

}
