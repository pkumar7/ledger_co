package application.service;

import java.util.ArrayList;

import application.factories.LedgerFactory;
import domain.entities.LoanAccount;
import domain.entities.EntityInterface;
import domain.entities.GeneralLedger;
import domain.entities.Transaction;
import repository.RepositoryInterface;

public class LedgerService {
    private RepositoryInterface repository;

    public LedgerService(RepositoryInterface repository) {
        this.repository = repository;
    }

    public void AddLedgerEntry(Transaction firstTransaction, Transaction secondTransaction,
    Integer emiNumber) {
        GeneralLedger ledger = LedgerFactory.newLedgerEntry(firstTransaction, 
        secondTransaction, emiNumber);
        this.repository.save(ledger);
    }

    public ArrayList<EntityInterface> searchLedger(String firstAccountId, String secondAccountId) {
        ArrayList<EntityInterface> ledgerEntries = this.repository.search(
            firstAccountId, secondAccountId);
        return ledgerEntries;
    }

    public Integer getMaxExistingEmiCount(LoanAccount lenderAccount, LoanAccount borrowerAccount) {
        ArrayList<EntityInterface> loanLedgers = this.searchLedger(
            lenderAccount.accountId, borrowerAccount.accountId);
        GeneralLedger ledger;
        Integer maxExistingEmiNumber = 0;
        for (int i=0; i<loanLedgers.size(); i++) {
            ledger = (GeneralLedger) loanLedgers.get(i);
            if (ledger.emiNumber > maxExistingEmiNumber) {
                maxExistingEmiNumber = ledger.emiNumber;
            }
        }
        return maxExistingEmiNumber;
    }

}
