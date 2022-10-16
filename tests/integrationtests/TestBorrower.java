package tests.integrationtests;
import org.junit.Test;

import application.service.BorrowerService;

import static org.junit.Assert.assertEquals;

import domain.entities.borrowers.IndividualBorrower;
import repository.inmemory.BorrowerRepository;
import repository.inmemory.InMemoryRepositoryInterface;
import tests.mockdata.BorrowerDataGenerator;


public class TestBorrower {
    @Test
    public void testAddBorrower() {
        IndividualBorrower individualBorrower = BorrowerDataGenerator.testIndividualBorrower();
        assertEquals("testBorrower", individualBorrower.borrowerName);
        InMemoryRepositoryInterface borrowerRepository = new BorrowerRepository();
        BorrowerService borrowerService = new BorrowerService(borrowerRepository);
        IndividualBorrower savedBorrower = (IndividualBorrower) borrowerService.getBorrower(
            individualBorrower.borrowerId);
        assertEquals("testBorrower", savedBorrower.borrowerName);
    }

}
