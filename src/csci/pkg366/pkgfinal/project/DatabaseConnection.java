package csci.pkg366.pkgfinal.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static final String jdbcURL = "jdbc:postgresql://localhost:5432/Final";
    public static final String username = "postgres";
    public static final String password = "postgres123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }
}
