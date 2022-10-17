package application.factories;

import domain.entities.LoanAccount;
import domain.entities.AccountHolderInterface;

import java.util.UUID; 

public class AccountFactory {
    public static LoanAccount newAccount(AccountHolderInterface accountHolder){
        UUID uuid=UUID.randomUUID();

        // making accountHolder id as id for simplicity, search can be implemented in 
        // accountholder id
        String id = accountHolder.getAccountHolderId();
        LoanAccount account = new LoanAccount(id, accountHolder);
        return account;
    }

}
