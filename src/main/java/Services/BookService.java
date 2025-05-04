package Services;

import Entities.Book;
import Repository.Interface.IBookRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import exception.BookNotFoundException;
public class BookService {
    private final IBookRepository bookRepository;
    public BookService ( IBookRepository bookRepository ) { this.bookRepository = bookRepository;}
    public Book save ( Book newBook ) {
        if ( newBook == null ) throw new IllegalArgumentException("newBook can't null!");
        return bookRepository.save(newBook);
    }
    public void deleteById ( Integer id ) {
        Optional<Book> book = bookRepository.findById(id);
        if ( !book.isPresent() ) throw new BookNotFoundException(id);
        bookRepository.deleteById(id);
    }
    public List<Book> findAll() { return bookRepository.findAll(); }
    public Optional<Book> findById ( Integer id ) {
        if ( id == null || id <= 0 ) throw new IllegalArgumentException("id is null or less than 0");
        return bookRepository.findById(id);
    }
    public List<Book> findByAuthor ( String author ) {
        if (author == null || author.trim().isEmpty()) throw new IllegalArgumentException("Author must not be null or empty");
        return bookRepository.findByAuthor(author);
    }
    public List<Book> findByKeyword ( String keyword ) {
        if (keyword == null || keyword.trim().isEmpty()) throw new IllegalArgumentException("Keyword must not be null or empty");
        return bookRepository.findByKeyword(keyword);
    }
}
