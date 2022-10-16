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

    public Bank getBank(String bankName) {
        Bank bank = (Bank) this.repository.get(bankName);
        return bank;
    }

}
