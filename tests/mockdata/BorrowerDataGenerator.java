package tests.mockdata;

import application.service.BorrowerService;
import domain.entities.borrowers.IndividualBorrower;
import repository.inmemory.BorrowerRepository;
import repository.inmemory.InMemoryRepositoryInterface;

public class BorrowerDataGenerator {
    public static IndividualBorrower testIndividualBorrower() {
        InMemoryRepositoryInterface borrowerRepository = new BorrowerRepository();
        BorrowerService borrowerService = new BorrowerService(borrowerRepository);
        IndividualBorrower testBorrower = (IndividualBorrower) borrowerService.createIndividualBorrower(
            "testBorrower");
        return testBorrower;
    }

}
