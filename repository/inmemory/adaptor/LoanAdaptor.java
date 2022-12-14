package repository.inmemory.adaptor;

import java.math.BigDecimal;

import org.json.simple.JSONObject;

import domain.entities.LoanAccount;
import domain.entities.EntityInterface;
import domain.entities.Loan;


// String loanId, BigDecimal loanAmount, BigDecimal interestRate, Integer timePeriod, 
// BorrowerInterface borrower, LenderInterface lender
public class LoanAdaptor {
    public static JSONObject toJson(Loan loan) {
        JSONObject obj=new JSONObject();    
        obj.put("loanId", loan.loanId);    
        obj.put("loanAmount", loan.loanAmount.toString());    
        obj.put("interestRate", loan.interestRate.toString());    
        obj.put("timePeriod", loan.timePeriod);    
        obj.put("borrowerAccountId", loan.borrower.accountId);    
        obj.put("lenderAccountId", loan.lender.accountId);    
        return obj;
    }

    public static EntityInterface toEntiy(JSONObject json, LoanAccount borrower, LoanAccount lender) {
        BigDecimal loanAmount = new BigDecimal(json.get("loanAmount").toString());
        BigDecimal interestRate = new BigDecimal(json.get("interestRate").toString());
        Integer timePeriod = Integer.parseInt(json.get("timePeriod").toString());
        Loan loan = new Loan(json.get("loanId").toString(),
                loanAmount, interestRate, timePeriod, borrower, lender);
        return loan;
    }

}
