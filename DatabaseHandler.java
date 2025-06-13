import java.sql.*;
public class DatabaseHandler
{
    private static final String DB_URL="jdbc:mysql://localhost:3306/tictactoedb";
    private static final String DB_USER="root";
    private static final String DB_PASSWORD="";
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
    }
    public class TestConnection
    {
        public static void main(String[] args)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("MySQL Driver is loaded successfully!");
            }
            catch(ClassNotFoundException e)
            {
                System.err.println("Driver has not loaded yet!!Pls check library!");
            }
        }
    }
    public static void initializeDB()
    {
        try(Connection conn=getConnection();
             Statement stmt=conn.createStatement())
        {
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "email VARCHAR(50) UNIQUE NOT NULL," +
                    "password VARCHAR(50) NOT NULL)");
            stmt.execute("CREATE TABLE IF NOT EXISTS games (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "player1_id INT NOT NULL," +
                    "player2_id INT NOT NULL," +
                    "current_player INT NOT NULL," +
                    "board_state VARCHAR(20) NOT NULL," +
                    "game_status VARCHAR(20) NOT NULL," +
                    "FOREIGN KEY (player1_id) REFERENCES users(id)," +
                    "FOREIGN KEY (player2_id) REFERENCES users(id))");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
