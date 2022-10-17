package application.commands;

import java.math.BigDecimal;

import application.factories.LoanServiceFactory;
import application.service.AccountService;
import application.service.BorrowerService;
import application.service.LenderService;
import application.service.LoanService;
import domain.entities.Account;
import domain.entities.AccountHolderInterface;
import domain.entities.Loan;
import domain.entities.borrowers.BorrowerInterface;
import domain.entities.lenders.Bank;
import repository.inmemory.AccountRepository;
import repository.inmemory.BankRepository;
import repository.inmemory.BorrowerRepository;
import repository.inmemory.InMemoryRepositoryInterface;

public class BalanceCommand {

    public String bankName;
    public String borrowerName;
    public Integer emiNumber;

    public BalanceCommand(String args) {
        this.parseBalanceCommand(args);
    }

    public void parseBalanceCommand(String args) {
        String[] balanceArgs = args.split(" ");
        this.bankName = balanceArgs[1];
        this.borrowerName = balanceArgs[2];
        this.emiNumber = Integer.valueOf(balanceArgs[3]);
    }

    public void updateEmi() {
        LoanService loanService = LoanServiceFactory.getLoanServiceInstance();
        Account lenderAccount = this.getAccount(this.getLender());
        Account borrowerAccount = this.getAccount(this.getBorrower());

        // Workaround id format for simplicity
        String loanId = borrowerAccount.accountHolder.getAccountHolderId() + 
        lenderAccount.accountHolder.getAccountHolderId();

        Loan loan = loanService.getLoan(loanId);
        loanService.addMonthlyEmi(loan, lenderAccount, borrowerAccount, emiNumber);
        BigDecimal balance = loanService.getLoanBalance(
            loan, lenderAccount, borrowerAccount, emiNumber);
        BigDecimal PaidAmount = loan.totalAmount().subtract(balance);
        System.out.println(this.bankName + " " +  this.borrowerName 
        + " " +  PaidAmount + " " + loan.numberOfEmis(balance, loan.monthlyEmiAmount()));        
    }

    private BorrowerInterface getBorrower() {   
        InMemoryRepositoryInterface borrowerRepository = new BorrowerRepository();
        BorrowerService borrowerService = new BorrowerService(borrowerRepository);
        return (BorrowerInterface) borrowerService.getBorrower(this.borrowerName);
    } 

    private Bank getLender() {   
        InMemoryRepositoryInterface bankRepository = new BankRepository();
        LenderService lenderService = new LenderService(bankRepository);
        return lenderService.getBank(this.bankName);
    }

    private Account getAccount(AccountHolderInterface accountHolder) {
        InMemoryRepositoryInterface accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        Account account = (Account) accountService.getAccount(accountHolder.getAccountHolderId());
        return account;
    }





}
