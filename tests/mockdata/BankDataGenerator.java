package tests.mockdata;

import application.service.LenderService;
import domain.entities.lenders.Bank;
import repository.inmemory.BankRepository;
import repository.inmemory.InMemoryRepositoryInterface;

public class BankDataGenerator {
    
    public static Bank testBank() {
        InMemoryRepositoryInterface bankRepository = new BankRepository();
        LenderService lenderService = new LenderService(bankRepository);
        Bank testBank = lenderService.createBank("testBank");
        return testBank;
    }
    
}
