package application.factories;

import domain.entities.Account;
import domain.entities.AccountHolderInterface;

import java.util.UUID; 

public class AccountFactory {
    public static Account newAccount(AccountHolderInterface accountHolder){
        UUID uuid=UUID.randomUUID();

        // making accountHolder id as id for simplicity, search can be implemented in 
        // accountholder id
        String id = accountHolder.getAccountHolderId();
        Account account = new Account(id, accountHolder);
        return account;
    }

}
