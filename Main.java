import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from film;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
