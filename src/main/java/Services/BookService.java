package Services;

import Entities.Book;
import Repository.Interface.IBookRepository;

public class BookService {
    private IBookRepository bookRepository;
    public BookService ( IBookRepository bookRepository ) { this.bookRepository = bookRepository;}
    public boolean AddBook( Book newBook) {
        if (bookRepository.AddBook(newBook)) return true;
        return false;
    }
    public boolean UpdateBook ( Book newBook ) {
        if (bookRepository.UpdateBook(newBook)) return true;
        return false;
    }
    public boolean DeleteBook ( int id ) {
        if(bookRepository.DeleteBook(id)) return true;
        return false;
    }
 }
