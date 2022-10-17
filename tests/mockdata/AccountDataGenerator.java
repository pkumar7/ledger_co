package tests.mockdata;

import application.service.AccountService;
import domain.entities.LoanAccount;
import domain.entities.borrowers.IndividualBorrower;
import domain.entities.lenders.Bank;
import repository.inmemory.AccountRepository;
import repository.inmemory.InMemoryRepositoryInterface;

public class AccountDataGenerator {
    
    public static LoanAccount testAccountForBank() {
        InMemoryRepositoryInterface accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        Bank testBank = BankDataGenerator.testBank();
        LoanAccount account = accountService.createAccount(testBank);
        return account;
    }

    public static LoanAccount testAccountForBorrower() {
        InMemoryRepositoryInterface accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        IndividualBorrower borrower = BorrowerDataGenerator.testIndividualBorrower();
        LoanAccount account = accountService.createAccount(borrower);
        return account;
    }

}
