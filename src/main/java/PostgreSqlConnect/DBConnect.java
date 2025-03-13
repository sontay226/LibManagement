package PostgreSqlConnect;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {
    private static String connectionString;

    static {
        try {
            // Đọc file appsettings.json từ thư mục resources
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = DBConnect.class.getClassLoader().getResourceAsStream("appsettings.json");
            if (is == null) {
                throw new RuntimeException("Không tìm thấy file appsettings.json");
            }
            JsonNode root = mapper.readTree(is);
            connectionString = root.path("ConnectionStrings").path("DefaultConnection").asText();
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi đọc cấu hình từ appsettings.json", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString);
    }
}
