package Entities;

import java.time.LocalDate;

public class Transactions {
    public enum TransactionType {
        BORROW,
        RETURN
    }

    private int transactionId;
    private User user;
    private TransactionType type;
    private LocalDate transactionDate;
    private Borrow borrow;
    private ReturnAndFee returnAndFee;

    public Transactions(int transactionId, User user, TransactionType type,
                       LocalDate transactionDate, Borrow borrow, ReturnAndFee returnAndFee) {
        this.transactionId = transactionId;
        this.user = user;
        this.type = type;
        this.transactionDate = transactionDate;
        this.borrow = borrow;
        this.returnAndFee = returnAndFee;
    }

    // Getters & Setters

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public ReturnAndFee getReturnAndFee() {
        return returnAndFee;
    }

    public void setReturnAndFee(ReturnAndFee returnAndFee) {
        this.returnAndFee = returnAndFee;
    }

    @Override
    public String toString() {
        return "Transaction{" +
               "transactionId=" + transactionId +
               ", user=" + user +
               ", type=" + type +
               ", transactionDate=" + transactionDate +
               ", borrow=" + borrow +
               ", returnAndFee=" + returnAndFee +
               '}';
    }
}
