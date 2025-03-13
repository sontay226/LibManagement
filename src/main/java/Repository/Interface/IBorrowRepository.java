package Repository.Interface;
import Entities.Book;
import java.util.List;

public interface IBorrowRepository {
    List<Book> listBorrow();
    boolean checkIsAvailable ( int bookId);
}
