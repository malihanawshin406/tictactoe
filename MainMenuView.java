import javax.swing.*;
import java.awt.*;
public class MainMenuView extends JFrame {
    public MainMenuView() {
        setTitle("Tic-Tac-Toe Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 10, 10));
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");
        add(loginButton);
        add(registerButton);
        add(exitButton);
        loginButton.addActionListener(e -> {
            new LoginView().setVisible(true);
            dispose();
        });
        registerButton.addActionListener(e -> {
            new RegisterView().setVisible(true);
            dispose();
        });
        exitButton.addActionListener(e -> System.exit(0));
    }
}