import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class RegisterView extends JFrame {
    private JTextField nameField, emailField;
    private JPasswordField passwordField;

    public RegisterView() {
        setTitle("Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);
        add(backButton);

        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            try {
                SqlTask registerTask = new SqlTask();
                registerTask.AddNewUsers(name, email, password);
                JOptionPane.showMessageDialog(this, "Registration successful!");
                dispose();
                new LoginView().setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Registration failed: " + ex.getMessage());
            }
        });

        backButton.addActionListener(e -> {
            new MainMenuView().setVisible(true);
            dispose();
        });
    }
}
