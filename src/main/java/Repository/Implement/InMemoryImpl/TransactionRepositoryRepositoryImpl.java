package Repository.Implement.InMemoryImpl;

import Entities.Transactions;
import Repository.Interface.ITransactionRepository;

import java.util.List;

public class TransactionRepositoryRepositoryImpl implements ITransactionRepository {
    private List<Transactions> transactionsList;
    public TransactionRepositoryRepositoryImpl(List<Transactions> transactionsList) { this.transactionsList =  transactionsList;}
    @Override
    public boolean addTransaction(Transactions transactions) {
        return transactionsList.add(transactions);
    }
    @Override
    public List<Transactions> getTransactionsList() { return transactionsList; }
}
