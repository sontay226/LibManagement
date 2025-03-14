package Repository.Interface;

import Entities.Book;

public interface IBookRepository {
    boolean AddBook (Book newBook);
    boolean UpdateBook ( int id  , String name , String author , String genre , int quantity);
    boolean DeleteBook ( int id );
    Book getBookById(int id);
}
