package Repository.Implement.InMemoryImpl;

import Entities.Transactions;
import Repository.Interface.ITransactions;

import java.util.List;

public class TransactionsRepositoryImpl implements ITransactions {
    private List<Transactions> transactionsList;
    public TransactionsRepositoryImpl(List<Transactions> transactionsList) { this.transactionsList =  transactionsList;}
    @Override
    public boolean addTransaction(Transactions transactions) {
        return transactionsList.add(transactions);
    }
    @Override
    public List<Transactions> getTransactionsList() { return transactionsList; }
}
