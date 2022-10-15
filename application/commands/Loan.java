package application.commands;

import java.math.BigDecimal;

public class Loan {

    private String bankName;
    private String borrowerName;
    private BigDecimal principalAmount;
    private Integer loanYearPeriod;
    private BigDecimal interestRate;

    public Loan(String bankName, String borrowerName, BigDecimal principalAmount, 
        Integer loanYearPeriod, BigDecimal interestRate) {
            this.bankName = bankName;
            this.borrowerName = borrowerName;
            this.principalAmount = principalAmount;
            this.loanYearPeriod = loanYearPeriod;
            this.interestRate = interestRate;
    }
    
}
