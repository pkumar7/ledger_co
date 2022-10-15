package application.commands;

import java.math.BigDecimal;

public class Payment {

    private String bankName;
    private String borrowerName;
    private BigDecimal lumpSumAmount;
    private Integer emiNumber;

    public Payment(String bankName, String borrowerName, BigDecimal lumpSumAmount, 
        Integer emiNumber) {
            this.bankName = bankName;
            this.borrowerName = borrowerName;
            this.lumpSumAmount = lumpSumAmount;
            this.emiNumber = emiNumber;
    }
    
}
