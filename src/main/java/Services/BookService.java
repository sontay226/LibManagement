package Services;

import Entities.Book;
import Repository.Interface.IBookRepository;

public class BookService {
    private IBookRepository bookRepository;
    public BookService ( IBookRepository bookRepository ) { this.bookRepository = bookRepository;}
    public boolean AddBook( Book newBook) {
        return bookRepository.AddBook(newBook);
    }
    public boolean UpdateBook ( int id , String name , String author , String genre, int quantity  ) {
        return bookRepository.UpdateBook(id  , name , author , genre, quantity);
    }
    public boolean DeleteBook ( int id ) {
        return bookRepository.DeleteBook(id);
    }
 }
