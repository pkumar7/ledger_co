package tests.mockdata;
import java.util.function.Function;

import domain.entities.Account;
import domain.entities.lenders.Bank;

public class BankDataGenerator {


    public static Account createTestAccount() {
        Account testAccount = new Account("1");
        return testAccount;
    }
    
    public static Bank testBank() {
        Bank testBank = new Bank("1", "TestBank", createTestAccount());
        return testBank;
    }
    

}
