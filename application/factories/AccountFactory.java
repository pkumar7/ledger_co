package application.factories;

import domain.entities.Account;
import domain.entities.AccountHolderInterface;

import java.util.UUID; 

public class AccountFactory {
    public static Account newAccount(AccountHolderInterface accountHolder){
        UUID uuid=UUID.randomUUID();
        Account account = new Account(uuid.toString(), accountHolder);
        return account;
    }

}
