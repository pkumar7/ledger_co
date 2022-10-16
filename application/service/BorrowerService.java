package application.service;
import repository.RepositoryInterface;
import application.factories.AccountFactory;
import application.factories.BorrowerFactory;
import domain.entities.Account;
import domain.entities.borrowers.BorrowerInterface;
import domain.entities.EntityInterface;


public class BorrowerService {
    private RepositoryInterface repository;

    public BorrowerService(RepositoryInterface repository) {
        this.repository = repository;
    }

    public BorrowerInterface createIndividualBorrower(String borrowerName) {
        Account account = AccountFactory.newAccount();
        BorrowerInterface borrower = BorrowerFactory.newIndividualBorrower(account, borrowerName);
        this.repository.save(borrower);
        return borrower;
    }

    public EntityInterface getBorrower(String borrowerName) {
        EntityInterface borrower = this.repository.search(borrowerName);
        return borrower;
    }

}
