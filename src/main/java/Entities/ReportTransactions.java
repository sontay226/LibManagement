package Entities;

import Repository.Implement.InMemoryImpl.TransactionsRepositoryImpl;
import Repository.Interface.ITransactions;

import java.time.LocalDate;
public class ReportTransactions {
    private ITransactions transactions;
    public ReportTransactions ( ITransactions transactions ) { this.transactions = transactions; }
    public void printBorrowedBooksReport () {
        System.out.println("Report for borrowed books : ");
        for ( Transactions transaction : transactions.getTransactionsList() ) {
            if ( transaction.getType() == Transactions.TransactionType.BORROW ) {
                System.out.println("Transaction ID: " + transaction.getTransactionId());
                System.out.println("User: " + transaction.getUser().getName());
                System.out.println("Borrow Date: " + transaction.getTransactionDate());
                System.out.println("Borrow Details: " + transaction.getBorrow());
                System.out.println("----------------------------------");
            }
        }
    }
    public void printLateFeesReportForUserInMonth (  User user , int month , int year ) {
        double totalLateFee = 0;
        System.out.println("===== Late Fees Report for " + user.getName() + " =====");
        for (Transactions t : transactions.getTransactionsList()) {
            if (t.getType() == Transactions.TransactionType.RETURN && t.getUser().getId() == user.getId()) {
                LocalDate date = t.getTransactionDate();
                if (date.getMonthValue() == month && date.getYear() == year) {
                    totalLateFee += t.getReturnAndFee().getReturnLateFee();
                }
            }
        }
        System.out.println("Total Late Fee in " + month + "/" + year + ": " + totalLateFee);
    }
}
