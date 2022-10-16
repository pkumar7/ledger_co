package application.service;

import application.factories.AccountFactory;
import domain.entities.Account;
import domain.entities.AccountHolder;
import domain.entities.EntityInterface;
import repository.RepositoryInterface;

public class AccountService {
    private RepositoryInterface repository;

    public AccountService(RepositoryInterface repository) {
        this.repository = repository;
    }

    public Account createAccount(AccountHolder accountHolder) {
        Account account = AccountFactory.newAccount(accountHolder);
        this.repository.save(account);
        return account;
    }

    public EntityInterface getAccount(String accountHolderId) {
        EntityInterface account = this.repository.get(accountHolderId);
        return account;
    }

}
