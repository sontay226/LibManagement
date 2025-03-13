package Repository.Interface;

import Entities.Book;

public interface IBookRepository {
    boolean AddBook (Book newBook);
    boolean UpdateBook ( Book newBook );
    boolean DeleteBook ( int id );
    Book getBookById(int id);
}
