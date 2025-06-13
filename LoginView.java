import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
public class LoginView extends JFrame
{
    private JTextField emailField;
    private JPasswordField passwordField;
    public LoginView()
    {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(backButton);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            try {
                SqlTask queryTask = new SqlTask();
                int res = queryTask.UserAuthenticate(email, password);
                if (res == 1) {
                    JOptionPane.showMessageDialog(this, "Login successful!");
                    dispose();
                    // After login, show player selection
                    new PlayerSelectionView().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database error!");
            }
        });

        backButton.addActionListener(e -> {
            new MainMenuView().setVisible(true);
            dispose();
        });
    }
}