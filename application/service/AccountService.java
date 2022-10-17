package application.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import application.factories.AccountFactory;
import domain.entities.LoanAccount;
import domain.entities.AccountHolderInterface;
import domain.entities.EntityInterface;
import repository.RepositoryInterface;

public class AccountService {
    private RepositoryInterface repository;
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock writeLock = lock.writeLock();

    public AccountService(RepositoryInterface repository) {
        this.repository = repository;
    }

    public LoanAccount createAccount(AccountHolderInterface accountHolder) {
        try {
            writeLock.lock();
            LoanAccount account = AccountFactory.newAccount(accountHolder);
            this.repository.save(account);
            return account;    
        }
        finally {
            writeLock.unlock();
        }
    }

    public EntityInterface getAccount(String accountHolderId) {
        EntityInterface account = this.repository.get(accountHolderId);
        return account;
    }

}
