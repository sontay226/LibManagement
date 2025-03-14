package Repository.Implement.SQLImplement;

import Entities.Book;
import PostgreSqlConnect.DBConnect;
import Repository.Interface.IBookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepositorySQLImpl implements IBookRepository {


    @Override
    public boolean AddBook(Book newBook) {
        String sqlQuery = "insert into books ( bookid , name , author , genre , quantity) values ( ? , ? , ? , ? , ?)";
        try ( Connection connection = DBConnect.getConnection();
              PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1 , newBook.getId() );
            statement.setString(2 , newBook.getName());
            statement.setString(3, newBook.getAuthor());
            statement.setString(4 , newBook.getGenre());
            statement.setInt(5 , newBook.getQuantity());
            statement.executeUpdate();
            return true;
        }catch( SQLException ex ) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean UpdateBook(int id, String name, String author, String genre , int quantity) {
        String sqlQuery = "update books set name = ? , author = ? , genre = ? , quantity = ? where id = ? ";
        try ( Connection connection = DBConnect.getConnection() ;
         PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1 , name);
            statement.setString(2 , author);
            statement.setString(3 , genre);
            statement.setInt(4 , quantity);
            statement.setInt(5 , id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }catch( SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean DeleteBook(int id) {
        String sqlQuery = "delete from books where id = ?";
        try ( Connection connection = DBConnect.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1 , id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }catch( SQLException ex ) {

            return false;
        }
    }

    @Override
    public Book getBookById(int id) {
        String sqlQuery = "select * from books where id = ? ";
        try ( Connection connection = DBConnect.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1 , id);
            ResultSet resultSet = statement.executeQuery();
            if ( resultSet.next()) {
                return new Book (
                  resultSet.getInt("id"),
                  resultSet.getString("name"),
                  resultSet.getString("author"),
                  resultSet.getString("genre"),
                  resultSet.getInt("quantity")
                );
            }
        }catch( SQLException ex ) {
            ex.printStackTrace();
        }
        return null;
    }
}
