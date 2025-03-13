package Entities;

import java.time.LocalDate;
import java.util.List;
public class Borrow {
    private User borrower;
    private List<Book> borrowedBooks;
    private LocalDate borrowDate;
    private LocalDate returnExpectedDate;

    public Borrow(User borrower, List<Book> borrowedBooks, LocalDate borrowDate, LocalDate returnExpectedDate) {
        this.borrower = borrower;
        this.borrowedBooks = borrowedBooks; // Danh sách được truyền từ bên ngoài
        this.borrowDate = borrowDate;
        this.returnExpectedDate = returnExpectedDate;
    }
    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnExpectedDate() {
        return returnExpectedDate;
    }

    public void setReturnExpectedDate(LocalDate returnExpectedDate) {
        this.returnExpectedDate = returnExpectedDate;
    }
}
