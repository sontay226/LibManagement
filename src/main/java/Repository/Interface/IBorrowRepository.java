package Repository.Interface;
import Entities.Book;
import Entities.Borrow;

import java.util.List;

public interface IBorrowRepository extends GenericRepository< Borrow , Integer> {
    boolean checkIsAvailable ( int bookId);
}
