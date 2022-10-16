package application.service;

import java.util.ArrayList;

import application.factories.LedgerFactory;
import domain.entities.EntityInterface;
import domain.entities.GeneralLedger;
import domain.entities.Transaction;
import repository.RepositoryInterface;

public class LedgerService {
    private RepositoryInterface repository;

    public LedgerService(RepositoryInterface repository) {
        this.repository = repository;
    }

    public void AddLedgerEntry(Transaction firstTransaction, Transaction secondTransaction) {
        GeneralLedger ledger = LedgerFactory.newLedgerEntry(firstTransaction, secondTransaction);
        this.repository.save(ledger);
    }

    public ArrayList<EntityInterface> searchLedger(String firstAccountId, String secondAccountId) {
        ArrayList<EntityInterface> ledgerEntries = this.repository.search(
            firstAccountId, secondAccountId);
        return ledgerEntries;
    }

}
