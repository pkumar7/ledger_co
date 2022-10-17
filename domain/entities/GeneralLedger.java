package domain.entities;

public class GeneralLedger implements EntityInterface {

    public String ledgerId;
    public Transaction firstTransaction;
    public Transaction secondTransaction;
    public Integer emiNumber;

    public GeneralLedger(String ledgerId, Transaction firstTransaction, 
        Transaction secondTransaction, Integer emiNumber) {
            this.ledgerId = ledgerId;
            this.firstTransaction = firstTransaction;
            this.secondTransaction = secondTransaction;
            this.emiNumber = emiNumber;
    }
    
}
