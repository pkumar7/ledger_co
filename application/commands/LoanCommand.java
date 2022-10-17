package application.commands;

import java.math.BigDecimal;

import application.factories.LoanServiceFactory;
import application.service.AccountService;
import application.service.BorrowerService;
import application.service.LenderService;
import application.service.LoanService;
import domain.entities.LoanAccount;
import domain.entities.AccountHolderInterface;
import domain.entities.Loan;
import domain.entities.borrowers.BorrowerInterface;
import domain.entities.borrowers.IndividualBorrower;
import domain.entities.lenders.Bank;
import repository.inmemory.AccountRepository;
import repository.inmemory.BankRepository;
import repository.inmemory.BorrowerRepository;
import repository.inmemory.InMemoryRepositoryInterface;

public class LoanCommand implements CommandInterface {

    public String bankName;
    public String borrowerName;
    public BigDecimal principalAmount;
    public Integer loanYearPeriod;
    public BigDecimal interestRate;

    public LoanCommand(String args) {
        this.parseCommand(args);
    }
    
    public void parseCommand(String args) {
        String[] loanArgs = args.split(" ");
        this.bankName = loanArgs[1];
        this.borrowerName = loanArgs[2];
        this.principalAmount = new BigDecimal(loanArgs[3]);
        this.loanYearPeriod = Integer.valueOf(loanArgs[4]);
        this.interestRate = new BigDecimal(loanArgs[5]);
    }

    public String addLoan() {
        LoanService loanService = LoanServiceFactory.getLoanServiceInstance();
        LoanAccount borrowerAccount = this.getAccount(this.getBorrower());
        LoanAccount lenderAccount = this.getAccount(this.getLender());
        Loan loan = loanService.createLoanForIndividualBorrower(borrowerAccount, lenderAccount, 
        this.principalAmount, this.loanYearPeriod, interestRate);
        return loan.loanId;
    }

    private BorrowerInterface getBorrower() {   
        InMemoryRepositoryInterface borrowerRepository = new BorrowerRepository();
        BorrowerService borrowerService = new BorrowerService(borrowerRepository);
        return (IndividualBorrower) borrowerService.createIndividualBorrower(this.borrowerName); 
    } 

    private Bank getLender() {   
        InMemoryRepositoryInterface bankRepository = new BankRepository();
        LenderService lenderService = new LenderService(bankRepository);
        return lenderService.createBank(this.bankName);
    }

    private LoanAccount getAccount(AccountHolderInterface accountHolder) {
        InMemoryRepositoryInterface accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        LoanAccount account = accountService.createAccount(accountHolder);
        return account;
    }


}
