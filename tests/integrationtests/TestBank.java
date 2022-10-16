package tests.integrationtests;
import org.junit.Test;

import application.service.LenderService;

import static org.junit.Assert.assertEquals;

import domain.entities.lenders.Bank;
import repository.inmemory.BankRepository;
import repository.inmemory.InMemoryRepositoryInterface;
import tests.mockdata.BankDataGenerator;


public class TestBank {
    @Test
    public void testAddBank() {
        Bank testBank = BankDataGenerator.testBank();
        assertEquals("testBank", testBank.bankName);
        InMemoryRepositoryInterface bankRepository = new BankRepository();
        LenderService lenderService = new LenderService(bankRepository);
        Bank savedBank = lenderService.getBank(testBank.bankId);
        assertEquals("testBank", savedBank.bankName);
    }

}
