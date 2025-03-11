package Repository.Interface;

import Entities.Book;

public interface IBookRepository {
    boolean AddBook (Book newBook);
    boolean UpdateBook ( );
    boolean DeleteBook ( int id );
}
