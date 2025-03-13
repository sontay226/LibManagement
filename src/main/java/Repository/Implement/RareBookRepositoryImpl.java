package Repository.Implement;

import Repository.Interface.IBookRepository;
import Entities.Book;
import java.util.List;

public class RareBookRepositoryImpl implements IBookRepository {
    private double PrivateFee = 100;
    private int RareQuantity = 10;
    private List<Book> _list;
    public RareBookRepositoryImpl ( List<Book> _list ) { this._list = _list;}

    public double getPrivateFee() {
        return PrivateFee;
    }

    public void setPrivateFee(double privateFee) {
        this.PrivateFee = privateFee;
    }

    public List<Book> rareBooklist() {
        return _list;
    }

    @Override
    public boolean AddBook(Book newBook) {
        boolean exists = _list.stream().anyMatch(b -> b.getId() == newBook.getId());
        if ( !exists ) {
            _list.add(newBook);
            newBook.setQuantity( RareQuantity );
            return true;
        }
        return false;
    }

    @Override
    public boolean UpdateBook(Book newBook) {
        for ( Book tmp : _list ) {
            if ( tmp.getId() == newBook.getId()) {
                tmp.setName(newBook.getName());
                tmp.setGenre(newBook.getGenre());
                tmp.setAuthor(newBook.getAuthor());
                if ( newBook.getQuantity() > 10 ) {
                    System.out.println("Rare Book cant greater than 10!");
                    return false;
                }else {
                    tmp.setQuantity(newBook.getQuantity());
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean DeleteBook(int id) {
        for ( Book tmp : _list ) {
            if ( tmp.getId() == id ) {
                _list.remove(tmp);
                return true;
            }
        }
        return false;
    }
}
