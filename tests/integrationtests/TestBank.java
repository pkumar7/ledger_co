package tests.integrationtests;
import org.junit.Test;

import domain.entities.lenders.Bank;
import tests.mockdata.BankDataGenerator;

import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class TestBank {
    @Test
    public void testAddBank() {
        Bank testBank = BankDataGenerator.testBank();
        
    }

}
