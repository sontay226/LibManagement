package Services;

import Entities.Book;
import Repository.Interface.IBookRepository;
import Repository.Interface.IBorrowRepository;
import java.util.List;

public class BorrowService {
    private IBookRepository bookRepository;
    private IBorrowRepository borrowRepository;
    public BorrowService ( IBookRepository bookRepository , IBorrowRepository borrowRepository ) {
        this.bookRepository = bookRepository;
        this.borrowRepository = borrowRepository;
    }
    public List<Book> listBorrow() { return borrowRepository.listBorrow(); }
    public boolean checkIsAvailable ( int bookId ) {
        return borrowRepository.checkIsAvailable(bookId);
    }
}
