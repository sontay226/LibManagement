package Repository.Implement.InMemoryImpl;

import Entities.Book;
import Entities.RareBook;
import Repository.Interface.IBookRepository;

import java.util.*;
import java.util.stream.Collectors;

public class BookRepositoryImpl implements IBookRepository {
    private Map<Integer,Book> _bookList = new HashMap<>();
    public BookRepositoryImpl ( Map<Integer , Book> bookList) {
        if ( bookList != null ) this._bookList.putAll(bookList);
    }
    @Override
    public Book save ( Book book ) {
        if ( book instanceof RareBook && book.getQuantity() > 10 ) {
            throw new IllegalArgumentException("RareBook quantity cannot greater than 10 ! Pls check again !");
        }
        _bookList.put(book.getId() , book);
        return book;
    }

    @Override
    public void deleteById (Integer id) {
        if ( !_bookList.containsKey(id)) throw new NoSuchElementException("Book w id " + id + " not exist!");
        _bookList.remove(id);
    }
    @Override
    public List<Book> findAll() {
        return new ArrayList<>(_bookList.values());
    }
    @Override
    public Optional<Book> findById(Integer id) {
        return Optional.ofNullable(_bookList.get(id));
    }
    @Override
    public List<Book> findByAuthor( String author ) {
        return _bookList.values().stream().filter( b -> b.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }
    @Override
    public List<Book> findByKeyword ( String keyword ) {
        String ans = keyword.toLowerCase();
        return _bookList.values().stream().filter( b -> b.getName().toLowerCase().contains(ans)
                                                        || b.getAuthor().toLowerCase().contains(ans)
                                                        || b.getGenre().toLowerCase().contains(ans))
                .collect(Collectors.toList());
    }
}
