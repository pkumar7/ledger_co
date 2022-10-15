package domain.entities;

import java.math.BigDecimal;

public class EmiSchedule {

    private Integer eminumber;
    private BigDecimal emiAmount;

    public EmiSchedule(Integer eminumber, BigDecimal emiAmount) {
        this.eminumber = eminumber;
        this.emiAmount = emiAmount;
    }
    
}
