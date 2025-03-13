package Repository.Implement;

import Entities.Book;
import Repository.Interface.IBorrowRepository;

import java.util.List;
import java.util.Optional;

public class BorrowRepositoryImpl implements IBorrowRepository {
    private List<Book> _list;
    private BookRepositoryImpl bookRepository;
    public BorrowRepositoryImpl ( List<Book> list ) { _list = list;}
    @Override
    public List<Book> listBorrow() { return _list;}
    @Override
    public boolean checkIsAvailable(int bookId) {
        Optional<Book> exists = bookRepository.bookList()
                                              .stream()
                                              .filter(book -> book.getId() == bookId)
                                              .findFirst();
        return exists.isPresent();
    }

}
