package application.factories;

import java.math.BigDecimal;
import java.util.UUID;

import domain.entities.Account;
import domain.entities.Transaction;
import domain.enums.EntryType;

public class TransactionFactory {
    public static Transaction newTransaction(Account sourceAccount, 
    Account destinationAccount, EntryType entry, BigDecimal amount){
        UUID uuid=UUID.randomUUID();
        Transaction transaction = new Transaction(uuid.toString(), sourceAccount, 
                destinationAccount, entry, amount);
        return transaction;
    }

}
