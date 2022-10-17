package domain.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

import domain.entities.borrowers.BorrowerInterface;
import domain.entities.lenders.LenderInterface;

public class Loan implements EntityInterface {

    public BigDecimal loanAmount;
    public BigDecimal interestRate;
    public Integer timePeriod;
    public Account borrower;
    public Account lender;
    public String loanId;
    private BigDecimal pendingAmount;

    public Loan(String loanId, BigDecimal loanAmount, BigDecimal interestRate, Integer timePeriod, 
    Account borrower, Account lender) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.timePeriod = timePeriod;
        this.borrower = borrower;
        this.lender = lender;
        this.setPendingAmount(this.totalAmount());
    }
    
    public void setPendingAmount(BigDecimal pendingAmount) { 
        this.pendingAmount = pendingAmount;
    }

    public BigDecimal getPendingAmount() { 
        return this.pendingAmount;
    }

    public BigDecimal interest() {
        return loanAmount.multiply(BigDecimal.valueOf(timePeriod)).multiply(
            interestRate.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
    }

    public BigDecimal totalAmount() {
        return this.loanAmount.add(this.interest());
    }

    public Integer numberOfEmis(BigDecimal totalAmount, BigDecimal emiAmount) {
        BigDecimal timeperiod = totalAmount.divide(emiAmount, 2, RoundingMode.HALF_UP);
        return timeperiod.setScale(0, RoundingMode.CEILING).unscaledValue().intValue();
    }

    public BigDecimal monthlyEmiAmount() {
        return this.totalAmount().divide(new BigDecimal(this.timePeriod * 12), 2, 
        RoundingMode.HALF_UP);
    }

}
