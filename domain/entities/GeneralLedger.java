package domain.entities;

public class GeneralLedger implements EntityInterface {

    public String ledgerId;
    public Transaction firstTransaction;
    public Transaction secondTransaction;

    public GeneralLedger(String ledgerId, Transaction firstTransaction, 
        Transaction secondTransaction) {
            this.ledgerId = ledgerId;
            this.firstTransaction = firstTransaction;
            this.secondTransaction = secondTransaction;
    }
    
}
