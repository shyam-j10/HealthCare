package Health.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Health.db.DbConnection;
import Health.entity.User;



public class UserDao {
	
	private static final String INSERT_QUERY = "INSERT INTO user (username, password) VALUES (?, ?)";
    private static final String VERIFY_QUERY = "SELECT password FROM user WHERE username = ?";

    public boolean addUser(User user) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement st = con.prepareStatement(INSERT_QUERY,Statement.RETURN_GENERATED_KEYS);
        st.setString(1, user.getUsername());
        st.setString(2, user.getPassword());
        int rowsAffected = st.executeUpdate();
        if (rowsAffected > 0) {
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setUserId(generatedKeys.getInt(1));
                    return true; // User added successfully
                }
            }
        }
        return false;
 }

    public boolean verifyUser(String username, String password) throws SQLException {
        Connection con = DbConnection.getConnection();
        PreparedStatement st = con.prepareStatement(VERIFY_QUERY);
        st.setString(1, username);
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                return storedPassword.equals(password);
            }
        }
        return false;
    }

}
