package tests.mockdata;

import application.service.AccountService;
import domain.entities.Account;
import domain.entities.borrowers.IndividualBorrower;
import domain.entities.lenders.Bank;
import repository.inmemory.AccountRepository;
import repository.inmemory.InMemoryRepositoryInterface;

public class AccountDataGenerator {
    
    public static Account testAccountForBank() {
        InMemoryRepositoryInterface accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        Bank testBank = BankDataGenerator.testBank();
        Account account = accountService.createAccount(testBank);
        return account;
    }

    public static Account testAccountForBorrower() {
        InMemoryRepositoryInterface accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        IndividualBorrower borrower = BorrowerDataGenerator.testIndividualBorrower();
        Account account = accountService.createAccount(borrower);
        return account;
    }

}
