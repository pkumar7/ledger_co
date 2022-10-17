package application.factories;

import java.util.UUID;

import domain.entities.GeneralLedger;
import domain.entities.Transaction;

public class LedgerFactory {
    public static GeneralLedger newLedgerEntry(Transaction firstTransaction, 
    Transaction secondTransaction, Integer emiNumber){
        UUID uuid=UUID.randomUUID();
        GeneralLedger ledger = new GeneralLedger(uuid.toString(), firstTransaction, 
            secondTransaction, emiNumber);
        return ledger;
    }

}
