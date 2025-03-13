import Entities.Book;
import Repository.Implement.BookRepositoryImpl;
import Repository.Interface.IBookRepository;

import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main ( String[] args ) {
        List<Book> bookList = new ArrayList<>();
        IBookRepository bookRepository = new BookRepositoryImpl(bookList);

    }
}