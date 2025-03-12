package Entities;

import java.time.LocalDate;
import java.util.Date;

public class Borrow {
    private String Borrower , BookBorrower;
    private LocalDate BorrowDate , ReturnExpectDate;

    public Borrow(String borrower, String bookBorrower, LocalDate borrowDate, LocalDate returnExpectDate) {
        Borrower = borrower;
        BookBorrower = bookBorrower;
        BorrowDate = borrowDate;
        ReturnExpectDate = returnExpectDate;
    }

    public String getBorrower() {
        return Borrower;
    }

    public void setBorrower(String borrower) {
        Borrower = borrower;
    }

    public String getBookBorrower() {
        return BookBorrower;
    }

    public void setBookBorrower(String bookBorrower) {
        BookBorrower = bookBorrower;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        BorrowDate = borrowDate;
    }

    public LocalDate getReturnExpectDate() {
        return ReturnExpectDate;
    }

    public void setReturnExpectDate(LocalDate returnExpectDate) {
        ReturnExpectDate = returnExpectDate;
    }
}
