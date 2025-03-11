package Entities;

import java.util.Date;

public class Borrow {
    private String Borrower , BookBorrower;
    private Date BorrowDate , ReturnExpectDate;

    public Borrow(String borrower, String bookBorrower, Date borrowDate, Date returnExpectDate) {
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

    public Date getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        BorrowDate = borrowDate;
    }

    public Date getReturnExpectDate() {
        return ReturnExpectDate;
    }

    public void setReturnExpectDate(Date returnExpectDate) {
        ReturnExpectDate = returnExpectDate;
    }
}
