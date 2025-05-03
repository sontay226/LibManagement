package Services;

import Entities.Transactions;
import Repository.Interface.ITransactionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import exception.BaseException;
public class TransactionService {
    private final ITransactionRepository _transaction;

    public TransactionService(ITransactionRepository transaction) {_transaction = transaction;}

    public void addTransaction(Transactions transaction) {
        if (transaction == null) throw new BaseException("Transaction must not be null");
        _transaction.addTransaction(transaction);
    }


    public List<Transactions> getAllTransactions() {
        return _transaction.getTransactionsList();
    }

    public Transactions getById(int id) {
        if ( id <= 0 ) throw new IllegalArgumentException("Transaction id must greater than 0");
        return _transaction.getTransactionsList().stream()
                .filter(t -> t.getTransactionId() == id)
                .findFirst()
                .orElseThrow(() -> new BaseException("Transaction id=" + id + " not found"));
    }
}
