package application.service;
import domain.entities.lenders.Bank;
import repository.RepositoryInterface;
import application.factories.BankFactory;
import domain.entities.EntityInterface; 


public class LenderService {

    private RepositoryInterface repository;

    public LenderService(RepositoryInterface repository) {
        this.repository = repository;
    }

    public Bank createBank(String bankName) {
        Bank bank = BankFactory.newBank(bankName);
        this.repository.save(bank);
        return bank;
    }

    public EntityInterface getBank(String bankName) {
        EntityInterface bank = this.repository.search(bankName);
        return bank;
    }

}
