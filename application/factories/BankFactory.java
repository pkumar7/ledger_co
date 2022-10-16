package application.factories;

import domain.entities.lenders.Bank;
import java.util.UUID; 

public class BankFactory {
    public static Bank newBank(String bankName){
        UUID uuid=UUID.randomUUID();

        // For simplicity making bankName as key, can be uuid and search can be used to get values.

        Bank bank = new Bank(bankName, bankName);
        return bank;
    }

}
