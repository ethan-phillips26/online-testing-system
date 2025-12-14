package csci.pkg366.pkgfinal.project;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author ethan
 */

public class Login {
    
    public static Users loginPrompt() {
        return loginPrompt(new Scanner(System.in));
    }

    public static Users loginPrompt(Scanner scan) {
        System.out.println("\n\n\n\nLogin");

        System.out.print("Username: ");
        String uname = scan.nextLine().trim();

        System.out.print("Password: ");
        String pw = scan.nextLine();

        Users u = findUserByCredentials(uname, pw);
        if (u == null) {
            System.out.println("Invalid username or password.");
        } else {
            System.out.println("Welcome, " + u.getFirstname() + "!");
        }
        return u;
    }

    public static Users findUserByCredentials(String username, String password) {
        String sql =
            "SELECT user_id, firstname, lastname, username, password, user_type " +
            "FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Users u = new Users();
                u.setUserId(rs.getInt("user_id"));
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setUserType(rs.getString("user_type"));
                return u;
            }

        } catch (SQLException e) {
            System.out.println("DB error during login");
            return null;
        }
    }
}