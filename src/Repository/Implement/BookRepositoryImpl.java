package Repository.Implement;

import Entities.Book;
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
        _list.add(newBook);
        return true;
    }

    @Override
    public boolean UpdateBook(Book newBook) {
        for ( Book tmp : _list ) {
            if ( tmp.getId() == newBook.getId()) {
                tmp.setAuthor(newBook.getAuthor());
                tmp.setName(newBook.getName());
                tmp.setGenre(newBook.getGenre());
                tmp.setQuantity(newBook.getQuantity());
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
    public List<Book> bookList() { return _list;}
}
