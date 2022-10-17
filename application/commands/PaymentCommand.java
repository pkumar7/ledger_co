package application.commands;

import java.math.BigDecimal;

public class PaymentCommand {

    public String bankName;
    public String borrowerName;
    public BigDecimal lumpSumAmount;
    public Integer emiNumber;

    public PaymentCommand(String args) {
        this.parsePaymentCommand(args);
    }

    public void parsePaymentCommand(String args) {
        String[] paymentArgs = args.split(" ");
        this.bankName = paymentArgs[1];
        this.borrowerName = paymentArgs[2];
        this.lumpSumAmount = new BigDecimal(paymentArgs[3]);
        this.emiNumber = Integer.valueOf(paymentArgs[4]);
    }
}
