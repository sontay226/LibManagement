package Services;

import Entities.Book;
import Entities.Borrow;
import Repository.Interface.IBookRepository;
import Repository.Interface.IBorrowRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import exception.BookNotFoundException;
import exception.BorrowNotFoundException;
import exception.UserNotFoundException;
public class BorrowService {
    private final IBookRepository bookRepository;
    private final IBorrowRepository borrowRepository;
    public BorrowService ( IBookRepository bookRepository , IBorrowRepository borrowRepository ) {
        this.bookRepository = bookRepository;
        this.borrowRepository = borrowRepository;
    }
    public Borrow save( Borrow newBorrow ) {
        if ( newBorrow == null ) throw new NoSuchElementException("newBorrow can't null!");
        return borrowRepository.save(newBorrow);
    }
    public List<Borrow> findByUserId(int userId) {
        if ( userId <= 0 ) throw new IllegalArgumentException("User id must not be null!");
        return borrowRepository.findByUserId(userId);
    }
    public List<Borrow> findAll() { return borrowRepository.findAll(); }
    public Optional<Borrow> findById ( Integer id ) {
        if ( id == null || id <= 0 ) throw new IllegalArgumentException("Id must not be null!");
        return borrowRepository.findById(id);
    }
    public boolean checkIsAvailable ( int bookId ) { return borrowRepository.checkIsAvailable(bookId);}
    public void deleteById ( Integer id ) {
        if ( !borrowRepository.findById(id).isPresent()) throw new BookNotFoundException(id);
        borrowRepository.deleteById(id);
    }
    public void returnBook(Integer borrowId) {
        Borrow b = borrowRepository.findById(borrowId).orElseThrow(() -> new BorrowNotFoundException(borrowId));
        for (Book book : b.getBorrowedBooks()) {
            book.setQuantity(book.getQuantity() + 1);
            bookRepository.save(book);
        }
        borrowRepository.deleteById(borrowId);
    }

}
