package CBSV2Automation;

import java.awt.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDateTime;
import javax.swing.*;

import org.testng.TestNG;

public class LoginScreen {

    // Variable to store the currently logged-in user
    public static String RunUser = "Pritika Somase";

    // Method to run TestNG automation suite
    public static void Run() {
        try {
            TestNG testng = new TestNG();
            testng.setTestClasses(new Class[] { RunAutomation.class });
            testng.run();

            TestRunnerClass.GeneratePDFResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to hash the password using SHA-256
    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to create and run the login GUI
    public static void RunAutomationScript() {
        JFrame frame = new JFrame("User Login");
        frame.setSize(450, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = createLoginPanel(frame);
        frame.add(panel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createLoginPanel(JFrame frame) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel titleLabel = createTitleLabel();
        addTitleToPanel(panel, titleLabel, gbc);

        JTextField userText = new JTextField(17);
        JPasswordField passText = new JPasswordField(17);

        addFormFieldsToPanel(panel, gbc, userText, passText);
        addButtonsToPanel(panel, frame, gbc, userText, passText, titleLabel);

        return panel;
    }

    private static JLabel createTitleLabel() {
        JLabel titleLabel = new JLabel("User Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        return titleLabel;
    }

    private static void addTitleToPanel(JPanel panel, JLabel titleLabel, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
    }

    private static void addFormFieldsToPanel(JPanel panel, GridBagConstraints gbc, JTextField userText,
            JPasswordField passText) {
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        panel.add(userText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passLabel, gbc);

        gbc.gridx = 1;
        panel.add(passText, gbc);
    }

    private static void addButtonsToPanel(JPanel panel, JFrame frame, GridBagConstraints gbc, JTextField userText,
            JPasswordField passText, JLabel titleLabel) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));

        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(buttonPanel, gbc);

        exitButton.addActionListener(e -> System.exit(0));

        loginButton.addActionListener(e -> handleLogin(frame, userText, passText, titleLabel));
        passText.addActionListener(e -> handleLogin(frame, userText, passText, titleLabel));
    }

    private static void handleLogin(JFrame frame, JTextField userText, JPasswordField passText, JLabel titleLabel) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            try (Connection con = DriverManager.getConnection(url, "root", "Netwin@123");
                    PreparedStatement pstmt = con.prepareStatement(
                            "SELECT * FROM users WHERE User_Id = ? AND Password = ? AND Status = 'Active' AND Log_Level = '1'")) {

                String hashedPassword = hashPassword(new String(passText.getPassword()));
                if (hashedPassword == null) {
                    JOptionPane.showMessageDialog(frame, "Error hashing the password.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                pstmt.setString(1, userText.getText());
                pstmt.setString(2, hashedPassword);
                RunUser = userText.getText();

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        loginSuccessful(frame, con, userText, titleLabel);
                    } else {
                        JOptionPane.showMessageDialog(frame,
                                "<html><div style='padding: 15px;'><font color='red'>Access Denied...<br>Please enter the correct username and password.</font></div></html>",
                                "Login Failed", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "An unexpected error occurred: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private static void loginSuccessful(JFrame frame, Connection con, JTextField userText, JLabel titleLabel)
            throws SQLException {
        titleLabel.setText("Welcome, " + userText.getText() + "!");
        JOptionPane.showMessageDialog(frame,
                "<html><div style='padding: 15px;'><font color='green'>Access Granted...<br>Press Ok to Start Execution...</font></div></html>",
                "Login Successful", JOptionPane.INFORMATION_MESSAGE);

        String insertLogSql = "INSERT INTO Login_info (User_Id, LAST_LOGIN) VALUES (?, ?)";
        try (PreparedStatement logStmt = con.prepareStatement(insertLogSql)) {
            logStmt.setString(1, userText.getText());
            logStmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            logStmt.executeUpdate();
        }

        clearPasswordField(frame);
        AutomationDashboard.PropertiesFile();
    }

    private static void clearPasswordField(JFrame frame) {
        frame.dispose();
    }
}
