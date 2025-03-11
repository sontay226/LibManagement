package Repository.Interface;
import Entities.Book;
import java.util.List;
import java.util.ArrayList;
public interface IBorrowRepository {
    List<Book> listBorrow();
    boolean checkIsAvailable ( String bookId);
}
