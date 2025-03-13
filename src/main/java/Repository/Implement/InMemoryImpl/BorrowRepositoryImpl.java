package Repository.Implement.InMemoryImpl;

import Entities.Book;
import Repository.Interface.IBorrowRepository;
import java.util.List;
import java.util.Optional;

public class BorrowRepositoryImpl implements IBorrowRepository {
    private List<Book> borrowedBooks;
    private BookRepositoryImpl bookRepository;

    public BorrowRepositoryImpl(List<Book> borrowedBooks, BookRepositoryImpl bookRepository) {
        this.borrowedBooks = borrowedBooks;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listBorrow() {
        return borrowedBooks;
    }

    @Override
    public boolean checkIsAvailable(int bookId) {
        // Giả sử kiểm tra từ danh sách của bookRepository
        Optional<Book> exists = bookRepository.bookList()
                                              .stream()
                                              .filter(book -> book.getId() == bookId)
                                              .findFirst();
        return exists.isPresent();
    }

    @Override
    public boolean addBorrowBook(Book book) {
        boolean exists = borrowedBooks.stream().anyMatch(b -> b.getId() == book.getId());
        if (!exists) {
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }

}
