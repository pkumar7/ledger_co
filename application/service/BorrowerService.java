package application.service;
import repository.RepositoryInterface;
import application.factories.BorrowerFactory;
import domain.entities.borrowers.BorrowerInterface;
import domain.entities.EntityInterface;


public class BorrowerService {
    private RepositoryInterface repository;

    public BorrowerService(RepositoryInterface repository) {
        this.repository = repository;
    }

    public BorrowerInterface createIndividualBorrower(String borrowerName) {
        BorrowerInterface borrower = BorrowerFactory.newIndividualBorrower(borrowerName);
        this.repository.save(borrower);
        return borrower;
    }

    public EntityInterface getBorrower(String borrowerName) {
        EntityInterface borrower = this.repository.get(borrowerName);
        return borrower;
    }

}
