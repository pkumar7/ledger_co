package domain.entities;

public class GeneralLedger implements EntityInterface {

    private String ledgerId;
    private Transaction firstTransaction;
    private Transaction secondTransaction;

    public GeneralLedger(String ledgerId, Transaction firstTransaction, 
        Transaction secondTransaction) {
            this.ledgerId = ledgerId;
            this.firstTransaction = firstTransaction;
            this.secondTransaction = secondTransaction;
    }
    
}
