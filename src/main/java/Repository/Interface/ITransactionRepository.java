package Repository.Interface;

import Entities.Transactions;
import java.util.List;
public interface ITransactionRepository {
     boolean addTransaction ( Transactions transactions);
     List<Transactions> getTransactionsList();
}
