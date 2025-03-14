package Repository.Implement.InMemoryImpl;

import Entities.Book;
import Entities.RareBook;
import Repository.Interface.IBookRepository;
import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    private List<Book> _list;
    public BookRepositoryImpl ( List<Book> list) {_list = list;}
    @Override
    public boolean AddBook(Book newBook) {
        for ( Book tmp : _list ) {
            if ( tmp.getId() == newBook.getId() ) {
                System.out.println("This ID already added!");
                return false;
            }
        }
        if ( newBook instanceof RareBook ) {
            if ( newBook.getQuantity() > 10 ) {
                System.out.println("RareBook cannot greater than 10!");
                return false;
            }
        }
        return _list.add(newBook);
    }

    @Override
    public boolean UpdateBook(int id , String name , String author , String genre , int quantity ) {
        for ( Book tmp : _list ) {
            if ( tmp.getId() == id) {
                tmp.setAuthor(author);
                tmp.setName(name);
                tmp.setGenre(genre);
                tmp.setQuantity(quantity);
                System.out.println("Update success!");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean DeleteBook(int id) {
        for( Book tmp : _list ) {
            if ( tmp.getId() == id ) {
                _list.remove(tmp);
                System.out.println("Remove success!");
                return true;
            }
        }
        return false;
    }
    @Override
    public Book getBookById ( int id ) {
        return _list.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
    public List<Book> bookList() { return _list;}
}
