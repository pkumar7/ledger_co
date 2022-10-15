package domain.entities;

import java.math.BigDecimal;

public class Loan {

    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private Integer timePeriod;

    public Loan(BigDecimal loanAmount, BigDecimal interestRate, Integer timePeriod) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.timePeriod = timePeriod;
    }
    
    public BigDecimal interest() {
        return loanAmount.multiply(BigDecimal.valueOf(timePeriod)).multiply(interestRate);
    }

    public BigDecimal totalAmount() {
        return this.loanAmount.add(this.interest());
    }
}
