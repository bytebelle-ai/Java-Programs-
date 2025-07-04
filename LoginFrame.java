import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {
    // Components
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton okButton, resetButton;

    public LoginFrame() {
        // Frame title
        setTitle("Login");

        // Layout
        setLayout(new GridLayout(3, 2, 10, 10));

        // Components
        JLabel loginLabel = new JLabel("Login :");
        JLabel passwordLabel = new JLabel("Password :");
        loginField = new JTextField(10);
        passwordField = new JPasswordField(10);

        okButton = new JButton("OK");
        resetButton = new JButton("RESET");

        // Add action listeners
        okButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Add components
        add(loginLabel);
        add(loginField);
        add(passwordLabel);
        add(passwordField);
        add(okButton);
        add(resetButton);

        // Frame settings
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());
            // Placeholder: Validate login/password
            JOptionPane.showMessageDialog(this, "Login: " + login + "\nPassword: " + password);
        } else if (e.getSource() == resetButton) {
            loginField.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}

