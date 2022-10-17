package application.factories;

import application.service.LedgerService;
import application.service.LoanService;
import application.service.TransactionService;
import repository.inmemory.InMemoryRepositoryInterface;
import repository.inmemory.LedgerRepository;
import repository.inmemory.LoanRepository;
import repository.inmemory.TransactionRepository;

public class LoanServiceFactory {
    public static LoanService getLoanServiceInstance() {
        InMemoryRepositoryInterface loanRepository = new LoanRepository();
        InMemoryRepositoryInterface transactionRepository = new TransactionRepository();
        TransactionService transactionService = new TransactionService(transactionRepository);
        InMemoryRepositoryInterface ledgerRepository = new LedgerRepository();
        LedgerService ledgerService = new LedgerService(ledgerRepository);
        LoanService loanService = new LoanService(loanRepository, transactionService, 
        ledgerService);
        return loanService;
    } 
   
}
