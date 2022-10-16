package application.factories;

import domain.entities.lenders.Bank;
import java.util.UUID; 

public class BankFactory {
    public static Bank newBank(String bankName){
        UUID uuid=UUID.randomUUID();
        Bank bank = new Bank(uuid.toString(), bankName);
        return bank;
    }

}
