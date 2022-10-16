package domain.entities;

import java.math.BigDecimal;

import domain.entities.borrowers.BorrowerInterface;
import domain.entities.lenders.LenderInterface;

public class Loan implements EntityInterface {

    public BigDecimal loanAmount;
    public BigDecimal interestRate;
    public Integer timePeriod;
    public Account borrower;
    public Account lender;
    public String loanId;

    public Loan(String loanId, BigDecimal loanAmount, BigDecimal interestRate, Integer timePeriod, 
    Account borrower, Account lender) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.timePeriod = timePeriod;
        this.borrower = borrower;
        this.lender = lender;
    }
    
    public BigDecimal interest() {
        return loanAmount.multiply(BigDecimal.valueOf(timePeriod)).multiply(interestRate);
    }

    public BigDecimal totalAmount() {
        return this.loanAmount.add(this.interest());
    }
}
