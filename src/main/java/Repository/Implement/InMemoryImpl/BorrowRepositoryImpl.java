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
        if (newBorrow.getId() == null) {
            int newId = _borrowsList.keySet().stream().mapToInt(i->i).max().orElse(0) + 1;
            newBorrow.setId(newId);
        }
        _borrowsList.put(newBorrow.getId(), newBorrow);
        return newBorrow;
    }

    @Override
    public List<Borrow> findAll() {
        return new ArrayList<>(_borrowsList.values());
    }

    @Override
    public Optional<Borrow> findById(Integer id) {
        return Optional.ofNullable(_borrowsList.get(id));
    }
    @Override
    public List<Borrow> findByUserId(int userId) {
        return _borrowsList.values().stream()
                .filter(b -> b.getBorrower().getId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkIsAvailable(int bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (!optionalBook.isPresent()) return false;

        Book book = optionalBook.get();
        int totalQuantity = book.getQuantity();

        long borrowedCount = _borrowsList.values().stream()
                .flatMap(b -> b.getBorrowedBooks().stream())
                .filter(b -> b.getId() == bookId)
                .count();
        return totalQuantity > borrowedCount;
    }
    @Override
    public void deleteById ( Integer id ) {
        if ( !_borrowsList.containsKey(id) ) throw new NoSuchElementException("Borrow w id " + id + " is not exits!");
        _borrowsList.remove(id);
    }
}
