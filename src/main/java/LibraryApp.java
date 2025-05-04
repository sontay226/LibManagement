import Services.*;
import Repository.Implement.InMemoryImpl.*;
import Repository.Interface.*;
import Entities.*;
import exception.BookNotFoundException;
import exception.UserNotFoundException;
import exception.BorrowNotFoundException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryApp {
    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService;
    private final UserService userService;
    private final BorrowService borrowService;
    private final ReturnAndFeeService returnAndFeeService;
    private final TransactionService transactionService;

    public LibraryApp() {
        IBookRepository bookRepo = new BookRepositoryImpl(null);
        IUserRepository userRepo = new UserRepositoryImpl(null);
        IBorrowRepository borrowRepo = new BorrowRepositoryImpl(null, bookRepo);
        IReturnAndFeeRepository returnRepo = new ReturnAndFeeRepositoryImpl(null);
        ITransactionRepository transactionRepo = new TransactionRepositoryRepositoryImpl(null);
        this.transactionService = new TransactionService(transactionRepo);
        this.bookService = new BookService(bookRepo);
        this.userService = new UserService(userRepo);
        this.borrowService = new BorrowService(bookRepo, borrowRepo);
        this.returnAndFeeService = new ReturnAndFeeService(returnRepo);
    }

    public void run() {
        int mainChoice;
        do {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Manage Books");
            System.out.println("2. Manage Users");
            System.out.println("3. Manage Borrows");
            System.out.println("4. Manage Returns");
            System.out.println("5. List Transaction");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            mainChoice = Integer.parseInt(scanner.nextLine());
            switch (mainChoice) {
                case 1:
                    bookMenu();
                    break;
                case 2:
                    userMenu();
                    break;
                case 3:
                    borrowMenu();
                    break;
                case 4:
                    returnMenu();
                    break;
                case 5:
                    transactionMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (mainChoice != 0);
    }

    private void bookMenu() {
        int c;
        do {
            System.out.println("\n--- Book Menu ---");
            System.out.println("1. Add/Update RegularBook");
            System.out.println("2. Add/Update RareBook");
            System.out.println("3. Delete book");
            System.out.println("4. Find book by ID");
            System.out.println("5. Find book by author");
            System.out.println("6. Find book by keyword");
            System.out.println("7. Show all books");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            c = Integer.parseInt(scanner.nextLine());
            switch (c) {
                case 1:
                    addOrUpdateRegularBook();
                    break;
                case 2:
                    addOrUpdateRareBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    findBookById();
                    break;
                case 5:
                    findBookByAuthor();
                    break;
                case 6:
                    findBookByKeyword();
                    break;
                case 7:
                    bookService.findAll().forEach(System.out::println);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (c != 0);
    }

    private void userMenu() {
        int c;
        do {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Add/Update user");
            System.out.println("2. Delete user");
            System.out.println("3. Find user by ID");
            System.out.println("4. Find user by name");
            System.out.println("5. Show all users");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            c = Integer.parseInt(scanner.nextLine());
            switch (c) {
                case 1:
                    addOrUpdateUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    findUserById();
                    break;
                case 4:
                    findUserByName();
                    break;
                case 5:
                    userService.findAll().forEach(System.out::println);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (c != 0);
    }

    private void borrowMenu() {
        int c;
        do {
            System.out.println("\n--- Borrow Menu ---");
            System.out.println("1. Borrow book");
            System.out.println("2. Delete borrow record");
            System.out.println("3. Find borrow by ID");
            System.out.println("4. Find borrows by user ID");
            System.out.println("5. Check book availability");
            System.out.println("6. Show all borrows");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            c = Integer.parseInt(scanner.nextLine());
            switch (c) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    deleteBorrow();
                    break;
                case 3:
                    findBorrowById();
                    break;
                case 4:
                    findBorrowsByUser();
                    break;
                case 5:
                    checkAvailability();
                    break;
                case 6:
                    borrowService.findAll().forEach(System.out::println);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (c != 0);
    }

    private void returnMenu() {
        int c;
        do {
            System.out.println("\n--- Return Menu ---");
            System.out.println("1. Return book");
            System.out.println("2. Show all return records");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            c = Integer.parseInt(scanner.nextLine());
            switch (c) {
                case 1:
                    returnBook();
                    break;
                case 2:
                    returnAndFeeService.findAllReturns().forEach(System.out::println);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (c != 0);
    }
    private void transactionMenu() {
        int c;
        do {
            System.out.println("\n--- Transaction Menu ---");
            System.out.println("1. Record borrow transaction");
            System.out.println("2. Record return transaction");
            System.out.println("3. Show all transactions");
            System.out.println("4. Find transaction by ID");
            System.out.println("5. Find transactions by User ID");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            c = Integer.parseInt(scanner.nextLine());
            switch (c) {
                case 1:
                    recordBorrowTx();
                    break;
                case 2:
                    recordReturnTx();
                    break;
                case 3:
                    transactionService.getAllTransactions()
                            .forEach(System.out::println);
                    break;
                case 4:
                    findTxById();
                    break;
                case 5:
                    findTxByUser();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (c != 0);
    }

    private void addOrUpdateRegularBook() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());
        Book b = new Book(id, name, author, genre, qty);
        bookService.save(b);
        System.out.println("Saved: " + b);
    }
    private void addOrUpdateRareBook() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Rent fee: ");
        double fee = scanner.nextDouble();
        RareBook b = new RareBook(id, name, author, genre, qty , fee);
        bookService.save(b);
        System.out.println("Saved: " + b);
    }
    private void deleteBook() {
        System.out.print("ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        bookService.deleteById(id);
        System.out.println("Deleted book id=" + id);
    }

    private void findBookById() {
        System.out.print("ID to find: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book b = bookService.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        System.out.println(b);
    }

    private void findBookByAuthor() {
        System.out.print("Author: ");
        String a = scanner.nextLine();
        bookService.findByAuthor(a).forEach(System.out::println);
    }

    private void findBookByKeyword() {
        System.out.print("Keyword: ");
        String k = scanner.nextLine();
        bookService.findByKeyword(k).forEach(System.out::println);
    }

    // --- User handlers ---
    private void addOrUpdateUser() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String addr = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        User u = new User(id, name, addr, phone);
        userService.save(u);
        System.out.println("Saved: " + u);
    }

    private void deleteUser() {
        System.out.print("ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        userService.deleteById(id);
        System.out.println("Deleted user id=" + id);
    }

    private void findUserById() {
        System.out.print("ID to find: ");
        int id = Integer.parseInt(scanner.nextLine());
        User u = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        System.out.println(u);
    }

    private void findUserByName() {
        System.out.print("Name to search: ");
        String n = scanner.nextLine();
        userService.findUserByName(n).forEach(System.out::println);
    }

    private void borrowBook() {
        System.out.print("Borrow ID: ");
        int bid = Integer.parseInt(scanner.nextLine());
        System.out.print("User ID: ");
        int uid = Integer.parseInt(scanner.nextLine());
        System.out.print("Book ID: ");
        int bk = Integer.parseInt(scanner.nextLine());

        Book book = bookService.findById(bk).orElseThrow(() -> new BookNotFoundException(bk));
        if (book.getQuantity() <= 0) {
            System.out.println("Out of stock"); return;
        }
        User usr = userService.findById(uid).orElseThrow(() -> new UserNotFoundException(uid));

        book.setQuantity(book.getQuantity() - 1);
        bookService.save(book);

        Borrow br = new Borrow(bid, usr, Arrays.asList(book), LocalDate.now(), LocalDate.now().plusDays(7));
        borrowService.save(br);
        System.out.println("Borrowed: " + br);
    }

    private void deleteBorrow() {
        System.out.print("Borrow ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        borrowService.deleteById(id);
        System.out.println("Deleted borrow id=" + id);
    }

    private void findBorrowById() {
        System.out.print("Borrow ID to find: ");
        int id = Integer.parseInt(scanner.nextLine());
        Borrow br = borrowService.findById(id).orElseThrow(() -> new BorrowNotFoundException(id));
        System.out.println(br);
    }

    private void findBorrowsByUser() {
        System.out.print("User ID to list borrows: ");
        int uid = Integer.parseInt(scanner.nextLine());
        borrowService.findByUserId(uid).forEach(System.out::println);
    }

    private void checkAvailability() {
        System.out.print("Book ID to check: ");
        int bk = Integer.parseInt(scanner.nextLine());
        boolean ok = borrowService.checkIsAvailable(bk);
        System.out.println("Available? " + ok);
    }

    private void returnBook() {
        System.out.print("Borrow ID to return: ");
        int id = Integer.parseInt(scanner.nextLine());
        borrowService.returnBook(id);
        System.out.println("Returned borrow id=" + id);
    }

    // transaction

    private void recordBorrowTx() {
        System.out.print("Tx ID: ");
        int txId = Integer.parseInt(scanner.nextLine());
        System.out.print("User ID: ");
        int uid = Integer.parseInt(scanner.nextLine());
        User u = userService.findById(uid)
                .orElseThrow(() -> new UserNotFoundException(uid));

        System.out.print("Borrow ID: ");
        int bid = Integer.parseInt(scanner.nextLine());
        Borrow b = borrowService.findById(bid)
                .orElseThrow(() -> new BorrowNotFoundException(bid));

        Transactions tx = new Transactions(
                txId,
                u,
                Transactions.TransactionType.BORROW,
                LocalDate.now(),
                b,
                null
        );
        transactionService.addTransaction(tx);
        System.out.println("Borrow transaction recorded.");
    }

    private void recordReturnTx() {
        System.out.print("Tx ID: ");
        int txId = Integer.parseInt(scanner.nextLine());
        System.out.print("User ID: ");
        int uid = Integer.parseInt(scanner.nextLine());
        User u = userService.findById(uid)
                .orElseThrow(() -> new UserNotFoundException(uid));

        System.out.print("Borrow ID: ");
        int bid = Integer.parseInt(scanner.nextLine());
        Borrow b = borrowService.findById(bid)
                .orElseThrow(() -> new BorrowNotFoundException(bid));

        borrowService.returnBook(bid);
        List<Book> returned = b.getBorrowedBooks();
        ReturnAndFee rf = new ReturnAndFee(returned , uid , 1.0 , 1.0 , LocalDate.now() , 1.0);
        double fee = returnAndFeeService.calculateLateFee(rf);
        returnAndFeeService.save(rf);

        Transactions tx = new Transactions(
                txId,
                u,
                Transactions.TransactionType.RETURN,
                LocalDate.now(),
                b,
                rf
        );
        transactionService.addTransaction(tx);
        System.out.println("Return transaction recorded. Late fee = " + fee);
    }

    private void findTxById() {
        System.out.print("Tx ID to find: ");
        int id = Integer.parseInt(scanner.nextLine());
        Transactions tx = transactionService.getById(id);
        System.out.println(tx);
    }

    private void findTxByUser() {
        System.out.print("User ID to list TX: ");
        int uid = Integer.parseInt(scanner.nextLine());
        List<Transactions> list = transactionService.getAllTransactions().stream()
                .filter(tx -> tx.getUser().getId() == uid)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

}
