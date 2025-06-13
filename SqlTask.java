import java.sql.*;
public class SqlTask
{
    private Connection connection;
    public SqlTask() throws SQLException
    {
        connection=DatabaseHandler.getConnection();
    }
    public void AddNewUsers(String name,String email,String password) throws SQLException
    {
        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,password);
        ps.executeUpdate();
    }

    public int UserAuthenticate(String email, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        return rs.next() ? 1 : 0;
    }
}
