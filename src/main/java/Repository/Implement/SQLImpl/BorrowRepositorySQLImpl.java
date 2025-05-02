package Repository.Implement.SQLImpl;

import Entities.Book;
import Entities.Borrow;
import Entities.User;
import PostgreSqlConnect.DBConnect;
import Repository.Interface.IBorrowRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class BorrowRepositorySQLImpl implements IBorrowRepository {


    @Override
    public List<Borrow> listBorrow() {
        String sqlQuery = "select u.id , u.name , u.address , u.phone_number , b.id , b.name , b.author , b.genre , br.borrow_date , br.return_expected_date " +
                          " from borrows br " +
                          "join users u on br.user_id = u.id " +
                          " join books b on br.book_id = b.id " +
                          "order by u.id";
        List<Borrow> borrowList = new ArrayList<>();
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery()) {
                Borrow currentBorrow = null;
                int currentUserId = -1;
                List<Book> bookList = new ArrayList<>();
                while ( resultSet.next() ) {
                    int userId = resultSet.getInt("id");
                    String userName = resultSet.getString("name");
                    String userAddress = resultSet.getString("address");
                    String userPhone = resultSet.getString("phone_number");
                    User newUser = new User(userId , userName , userAddress, userPhone);
                    Book book = new Book (
                            resultSet.getInt("b.id"),
                            resultSet.getString("b.name"),
                            resultSet.getString("b.author"),
                            resultSet.getString("b.genre"),
                            1
                    );
                    LocalDate borrowDate = resultSet.getDate("borrow_date").toLocalDate();
                    LocalDate returnExpectedDate = resultSet.getDate("return_expected_date").toLocalDate();
                    if ( userId != currentUserId ) {
                        if ( currentBorrow != null ) {
                            borrowList.add(currentBorrow);
                        }
                        bookList = new ArrayList<>();
                        bookList.add(book);
                        currentBorrow = new Borrow(newUser, bookList , borrowDate , returnExpectedDate);
                        currentUserId = userId;
                    }else {
                        bookList.add(book);
                    }
                    if ( currentBorrow !=null ) {
                        borrowList.add(currentBorrow);
                    }
                }
        }catch( SQLException ex ) {
            ex.printStackTrace();
        }
        return borrowList;
    }

    @Override
    public List<Book> listBorrowBooks() {
        String sqlQuery = "select * from book";
        List<Book> bookList = new ArrayList<>();
        try ( Connection connection = DBConnect.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = statement.executeQuery()) {
            while ( resultSet.next()) {
                bookList.add( new Book (
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("author"),
                        resultSet.getString("genre")
                ));
            }
        }catch( SQLException ex ) {
            ex.printStackTrace();
        }
        return bookList;
    }

    @Override
    public boolean checkIsAvailable(int bookId) {
        String sqlQuery = "select * from books where bookId = ? and quantity > 0";
        List<Book> bookList = new ArrayList<>();
        try ( Connection connection = DBConnect.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1 , bookId);
            ResultSet resultSet = statement.executeQuery();
            while ( resultSet.next() ) {
                bookList.add(new Book( resultSet.getInt( 1 ),
                                       resultSet.getString(2),
                                       resultSet.getString(3),
                                       resultSet.getString(4),
                                       resultSet.getInt(5)));
                if ( bookList.size() > 0 ) return true;
            }
        }catch( SQLException ex ) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addBorrowBook(Book book , int userId) {
        String checkAvailableQuery = "select quantity from books where id = ?";
        String insertBorrowQuery = "insert into borrows (user_id , book_id , borrow_date , return_expected_date) " +
                                   "values(? , ? , ? , ?";

        String udpateBookQuantityQuery = "update books set quantity = quantity -1 where id = ? and quantity > 0";

        try ( Connection connection = DBConnect.getConnection()) {
            connection.setAutoCommit(false);
            try ( PreparedStatement statement = connection.prepareStatement(checkAvailableQuery)) {
                statement.setInt(1 , book.getId());
                ResultSet resultSet = statement.executeQuery();
                if ( !resultSet.next() || resultSet.getInt("quantity" )<= 0) {
                    return false;
                }
            }
            try ( PreparedStatement insertStatement = connection.prepareStatement(insertBorrowQuery)) {
                insertStatement.setInt(1 , userId);
                insertStatement.setInt(2 , book.getId());
                insertStatement.setDate(3 , java.sql.Date.valueOf(LocalDate.now()));
                insertStatement.setDate(4 , java.sql.Date.valueOf(LocalDate.now()));
                insertStatement.executeUpdate();
            }
            try (PreparedStatement updateStatement = connection.prepareStatement(udpateBookQuantityQuery)) {
                updateStatement.setInt(1, book.getId());
                updateStatement.executeUpdate();
            }
            connection.commit();
            return true;
        }catch( SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
