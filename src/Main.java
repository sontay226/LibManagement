import PostgreSqlConnect.DBConnect;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main ( String[] args ) {
        try (Connection conn = DBConnect.getConnection()) {
            System.out.println("success!");
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT 1"); // Truy vấn kiểm tra
                if (rs.next()) {
                    int value = rs.getInt(1);
                    System.out.println("Truy vấn test thành công, giá trị = " + value);
                }
            }
        }catch( SQLException ex) {
            ex.printStackTrace();
        }

    }
}