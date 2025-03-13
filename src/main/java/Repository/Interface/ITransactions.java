package Repository.Interface;

import Entities.Transactions;
import java.util.List;
public interface ITransactions {
     boolean addTransaction ( Transactions transactions);
     List<Transactions> getTransactionsList();
}
