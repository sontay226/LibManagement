package Repository.Interface;
import Entities.Book;
import Entities.Borrow;

import java.util.List;

public interface IBorrowRepository {
    List<Borrow> listBorrow();
    List<Book> listBorrowBooks();
    boolean checkIsAvailable ( int bookId);
    boolean addBorrowBook ( Book book , int userId );
}
