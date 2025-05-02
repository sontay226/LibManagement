package Repository.Implement.InMemoryImpl;

import Entities.Book;
import Entities.Borrow;
import Repository.Interface.IBookRepository;
import Repository.Interface.IBorrowRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BorrowRepositoryImpl implements IBorrowRepository {
    private final Map<Integer , Borrow> _borrowsList = new HashMap<>();
    private final IBookRepository bookRepository;

    public BorrowRepositoryImpl(Map<Integer , Borrow> borrowsList, BookRepositoryImpl bookRepository) {
        if ( borrowsList != null ) _borrowsList.putAll(borrowsList);
        this.bookRepository = bookRepository;
    }


    @Override
    public Borrow save ( Borrow newBorrow) {
        return _borrowsList.put(newBorrow.getId(),  newBorrow);
    }

    @Override
    public List<Borrow> findAll() {
        return new ArrayList<>(_borrowsList.values());
    }

    @Override
    public Optional<Borrow> findById(Integer userId) {
        return _borrowsList.values().stream().filter(b -> b.getBorrower().getId() == userId).findFirst();
    }

    @Override
    public boolean checkIsAvailable(int bookId) {
        return bookRepository.findById(bookId).isPresent();
    }
    @Override
    public void deleteById ( Integer id ) {
        if ( !_borrowsList.containsKey(id) ) throw new NoSuchElementException("Borrow w id " + id + " is not exits!");
        _borrowsList.remove(id);
    }
}
