import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Game extends JFrame
{
    private Board board;
    private TicTacToePlayer player1;
    private TicTacToePlayer player2;
    private TicTacToePlayer currentPlayer;
    private JButton[][] buttons = new JButton[3][3];
    private JLabel statusLabel;
    public Game(TicTacToePlayer player1,TicTacToePlayer player2)
    {
        this.player1=player1;
        this.player2=player2;
        this.board=new Board();
        this.currentPlayer=player1;
        setTitle("Tic-Tac-Toe Game");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initializeBoardUI();
        initializeStatusBar();
    }
    private void initializeBoardUI()
    {
        JPanel boardPanel=new JPanel(new GridLayout(3,3));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial",Font.BOLD,60));
                buttons[i][j].setFocusPainted(false);
                final int row=i;
                final int col=j;
                buttons[i][j].addActionListener(e->handleMove(row, col));
                boardPanel.add(buttons[i][j]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);
    }
    private void initializeStatusBar() {
        statusLabel = new JLabel("Current Player: " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(statusLabel, BorderLayout.SOUTH);
    }
    private void handleMove(int row, int col) {
        if (board.isValidMove(row, col)) {
            board.placeMove(row, col, currentPlayer.getSymbol());
            buttons[row][col].setText(String.valueOf(currentPlayer.getSymbol()));
            buttons[row][col].setEnabled(false);

            if (board.checkWinner(currentPlayer.getSymbol())) {
                JOptionPane.showMessageDialog(this, currentPlayer.getName() + " wins!");
                resetGame();
            } else if (board.isBoardFull()) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
                statusLabel.setText("Current Player: " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")");
            }
        }
    }
    private void resetGame() {
        board = new Board();
        currentPlayer = player1;
        statusLabel.setText("Current Player: " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }
    public void start() {
        setVisible(true);
    }
}