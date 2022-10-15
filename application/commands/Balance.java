package application.commands;

import java.math.BigDecimal;

public class Balance {

    private String bankName;
    private String borrowerName;
    private BigDecimal lumpSumAmount;
    private Integer emiNumberInteger;

    public Balance(String bankName, String borrowerName, BigDecimal lumpSumAmount, 
        Integer emiNumberInteger) {
            this.bankName = bankName;
            this.borrowerName = borrowerName;
            this.lumpSumAmount = lumpSumAmount;
            this.emiNumberInteger = emiNumberInteger;
    }
    
}
