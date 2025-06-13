import java.sql.*;
public class DatabaseManager
{
    private static final String DB_URL= "jdbc:mysql://localhost:3306/TicTacToeDB";
    private static final String DB_USER="root";
    private static final String DB_PASSWORD=" ";
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
    }
    public static void saveGameResult(String player1,String player2,String winner,String boardState)
    {
        String query="INSERT INTO tictactoe(player1,player2,winner,board_state)VALUES(?,?,?,?)";
        try(Connection conn=getConnection();
             PreparedStatement stmt=conn.prepareStatement(query))
        {
            stmt.setString(1,player1);
            stmt.setString(2,player2);
            stmt.setString(3,winner);
            stmt.setString(4,boardState);
            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println("Database error: " +e.getMessage());
        }
    }
}