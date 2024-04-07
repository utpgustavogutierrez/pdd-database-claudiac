
// Vamos a implementar un singleton para manejar la conexion a nuestra base de
// datos
import java.sql.*;

public final class DBConnection {
    private static DBConnection instance;
    public Connection conn = null;

    private DBConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbPath = "jdbc:sqlite:./sqlite-sakila.db"; // direccion del archivo donde esta la base de datos
            conn = DriverManager.getConnection(dbPath);
        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.exit(0);
        }
        System.out.println("Connection successfully");
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
}