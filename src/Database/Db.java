package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    public static Connection connectionDatabase(){
        String userName = "root";
        String password = "0668196287reda";
        String url = "jdbc:mysql://localhost:3306/stDB";
        Connection con;
        try {
             con = DriverManager.getConnection(url, userName, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
