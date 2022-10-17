package application.service;

import application.factories.AccountFactory;
import domain.entities.LoanAccount;
import domain.entities.AccountHolderInterface;
import domain.entities.EntityInterface;
import repository.RepositoryInterface;

public class AccountService {
    private RepositoryInterface repository;

    public AccountService(RepositoryInterface repository) {
        this.repository = repository;
    }

    public LoanAccount createAccount(AccountHolderInterface accountHolder) {
        LoanAccount account = AccountFactory.newAccount(accountHolder);
        this.repository.save(account);
        return account;
    }

    public EntityInterface getAccount(String accountHolderId) {
        EntityInterface account = this.repository.get(accountHolderId);
        return account;
    }

}
