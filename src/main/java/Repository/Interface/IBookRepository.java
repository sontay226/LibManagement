package Repository.Interface;

import Entities.Book;
import java.util.List;

public interface IBookRepository extends GenericRepository<Book , Integer> {
    List<Book> findByAuthor(String author);
    List<Book> findByKeyword ( String keyword);
}
