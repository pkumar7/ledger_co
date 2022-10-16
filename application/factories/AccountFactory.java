package application.factories;

import domain.entities.Account;
import domain.entities.AccountHolder;

import java.util.UUID; 

public class AccountFactory {
    public static Account newAccount(AccountHolder accountHolder){
        UUID uuid=UUID.randomUUID();
        Account account = new Account(uuid.toString(), accountHolder);
        return account;
    }

}
