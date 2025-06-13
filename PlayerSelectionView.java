import javax.swing.*;
import java.awt.*;

public class PlayerSelectionView extends JFrame {
    private JTextField player1NameField, player1SymbolField, player2NameField, player2SymbolField;

    public PlayerSelectionView() {
        setTitle("Select Players");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel player1Label = new JLabel("Player 1 Name:");
        player1NameField = new JTextField();
        JLabel player1SymbolLabel = new JLabel("Player 1 Symbol (X/O):");
        player1SymbolField = new JTextField();
        JLabel player2Label = new JLabel("Player 2 Name:");
        player2NameField = new JTextField();
        JLabel player2SymbolLabel = new JLabel("Player 2 Symbol (X/O):");
        player2SymbolField = new JTextField();

        JButton startButton = new JButton("Start Game");
        JButton backButton = new JButton("Back");

        add(player1Label);
        add(player1NameField);
        add(player1SymbolLabel);
        add(player1SymbolField);
        add(player2Label);
        add(player2NameField);
        add(player2SymbolLabel);
        add(player2SymbolField);
        add(startButton);
        add(backButton);

        startButton.addActionListener(e -> {
            String player1Name = player1NameField.getText();
            char player1Symbol = player1SymbolField.getText().charAt(0);
            String player2Name = player2NameField.getText();
            char player2Symbol = player2SymbolField.getText().charAt(0);

            TicTacToePlayer player1 = new TicTacToePlayer(player1Name, "", player1Symbol);
            TicTacToePlayer player2 = new TicTacToePlayer(player2Name, "", player2Symbol);

            new Game(player1, player2).start();
            dispose();
        });

        backButton.addActionListener(e -> {
            new MainMenuView().setVisible(true);
            dispose();
        });
    }
}
