package CBSV2Automation;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.io.*;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Properties;

public class SuitDetailsForm extends Base {

    public static Properties properties = new Properties();
    public static String excelsheetname;

    public String config() throws UnsupportedEncodingException {

    	jarPath = new File(Base.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent();
        jarPath = URLDecoder.decode(jarPath, "UTF-8");
        String xlsxDirectory = new File(Base.class.getProtectionDomain().getCodeSource().getLocation().getPath())
                .getParent();
        xlsxDirectory = URLDecoder.decode(xlsxDirectory, "UTF-8");

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("data.properties")) {
            properties.load(input);

        } catch (IOException e) {
            System.err.println("Error loading properties files: " + e.getMessage());
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Configuration Form");
        frame.setFont(new Font("Arial", Font.BOLD, 26));

        frame.setSize(700, 725);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new BackgroundImage("bg images/pexels-codioful-7135020.jpg"));
        frame.getContentPane().setBackground(new Color(245, 255, 255, 245));
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JComboBox<String> browserCombo = new JComboBox<>(new String[] { "Firefox", "Chrome", "Edge", "Safari" });
        browserCombo.setSelectedItem(properties.getProperty("BrowserName", "Firefox"));

        JTextField applicationNameField = new JTextField(properties.getProperty("ApplicationName", "CBSV2"), 30);
        JTextField testSuitNameField = new JTextField(properties.getProperty("TestSuitName", ""), 30);
        JTextField urlField = new JTextField(properties.getProperty("LoginURL", ""), 30);
        JTextField userIdField = new JTextField(properties.getProperty("UserId", ""), 30);
        JPasswordField passwordField = new JPasswordField(properties.getProperty("Password", ""), 30);
        JTextField waitField = new JTextField(properties.getProperty("implicitwait", "10"), 30);
        JTextField testCaseStartField = new JTextField(properties.getProperty("TestCaseStart", "1"), 30);
        JTextField testCaseEndField = new JTextField(properties.getProperty("TestCaseEnd", "All"), 30);

        JTextArea textArea1 = new JTextArea();
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setEditable(false);
        textArea1.setBackground(new Color(255, 255, 255));
        textArea1.setPreferredSize(new Dimension(250, 100));
        textArea1.setFont(new Font("Arial", Font.BOLD, 12));
        textArea1.setEnabled(false);

        String formattedText = formatText(properties.getProperty("InputDataExcel", "No file selected"), 60);
        textArea1.setText(formattedText);

        JTextArea textArea2 = new JTextArea();
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        textArea2.setEditable(false);
        textArea2.setBackground(new Color(245, 245, 245));
        textArea2.setPreferredSize(new Dimension(250, 200));
        textArea2.setFont(new Font("Arial", Font.BOLD, 12));

        String formattedText1 = formatText(properties.getProperty("MetaDataExcel", "No file selected"), 60);
        textArea2.setText(formattedText1);

        JButton inputDataExcelButton = createExcelFileChooserButton(frame, "Select TestCases Excel Sheet.", properties,
                "InputDataExcel", xlsxDirectory, excelsheetname, textArea1, textArea2);
        JButton metaDataExcelButton = createExcelFileChooserButton1(frame, "Select Metadata Excel Sheet.", properties,
                "MetaDataExcel", xlsxDirectory, textArea2);

        applicationNameField.setEditable(false);
        testSuitNameField.setEditable(false);
        browserCombo.setEditable(false);
        urlField.setEditable(false);
        userIdField.setEditable(false);
        passwordField.setEditable(false);
        waitField.setEditable(false);
        testCaseStartField.setEditable(false);
        testCaseEndField.setEditable(false);
        inputDataExcelButton.setEnabled(false);
        metaDataExcelButton.setEnabled(false);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(new JLabel("Browser Name:"), gbc);
        gbc.gridx = 1;
        frame.add(browserCombo, gbc);

        addFieldToFrame(frame, gbc, "Application Name :", applicationNameField, 1);
        addFieldToFrame(frame, gbc, "Test Suit Name :", testSuitNameField, 2);
        addFieldToFrame(frame, gbc, "Login URL :", urlField, 4);
        addFieldToFrame(frame, gbc, "User ID :", userIdField, 5);
        addFieldToFrame(frame, gbc, "Password :", passwordField, 6);
        addFieldToFrame(frame, gbc, "Implicit Wait (seconds) :", waitField, 7);
        addFieldToFrame(frame, gbc, "Test Case Start :", testCaseStartField, 8);
        addFieldToFrame(frame, gbc, "Test Case End :", testCaseEndField, 9);
        addFieldToFrame(frame, gbc, "Test Cases Excel :", inputDataExcelButton, 10);
        // addFieldToFrame(frame, gbc, "Meta Data Excel :", metaDataExcelButton, 12);

        TextArea(frame, gbc, textArea1, 11);
        // TextArea(frame, gbc, textArea2, 13);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 1));
        buttonPanel.setFont(new Font("Arial", Font.BOLD, 16));
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

        JPanel buttonPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 1));
        buttonPanel1.setFont(new Font("Arial", Font.BOLD, 16));

        JButton saveButton = null, exitButton = null, Listbutton = null, newButton = null, editButton = null,
                searchButton = null, CancelButton = null;

        Listbutton = createListbutton(frame, properties, browserCombo, applicationNameField, testSuitNameField,
                urlField,
                userIdField, passwordField, waitField, testCaseStartField, testCaseEndField, textArea1,
                textArea2, xlsxDirectory, newButton, saveButton, exitButton, searchButton, editButton, CancelButton);

        exitButton = createexitButton(frame);

        saveButton = createSaveButton(frame, properties, browserCombo, applicationNameField, testSuitNameField,
                urlField, userIdField,
                passwordField, waitField, testCaseStartField, testCaseEndField, textArea1,
                textArea2, xlsxDirectory, newButton, editButton, exitButton, searchButton, Listbutton, CancelButton);

        String propertiesDirPath = xlsxDirectory + "\\Suits";
        searchButton = createSearchButton(frame, browserCombo, applicationNameField, testSuitNameField, urlField,
                userIdField, passwordField, waitField, testCaseStartField, testCaseEndField, textArea1,
                textArea2, propertiesDirPath, newButton, saveButton, exitButton, editButton, Listbutton);

        newButton = createNewButton(frame, browserCombo, applicationNameField, testSuitNameField, urlField,
                userIdField, passwordField, waitField, textArea1, textArea2, testCaseStartField, testCaseEndField,
                inputDataExcelButton, metaDataExcelButton, saveButton, editButton, exitButton, searchButton, Listbutton,
                CancelButton);

        editButton = createeditButton(frame, browserCombo, applicationNameField, testSuitNameField, urlField,
                userIdField, passwordField, waitField, testCaseStartField, testCaseEndField, textArea1, textArea2,
                inputDataExcelButton, metaDataExcelButton, newButton, saveButton, exitButton, searchButton, Listbutton,
                CancelButton);

        CancelButton = createCancelButton(frame, browserCombo, applicationNameField, testSuitNameField, urlField,
                userIdField, passwordField, waitField, textArea1, textArea2, testCaseStartField, testCaseEndField,
                inputDataExcelButton, metaDataExcelButton, saveButton, editButton, exitButton, searchButton, Listbutton,
                CancelButton);

        Listbutton = createListbutton(frame, properties, browserCombo, applicationNameField, testSuitNameField,
                urlField,
                userIdField, passwordField, waitField, testCaseStartField, testCaseEndField, textArea1,
                textArea2, xlsxDirectory, newButton, saveButton, exitButton, searchButton, editButton, CancelButton);

        exitButton = createexitButton(frame);

        saveButton = createSaveButton(frame, properties, browserCombo, applicationNameField, testSuitNameField,
                urlField, userIdField,
                passwordField, waitField, testCaseStartField, testCaseEndField, textArea1,
                textArea2, xlsxDirectory, newButton, editButton, exitButton, searchButton, Listbutton, CancelButton);

        searchButton = createSearchButton(frame, browserCombo, applicationNameField, testSuitNameField, urlField,
                userIdField, passwordField, waitField, testCaseStartField, testCaseEndField, textArea1,
                textArea2, propertiesDirPath, newButton, saveButton, exitButton, editButton, Listbutton);

        newButton = createNewButton(frame, browserCombo, applicationNameField, testSuitNameField, urlField,
                userIdField, passwordField, waitField, textArea1, textArea2, testCaseStartField, testCaseEndField,
                inputDataExcelButton, metaDataExcelButton, saveButton, editButton, exitButton, searchButton, Listbutton,
                CancelButton);

        editButton = createeditButton(frame, browserCombo, applicationNameField, testSuitNameField, urlField,
                userIdField, passwordField, waitField, testCaseStartField, testCaseEndField, textArea1, textArea2,
                inputDataExcelButton, metaDataExcelButton, newButton, saveButton, exitButton, searchButton, Listbutton,
                CancelButton);

        CancelButton = createCancelButton(frame, browserCombo, applicationNameField, testSuitNameField, urlField,
                userIdField, passwordField, waitField, textArea1, textArea2, testCaseStartField, testCaseEndField,
                inputDataExcelButton, metaDataExcelButton, saveButton, editButton, exitButton, searchButton, Listbutton,
                CancelButton);

        buttonPanel.add(newButton);
        buttonPanel.add(editButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(saveButton);
        // buttonPanel.add(Listbutton);
        buttonPanel.add(CancelButton);
        buttonPanel.add(exitButton);

        saveButton.setEnabled(false);
        newButton.setEnabled(true);
        Listbutton.setEnabled(false);
        editButton.setEnabled(true);
        exitButton.setEnabled(true);
        searchButton.setEnabled(true);
        CancelButton.setEnabled(false);

        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(buttonPanel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(buttonPanel1, gbc);

        JLabel titleLabel = new JLabel("Configuration Form", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(new Color(00, 00, 63));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(titleLabel, gbc);

        SwingUtilities.invokeLater(() -> {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        return "false";
    }

    private static JButton createeditButton(JFrame frame, JComboBox<String> browserCombo,
            JTextField applicationNameField, JTextField testSuitNameField, JTextField urlField, JTextField userIdField,
            JPasswordField passwordField,
            JTextField waitField, JTextField testCaseStartField, JTextField testCaseEndField, JTextArea textArea1,
            JTextArea textArea2, JButton inputDataExcelButton, JButton metaDataExcelButton,
            JButton newButton, JButton saveButton, JButton exitButton, JButton searchButton, JButton Listbutton,
            JButton CancelButton) {
        JButton editButton = new JButton("Edit");
        editButton.setFont(new Font("Arial", Font.BOLD, 12));
        editButton.setBackground(new Color(70, 130, 180)); // Steel blue
        editButton.setForeground(Color.WHITE);
        editButton.setPreferredSize(new Dimension(80, 32));
        editButton.addActionListener(e -> {

            applicationNameField.setEditable(true);
            testSuitNameField.setEditable(true);
            browserCombo.setEditable(true);
            urlField.setEditable(true);
            userIdField.setEditable(true);
            passwordField.setEditable(true);
            testCaseStartField.setEditable(true);
            testCaseEndField.setEditable(true);
            waitField.setEditable(true);
            textArea1.setEnabled(true);
            textArea2.setEnabled(true);
            inputDataExcelButton.setEnabled(true);
            metaDataExcelButton.setEnabled(true);

            saveButton.setEnabled(true);
            newButton.setEnabled(false);
            Listbutton.setEnabled(false);
            exitButton.setEnabled(true);
            searchButton.setEnabled(false);
            CancelButton.setEnabled(true);
            editButton.setEnabled(false);

        });
        return editButton;
    }

    private static JButton createListbutton(JFrame frame, Properties properties, JComboBox<String> browserCombo,
            JTextField ApplicationName, JTextField TestSuitName, JTextField urlField, JTextField userIdField,
            JPasswordField passwordField,
            JTextField waitField, JTextField testCaseStartField, JTextField testCaseEndField, JTextArea textArea1,
            JTextArea textArea2,
            String directory, JButton newButton, JButton saveButton, JButton exitButton, JButton searchButton,
            JButton editButton, JButton CancelButton) {
        JButton Listbutton = new JButton("Execute");
        Listbutton.setFont(new Font("Arial", Font.BOLD, 12));
        Listbutton.setBackground(new Color(70, 130, 180));
        Listbutton.setForeground(Color.WHITE);
        Listbutton.setPreferredSize(new Dimension(80, 32));

        Listbutton.addActionListener(e -> {

            saveButton.setEnabled(false);
            newButton.setEnabled(false);
            editButton.setEnabled(false);
            exitButton.setEnabled(true);
            searchButton.setEnabled(false);
            CancelButton.setEnabled(true);

            if (validateFields(frame, TestSuitName, ApplicationName, browserCombo, urlField, userIdField, passwordField,
                    waitField,
                    testCaseStartField, testCaseEndField, textArea1, textArea2)) {
                try {
                    properties.setProperty("ApplicationName", ApplicationName.getText());
                    properties.setProperty("TestSuitName", TestSuitName.getText());
                    properties.setProperty("BrowserName", (String) browserCombo.getSelectedItem());
                    properties.setProperty("LoginURL", urlField.getText());
                    properties.setProperty("UserId", userIdField.getText());
                    properties.setProperty("Password", String.valueOf(passwordField.getPassword()));
                    properties.setProperty("implicitwait", waitField.getText());
                    // properties.setProperty("Execution_Start_End", executionField.getText());
                    properties.setProperty("TestCaseStart", testCaseStartField.getText());
                    properties.setProperty("TestCaseEnd", testCaseEndField.getText());

                    try (BufferedWriter writer = new BufferedWriter(
                            new FileWriter(directory + "/Suits/" + TestSuitName.getText() + ".properties"))) {
                        properties.store(writer, "Configuration Properties");
                        JOptionPane.showMessageDialog(frame, "Configuration Saved Successfully!");
                        Thread.sleep(500);
                        frame.dispose();
                        LoginScreen.Run();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error Saving Configuration: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return Listbutton;
    }

    private static JButton createCancelButton(JFrame frame, JComboBox<String> browserCombo,
            JTextField applicationNameField,
            JTextField testSuitNameField, JTextField urlField, JTextField userIdField, JPasswordField passwordField,
            JTextField waitField, JTextArea textArea1, JTextArea textArea2, JTextField testCaseStartField,
            JTextField testCaseEndField,
            JButton inputDataExcelButton, JButton metaDataExcelButton,
            JButton saveButton, JButton editButton, JButton exitButton, JButton searchButton, JButton Listbutton,
            JButton newButton) {
        JButton CancelButton = new JButton("Cancel");
        CancelButton.setFont(new Font("Arial", Font.BOLD, 12));
        CancelButton.setBackground(new Color(70, 130, 180)); // Steel blue
        CancelButton.setForeground(Color.WHITE);
        CancelButton.setPreferredSize(new Dimension(80, 32));
        CancelButton.addActionListener(e -> {

            browserCombo.setSelectedIndex(0);
            applicationNameField.setText("");
            testSuitNameField.setText("");
            urlField.setText("");
            userIdField.setText("");
            testCaseStartField.setText("");
            waitField.setText("");
            textArea1.setText("");
            textArea2.setText("");
            inputDataExcelButton.setText("No file selected");
            metaDataExcelButton.setText("No file selected");
            passwordField.setText("");

            newButton.setEnabled(true);
            searchButton.setEnabled(true);
            saveButton.setEnabled(true);
            Listbutton.setEnabled(true);
            editButton.setEnabled(true);
            exitButton.setEnabled(true);
            CancelButton.setEnabled(true);

        });
        return CancelButton;
    }

    private static JButton createNewButton(JFrame frame, JComboBox<String> browserCombo,
            JTextField applicationNameField,
            JTextField testSuitNameField, JTextField urlField, JTextField userIdField, JPasswordField passwordField,
            JTextField waitField,
            JTextArea textArea1, JTextArea textArea2, JTextField testCaseStartField, JTextField testCaseEndField,
            JButton inputDataExcelButton, JButton metaDataExcelButton,
            JButton saveButton, JButton editButton, JButton exitButton, JButton searchButton, JButton Listbutton,
            JButton CancelButton) {
        JButton newButton = new JButton("New");
        newButton.setFont(new Font("Arial", Font.BOLD, 12));
        newButton.setBackground(new Color(70, 130, 180)); // Steel blue
        newButton.setForeground(Color.WHITE);
        newButton.setPreferredSize(new Dimension(80, 32));
        newButton.addActionListener(e -> {

            browserCombo.setSelectedIndex(0);
            applicationNameField.setText("");
            testSuitNameField.setText("");
            urlField.setText("");
            userIdField.setText("");
            testCaseStartField.setText("");
            waitField.setText("");
            textArea1.setText("");
            textArea2.setText("");
            inputDataExcelButton.setText("No file selected");
            metaDataExcelButton.setText("No file selected");
            passwordField.setText("");

            applicationNameField.setEditable(true);
            testSuitNameField.setEditable(true);
            browserCombo.setEditable(true);
            urlField.setEditable(true);
            userIdField.setEditable(true);
            passwordField.setEditable(true);
            testCaseStartField.setEditable(true);
            testCaseEndField.setEditable(true);
            waitField.setEditable(true);
            textArea1.setEnabled(true);
            textArea2.setEnabled(true);
            inputDataExcelButton.setEnabled(true);
            metaDataExcelButton.setEnabled(true);

            searchButton.setEnabled(false);
            saveButton.setEnabled(true);
            Listbutton.setEnabled(true);
            editButton.setEnabled(false);
            CancelButton.setEnabled(true);
            exitButton.setEnabled(true);
        });
        return newButton;
    }

    private static JButton createSearchButton(JFrame frame, JComboBox<String> browserCombo,
            JTextField applicationNameField,
            JTextField testSuitNameField, JTextField urlField, JTextField userIdField,
            JPasswordField passwordField, JTextField waitField, JTextField testCaseStartField,
            JTextField testCaseEndField, JTextArea textArea1, JTextArea textArea2, String propertiesDirPath,
            JButton editButton, JButton saveButton, JButton exitButton, JButton Listbutton, JButton CancelButton) {

        // Create Search button to be placed outside the form
        JButton newButton = new JButton("Search");
        newButton.setFont(new Font("Arial", Font.BOLD, 12));
        newButton.setBackground(new Color(70, 130, 180)); // Steel blue
        newButton.setForeground(Color.WHITE);
        newButton.setPreferredSize(new Dimension(80, 32));

        // Action when the search button is clicked
        newButton.addActionListener(e -> {
            try {
                // Create a panel for the search form (without the search button)
                JPanel searchPanel = new JPanel();
                searchPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for better control
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components
                gbc.anchor = GridBagConstraints.WEST; // Align components to the left

                // Add components to the panel with GridBagLayout
                JLabel appLabel = new JLabel("Enter Application Name:");
                gbc.gridx = 0;
                gbc.gridy = 0;
                searchPanel.add(appLabel, gbc);

                JTextField appField = new JTextField(20);
                gbc.gridx = 1;
                gbc.gridy = 0;
                searchPanel.add(appField, gbc);

                JLabel suitLabel = new JLabel("Enter Test Suit Name:");
                gbc.gridx = 0;
                gbc.gridy = 1;
                searchPanel.add(suitLabel, gbc);

                JTextField suitField = new JTextField(20);
                gbc.gridx = 1;
                gbc.gridy = 1;
                searchPanel.add(suitField, gbc);

                // Show search form in a dialog box
                int option = JOptionPane.showConfirmDialog(frame, searchPanel, "Search Criteria",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (option == JOptionPane.OK_OPTION) {
                    String applicationName = appField.getText().trim();
                    String testSuitName = suitField.getText().trim();

                    if ((applicationName.isEmpty() && testSuitName.isEmpty())) {
                        JOptionPane.showMessageDialog(frame, "Both Application Name and Suit Name cannot be empty.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    File dir = new File(propertiesDirPath);
                    File[] files = dir.listFiles((d, name) -> name.endsWith(".properties"));

                    if (files == null || files.length == 0) {
                        JOptionPane.showMessageDialog(frame, "No property files found in the directory.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Filter files based on the given criteria: both Application Name and Test Suit
                    // Name
                    List<String> matchingFiles = new ArrayList<>();
                    for (File file : files) {
                        Properties properties = new Properties();
                        try (FileInputStream fis = new FileInputStream(file)) {
                            properties.load(fis);
                        } catch (IOException ex) {
                            continue; // Skip unreadable files
                        }

                        String appNameInFile = properties.getProperty("ApplicationName", "").toLowerCase();
                        String testSuitInFile = properties.getProperty("TestSuitName", "").toLowerCase();

                        // Check if both criteria match (ignore case)
                        if ((applicationName.isEmpty() || appNameInFile.contains(applicationName.toLowerCase())) &&
                                (testSuitName.isEmpty() || testSuitInFile.contains(testSuitName.toLowerCase()))) {
                            matchingFiles.add(file.getName());
                        }
                    }

                    if (matchingFiles.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "No matching files found.", "No Match",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Create a list to display matching suits
                        JList<String> list = new JList<>(matchingFiles.toArray(new String[0]));
                        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        JScrollPane scrollPane = new JScrollPane(list);

                        // Display the list of matching files
                        int result = JOptionPane.showConfirmDialog(frame, scrollPane, "Select a Suit File",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (result == JOptionPane.OK_OPTION) {
                            String selectedFile = list.getSelectedValue();
                            if (selectedFile != null) {
                                File propertiesFile = new File(propertiesDirPath + "/" + selectedFile);
                                Properties selectedProperties = new Properties();
                                try (FileInputStream fis = new FileInputStream(propertiesFile)) {
                                    selectedProperties.load(fis);
                                }

                                selectedFile = selectedFile.replace(".properties", "");

                                // Populate fields with properties
                                String browser = selectedProperties.getProperty("BrowserName");
                                String url = selectedProperties.getProperty("LoginURL");
                                String userId = selectedProperties.getProperty("UserId");
                                String password = selectedProperties.getProperty("Password");
                                String wait = selectedProperties.getProperty("implicitwait");
                                String testCaseStart = selectedProperties.getProperty("TestCaseStart");
                                String testCaseEnd = selectedProperties.getProperty("TestCaseEnd");
                                String InputDataExcel = selectedProperties.getProperty("InputDataExcel");
                                String MetaDataExcel = selectedProperties.getProperty("MetaDataExcel");

                                if (!browser.isEmpty() && !url.isEmpty()) {
                                    browserCombo.setSelectedItem(browser);
                                    testSuitNameField.setText(selectedFile);
                                    urlField.setText(url);
                                    userIdField.setText(userId);
                                    passwordField.setText(password);
                                    waitField.setText(wait);
                                    testCaseStartField.setText(testCaseStart);
                                    testCaseEndField.setText(testCaseEnd);
                                    textArea1.setText(InputDataExcel);
                                    textArea2.setText(MetaDataExcel);
                                }
                            }
                        }
                    }
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error loading properties file: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        return newButton;
    }

    private static JButton createExcelFileChooserButton(JFrame frame, String title, Properties properties,
            String propertyKey, String directory, String excelsname, JTextArea textArea1, JTextArea textArea2) {
        JButton button = new JButton(title);
        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(directory + "/Test Cases Sheets");
            fileChooser.setDialogTitle(title);
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files", "xlsx"));

            if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File[] selectedFiles = fileChooser.getSelectedFiles();
                String[] fileNames = Arrays.stream(selectedFiles).map(File::getName).toArray(String[]::new);
                properties.setProperty(propertyKey, String.join(",", fileNames));
                button.setFont(new Font("Arial", Font.PLAIN, 14));
                button.setText("Following Sheets are Selected ");
                textArea1.setText(String.join(", ", fileNames));
                textArea2.setText(String.join(", ", fileNames));
            }
        });
        return button;
    }

    private static JButton createExcelFileChooserButton1(JFrame frame, String title, Properties properties,
            String propertyKey, String directory, JTextArea textArea2) {

        JButton button = new JButton(title);
        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(directory + "/MetaData Sheets");
            fileChooser.setDialogTitle(title);
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files", "xlsx"));

            if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File[] selectedFiles = fileChooser.getSelectedFiles();
                String[] fileNames = Arrays.stream(selectedFiles).map(File::getName).toArray(String[]::new);
                properties.setProperty(propertyKey, String.join(",", fileNames));
                button.setFont(new Font("Arial", Font.PLAIN, 14));
                button.setText("Following Sheets are Selected ");
                textArea2.setText(String.join(", ", fileNames));
            }
        });
        return button;
    }

    private static JButton createSaveButton(JFrame frame, Properties properties, JComboBox<String> browserCombo,
            JTextField ApplicationName, JTextField TestSuitName, JTextField urlField, JTextField userIdField,
            JPasswordField passwordField,
            JTextField waitField, JTextField testCaseStartField, JTextField testCaseEndField, JTextArea textArea1,
            JTextArea textArea2,
            String directory, JButton newButton, JButton editButton, JButton exitButton, JButton searchButton,
            JButton Listbutton, JButton CancelButton) {
        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.BOLD, 12));
        saveButton.setBackground(new Color(70, 130, 180));
        saveButton.setPreferredSize(new Dimension(80, 32));
        saveButton.setForeground(Color.WHITE);
        saveButton.addActionListener(e -> {

            ApplicationName.setEnabled(true);
            TestSuitName.setEnabled(true);
            browserCombo.setEnabled(true);
            urlField.setEnabled(true);
            userIdField.setEnabled(true);
            passwordField.setEnabled(true);
            waitField.setEnabled(true);
            testCaseStartField.setEnabled(true);
            testCaseEndField.setEnabled(true);
            textArea1.setEnabled(true);
            textArea2.setEnabled(true);

            newButton.setEnabled(true);
            // Listbutton.setEnabled(false);
            editButton.setEnabled(true);
            exitButton.setEnabled(true);
            searchButton.setEnabled(true);
            CancelButton.setEnabled(true);
            saveButton.setEnabled(true);

            if (validateFields(frame, TestSuitName, ApplicationName, browserCombo, urlField, userIdField, passwordField,
                    waitField, testCaseStartField, testCaseEndField, textArea1, textArea2)) {
                try {
                    properties.setProperty("ApplicationName", ApplicationName.getText());
                    properties.setProperty("TestSuitName", TestSuitName.getText());
                    properties.setProperty("BrowserName", (String) browserCombo.getSelectedItem());
                    properties.setProperty("LoginURL", urlField.getText());
                    properties.setProperty("UserId", userIdField.getText());
                    properties.setProperty("Password", String.valueOf(passwordField.getPassword()));
                    properties.setProperty("implicitwait", waitField.getText());
                    properties.setProperty("TestCaseStart", testCaseStartField.getText());
                    properties.setProperty("TestCaseEnd", testCaseEndField.getText());
                    properties.setProperty("InputDataExcel", textArea1.getText());
                    properties.setProperty("MetaDataExcel", textArea2.getText());

                    try (BufferedWriter writer = new BufferedWriter(
                            new FileWriter(directory + "/Suits/" + TestSuitName.getText() + ".properties"))) {
                        properties.store(writer, "Configuration Properties");
                        JOptionPane.showMessageDialog(frame,
                                "Configuration Saved Successfully With Suit Name :  " + TestSuitName.getText());
                        Thread.sleep(500);

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error Saving Configuration: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return saveButton;
    }

    private static JButton createexitButton(JFrame currentFrame) {
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 12));
        exitButton.setBackground(new Color(70, 130, 180));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBorderPainted(false);
        exitButton.setPreferredSize(new Dimension(80, 32));
        exitButton.addActionListener(e -> currentFrame.dispose());
        return exitButton;
    }

    private static void addFieldToFrame(JFrame frame, GridBagConstraints gbc, String label, JComponent field, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        frame.add(field, gbc);
    }

    private static void TextArea(JFrame frame, GridBagConstraints gbc, JComponent field, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridx = 1;
        frame.add(field, gbc);
    }

    private static boolean validateFields(JFrame frame, JTextField testSuitNameField, JTextField applicationNameField,
            JComboBox<String> browserCombo, JTextField urlField, JTextField userIdField,
            JPasswordField passwordField, JTextField waitField, JTextField testCaseStartField,
            JTextField testCaseEndField, JTextArea textArea1, JTextArea textArea2) {
        // Check if Application Name is empty

        if (applicationNameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Application Name cannot be empty.", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if Test Suite Name is empty
        if (testSuitNameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Test Suite Name cannot be empty.", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        
        File suitsFolder = new File(jarPath + File.separator + "Suits");
        if (suitsFolder.exists() && suitsFolder.isDirectory()) {
            File[] files = suitsFolder.listFiles((dir, name) -> name.endsWith(".properties"));

            if (files != null) {
                for (File file : files) {
                    String existingSuiteName = file.getName().replace(".properties", "");

                    // Compare with entered suite name
                    if (existingSuiteName.equalsIgnoreCase(testSuitNameField.getText())) {
                        JOptionPane.showMessageDialog(frame, "Test Suite Name already exists. Please choose a different name.",
                                "Validation Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
            }
        }
        
        // Validate Browser selection
        if (browserCombo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(frame, "Please select a browser.", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if URL is empty
        if (urlField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Login URL cannot be empty.", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if User ID is empty
        if (userIdField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "User ID cannot be empty.", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if Password is empty
        if (new String(passwordField.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Password cannot be empty.", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Implicit Wait field (should be between 1 and 20)
        try {
            int waitTime = Integer.parseInt(waitField.getText().trim());

            // Check if the wait time is within the valid range
            if (waitTime < 1 || waitTime > 20) {
                JOptionPane.showMessageDialog(frame, "Implicit Wait must be between 1 and 20.", "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            // Handle invalid number format
            JOptionPane.showMessageDialog(frame, "Implicit Wait must be a valid integer.", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Test Case Start and End fields
        // Validate Test Case Start
        String startText = testCaseStartField.getText().trim();
        if (!startText.matches("\\d+")) {
            JOptionPane.showMessageDialog(frame, "Test Case Start must be a numeric value.", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int testCaseStart = Integer.parseInt(startText);
        if (testCaseStart <= 0) {
            JOptionPane.showMessageDialog(frame, "Test Case Start must be 1 or greater.", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate Test Case End
        String endText = testCaseEndField.getText().trim();
        if (!endText.matches("\\d+|All")) {
            JOptionPane.showMessageDialog(frame, "Test Case End must be a numeric value or 'All'.", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!endText.equals("All")) {
            int testCaseEnd = Integer.parseInt(endText);

            // Test Case End must be greater than or equal to Test Case Start
            if (testCaseEnd < testCaseStart) {
                JOptionPane.showMessageDialog(frame, "Test Case End must be greater than or equal to Test Case Start.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Validate that textArea1 is not blank
        String text1 = textArea1.getText().trim();
        if (text1.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please Select Test Cases sheet. ", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate that textArea2 is not blank
        String text2 = textArea2.getText().trim();
        if (text2.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please Select Metadata sheet. ", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate that all characters in textArea1 are contained in textArea2
        for (char ch : text1.toCharArray()) {
            if (!text2.contains(String.valueOf(ch))) {
                JOptionPane.showMessageDialog(frame, "Sheets Selected for Test Cases Same Sheets Select for Matadata.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        // All validations passed
        return true;
    }

    private static String formatText(String text, int lineLength) {
        StringBuilder formatted = new StringBuilder();
        int index = 0;

        while (index < text.length()) {
            // Calculate the end index for the substring
            int end = Math.min(index + lineLength, text.length());
            formatted.append(text, index, end).append("\n");
            index = end;
        }
        return formatted.toString().trim();
    }
}
