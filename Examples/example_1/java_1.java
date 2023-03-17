import java.sql.*;

public class UserController {

    public void post(User user) throws SQLException {
        String encodedPassword = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
        
        try (Connection connection = DriverManager.getConnection("Your connection string here");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (Username, Password) VALUES (?, ?)")) {
            statement.setString(1, user.getUsername());
            statement.setString(2, encodedPassword);
            statement.executeUpdate();
        }
    }

    public static void main(String[] args) throws SQLException {
        UserController controller = new UserController();
        User user = new User("JohnDoe", "MyPassword123");
        controller.post(user);
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
