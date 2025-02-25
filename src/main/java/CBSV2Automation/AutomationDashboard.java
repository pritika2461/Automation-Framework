package CBSV2Automation;

import javax.swing.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

public class AutomationDashboard extends Base {
    public static JPanel contentPanel;
    static String jarPath = new File(
            AutomationDashboard.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent();
    static JFrame frame;

    public static void PropertiesFile() {
        frame = new JFrame("Properties Files Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new BackgroundImage("bg images/images.jpg"));
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 25, 10, 25);

        JLabel titleLabel1 = new JLabel("Automation Testing Dashboard", SwingConstants.CENTER);
        titleLabel1.setFont(new Font("Roboto", Font.BOLD, 32));
        titleLabel1.setForeground(new Color(0, 0, 63));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(titleLabel1, gbc);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.setBackground(new Color(246, 255, 255, 10));
        JButton configButton = createButton("Create New Suit");
        configButton.addActionListener(e -> {
            SuitDetailsForm config = new SuitDetailsForm();
            try {
                config.config();
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        });

        JButton testSuitListButton = createButton("Test Suit List");
        testSuitListButton.addActionListener(e -> {
            try {
                showSuitList(frame);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        });

        topPanel.add(configButton);
        topPanel.add(testSuitListButton);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(topPanel, gbc);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(15, 15));
        contentPanel.setBackground(new Color(250, 245, 245, 180));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(50, 8, 8, 0);
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(contentPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.setVisible(true);
    }

    private static void showSuitList(JFrame frame) throws UnsupportedEncodingException {
        contentPanel.removeAll();
        contentPanel.revalidate();
        contentPanel.repaint();

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JLabel searchLabel = new JLabel("Search Suit: ");
        searchLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
        JTextField searchField = new JTextField(20);
        JButton searchButton = createButton("Search");
        searchButton.setBackground(Color.GRAY);
        searchButton.setPreferredSize(new Dimension(90, 32));

        searchButton.addActionListener(e -> {
            String searchQuery = searchField.getText().toLowerCase();
            try {
                displaySuits(frame, searchQuery);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        });

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        contentPanel.add(searchPanel, BorderLayout.NORTH);
        displaySuits(frame, "");
    }

    private static void displaySuits(JFrame frame, String query) throws UnsupportedEncodingException {
        JPanel suitPanel = new JPanel();
        suitPanel.setLayout(new BoxLayout(suitPanel, BoxLayout.Y_AXIS));
        List<JCheckBox> checkBoxes = new ArrayList<>();
        List<String> suitNames = new ArrayList<>();
        List<File> filteredFiles = new ArrayList<>();

        jarPath = URLDecoder.decode(jarPath, "UTF-8");
        String xlsxDirectory = jarPath + "//Suits";

        File folder = new File(xlsxDirectory);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".properties"));

        contentPanel.removeAll(); // Clear previous content
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        searchPanel.setBackground(new Color(245, 245, 255, 255));

        JLabel searchLabel = new JLabel("Search Suit: ");
        searchLabel.setFont(new Font("Roboto", Font.BOLD, 16));
        JTextField searchField = new JTextField(20);
        JButton searchButton = createButton("Search");
        searchButton.setBackground(Color.GRAY);
        searchButton.setPreferredSize(new Dimension(90, 32));

        // Action listener for search button
        searchButton.addActionListener(e -> {
            String searchQuery = searchField.getText().toLowerCase();
            try {
                displaySuits(frame, searchQuery);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        });

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        contentPanel.add(searchPanel, BorderLayout.NORTH);

        if (files != null && files.length > 0) {
            JPanel selectAllPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JCheckBox selectAllCheckBox = new JCheckBox(" Select All Suits To Run ");
            selectAllPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            selectAllCheckBox.setFont(new Font("Roboto", Font.BOLD, 14));
            selectAllPanel.add(selectAllCheckBox);
            selectAllPanel.setBackground(new Color(255, 255, 255));
            suitPanel.add(selectAllPanel);

            // Action listener for "Select All" checkbox
            selectAllCheckBox.addActionListener(e -> {
                boolean selectAll = selectAllCheckBox.isSelected();
                for (JCheckBox checkBox : checkBoxes) {
                    checkBox.setSelected(selectAll);
                }
            });

            // Iterate over the files to create a checkbox with the suit name as the label
            for (int i = 0; i < files.length; i++) {
                String suitName = files[i].getName().replaceFirst("[.][^.]+$", ""); // Remove file extension

                if (suitName.toLowerCase().contains(query)) {
                    suitNames.add(suitName);
                    filteredFiles.add(files[i]); // Track filtered files after search

                    // Create a checkbox for each suit with the suit name as its label
                    JCheckBox checkBox = new JCheckBox(suitName);
                    checkBox.setFont(new Font("Roboto", Font.PLAIN, 14)); // Customize font for suit name
                    checkBoxes.add(checkBox);

                    // Panel for checkbox layout with standard styling
                    JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    checkBoxPanel.setBackground(new Color(255, 255, 255));
                    checkBoxPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                    checkBoxPanel.add(checkBox);

                    suitPanel.add(checkBoxPanel);
                }
            }

            if (suitNames.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please Enter Valid Suit Name",
                        "No Results", JOptionPane.INFORMATION_MESSAGE);
            }

            // Execute button for selection
            JButton executeButton = new JButton("Execute Selected Suit");
            executeButton.setBackground(Color.DARK_GRAY);
            executeButton.setFont(new Font("Roboto", Font.BOLD, 13));
            executeButton.setForeground(Color.WHITE);
            executeButton.setFocusPainted(false);
            executeButton.setPreferredSize(new Dimension(165, 38));
            executeButton.setMargin(new Insets(10, 20, 10, 20));
            executeButton.setBorder(BorderFactory.createLineBorder(new Color(245, 255, 255, 200)));
            executeButton.setBorderPainted(true);

            JButton DeleteButton = createButton("Delete Selected Suits");
            DeleteButton.setBackground(Color.DARK_GRAY);
            DeleteButton.setFont(new Font("Roboto", Font.BOLD, 13));
            DeleteButton.setForeground(Color.WHITE);
            DeleteButton.setFocusPainted(false);
            DeleteButton.setPreferredSize(new Dimension(165, 38));
            DeleteButton.setMargin(new Insets(10, 20, 10, 20));
            DeleteButton.setBorder(BorderFactory.createLineBorder(new Color(245, 255, 255, 200)));
            DeleteButton.setBorderPainted(true);

            JButton RunTestCase = createButton("Run Specific Cases");
            RunTestCase.setBackground(Color.DARK_GRAY);
            RunTestCase.setFont(new Font("Roboto", Font.BOLD, 13));
            RunTestCase.setForeground(Color.WHITE);
            RunTestCase.setFocusPainted(false);
            RunTestCase.setPreferredSize(new Dimension(165, 38));
            RunTestCase.setMargin(new Insets(10, 20, 10, 20));
            RunTestCase.setBorder(BorderFactory.createLineBorder(new Color(245, 255, 255, 200)));
            RunTestCase.setBorderPainted(true);

            RunTestCase.addActionListener(e -> {
                RunTestCaseFlag = "Yes";
                List<Integer> selectedIndices = new ArrayList<>();
                List<String> selectedSuitNames = new ArrayList<>();

                for (int i = 0; i < checkBoxes.size(); i++) {
                    if (checkBoxes.get(i).isSelected()) {
                        selectedIndices.add(i);
                        selectedSuitNames.add(suitNames.get(i));
                    }
                }

                // Validate that only one suit is selected
                if (selectedIndices.size() != 1) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Please select exactly one suit to proceed.",
                            "Selection Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Get the selected suit and its subsheets
                int selectedIndex = selectedIndices.get(0);
                String selectedSuit = selectedSuitNames.get(0); // This is the selected suit name
                List<String> subsheets = new ArrayList<>();

                try {
                    String propertiesFileName = filteredFiles.get(selectedIndex).getName();
                    String excelSheetName = loadExcelSheetName(propertiesFileName);

                    if (excelSheetName != null && !excelSheetName.isEmpty()) {
                        subsheets = fetchSubsheets(excelSheetName.trim());
                    }
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(
                            frame,
                            "Error fetching subsheets.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (subsheets.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "No subsheets found for the selected suit.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Create the form JFrame
                JFrame formFrame = new JFrame("Run Specific Test");
                formFrame.setSize(420, 360);
                formFrame.setResizable(false);
                formFrame.setLocationRelativeTo(null);
                formFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel formPanel = new JPanel();
                formPanel.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 5); // Add padding around components

                // Title label
                JLabel titleLabel = new JLabel("Select Subsheet To Run Specific Cases");
                titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

                // Subsheets dropdown
                JLabel subsheetLabel = new JLabel("Select Subsheet:");
                JComboBox<String> subsheetComboBox = new JComboBox<>(subsheets.toArray(new String[0]));

                // Test start and end input
                JLabel startLabel = new JLabel("Enter Start Value:");
                JTextField startField = new JTextField(15);

                JLabel endLabel = new JLabel("Enter End Value:");
                JTextField endField = new JTextField(15);

                // Radio buttons for case selection
                JRadioButton runAllCasesRadio = new JRadioButton("Run All Cases");
                JRadioButton runFailCasesRadio = new JRadioButton("Run Only Fail Cases");
                ButtonGroup caseSelectionGroup = new ButtonGroup();
                caseSelectionGroup.add(runAllCasesRadio);
                caseSelectionGroup.add(runFailCasesRadio);
                runAllCasesRadio.setSelected(true);

                // Buttons
                JButton runButton = new JButton("Execute");
                runButton.setPreferredSize(new Dimension(120, 32));
                runButton.setFont(new Font("Roboto", Font.BOLD, 12));
                runButton.setBackground(new Color(70, 130, 180));
                runButton.setForeground(Color.WHITE);

                JButton cancelButton = new JButton("Stop Execution");
                cancelButton.setPreferredSize(new Dimension(120, 32));
                cancelButton.setFont(new Font("Roboto", Font.BOLD, 12));
                cancelButton.setBackground(new Color(70, 130, 180));
                cancelButton.setForeground(Color.WHITE);
                cancelButton.setEnabled(false);

                // Action listener to stop execution
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (driver != null) {
                            driver.quit(); // Close the browser and end WebDriver session
                            System.out.println("Automation execution stopped.");
                        }
                    }
                });

                pauseButton = new JButton("Pause/Resume");
                pauseButton.setPreferredSize(new Dimension(120, 32));
                pauseButton.setFont(new Font("Roboto", Font.BOLD, 12));
                pauseButton.setBackground(new Color(70, 130, 180));
                pauseButton.setForeground(Color.WHITE);
                pauseButton.setEnabled(false);

                pauseButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PauseResumeAutomation.togglePause();
                    }
                });

                // Add components to the form panel
                gbc.gridwidth = 2;
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.CENTER;
                formPanel.add(titleLabel, gbc);

                gbc.gridwidth = 1; // Reset grid width
                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 0;
                gbc.gridy = 1;
                formPanel.add(subsheetLabel, gbc);

                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 1;
                formPanel.add(subsheetComboBox, gbc);

                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 0;
                gbc.gridy = 2;
                formPanel.add(startLabel, gbc);

                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 1;
                formPanel.add(startField, gbc);

                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 0;
                gbc.gridy = 3;
                formPanel.add(endLabel, gbc);

                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridx = 1;
                formPanel.add(endField, gbc);

                // Add radio buttons
                gbc.gridx = 0;
                gbc.gridy = 4;
                formPanel.add(runAllCasesRadio, gbc);

                gbc.gridx = 1;
                gbc.gridy = 4;
                formPanel.add(runFailCasesRadio, gbc);

                // Add buttons
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(runButton);
                buttonPanel.add(cancelButton);
                buttonPanel.add(pauseButton);

                gbc.gridx = 0;
                gbc.gridy = 5;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;
                formPanel.add(buttonPanel, gbc);

                // Add the form panel to the frame
                formFrame.add(formPanel);
                formFrame.setVisible(true);

                // Action listeners for buttons
                runButton.addActionListener(event -> {
                    String selectedSubsheet = (String) subsheetComboBox.getSelectedItem();
                    int selectedSubsheetIndex = subsheetComboBox.getSelectedIndex();
                    String startValue = startField.getText().trim();
                    String endValue = endField.getText().trim();

                    // Validate inputs
                    if (startValue.isEmpty() || endValue.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                formFrame,
                                "Please fill in all fields.",
                                "Validation Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        FlagTeststart = Integer.parseInt(startValue);
                        FlagTestend = Integer.parseInt(endValue);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(
                                formFrame,
                                "Test Start and Test End must be numeric values.",
                                "Validation Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // // Validate that start is less than or equal to end
                    if (FlagTeststart > FlagTestend) {
                        JOptionPane.showMessageDialog(
                                formFrame,
                                "Test Start value must be less than or equal to Test End value.",
                                "Validation Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Perform your test execution logic here
                    JOptionPane.showMessageDialog(
                            formFrame,
                            "Test started successfully!\n" +
                                    "Suit Name: " + selectedSuit + "\n" +
                                    "Subsheet Index: " + selectedSubsheetIndex + "\n" +
                                    "Subsheet: " + selectedSubsheet + "\n" +
                                    "Start: " + FlagTeststart + "\n" +
                                    "End: " + FlagTestend);

                    if (runAllCasesRadio.isSelected()) {
                        TestRunStatus = "RunAllCases";
                    } else if (runFailCasesRadio.isSelected()) {
                        TestRunStatus = "RunFailCases";
                    }

                    frame.dispose();
                    // formFrame.dispose();
                    String selectedSubsheetIndex1 = Integer.toString(selectedSubsheetIndex);
                    executionType = selectedSubsheetIndex1;
                    SuitProperiesFileName = selectedSuit;
                    System.out.println("selectedSubsheetIndex : " + selectedSubsheetIndex1);

                    runButton.setEnabled(false);
                    cancelButton.setEnabled(true); // Prevent multiple executions
                    pauseButton.setEnabled(true);

                    // Run execution in a separate thread
                    new Thread(() -> {
                        LoginScreen.Run();
                    }).start();
                });

                // cancelButton.addActionListener(event -> formFrame.dispose()); // Close form
                // on cancel
                formFrame.add(formPanel);
                formFrame.setVisible(true);
            });

            executeButton.addActionListener(e -> {
                List<String> selectedSuits = new ArrayList<>();
                Map<String, Map<String, List<String>>> suitToExcelFileSubsheetMap = new HashMap<>();

                // Loop through the checkboxes and check if they are selected
                for (int i = 0; i < checkBoxes.size(); i++) {
                    if (checkBoxes.get(i).isSelected()) {
                        String suitName = suitNames.get(i);
                        selectedSuits.add(suitName);

                        // Logic for loading Excel sheets and subsheets
                        String propertiesFileName = filteredFiles.get(i).getName();
                        String inputDataExcel = null;
                        try {
                            inputDataExcel = loadExcelSheetName(propertiesFileName);
                        } catch (UnsupportedEncodingException e1) {
                            e1.printStackTrace();
                        }

                        if (inputDataExcel != null && !inputDataExcel.isEmpty()) {
                            String[] splitExcelSheets = inputDataExcel.split(",");
                            Map<String, List<String>> excelFileSubsheetMap = new HashMap<>();

                            for (String sheet : splitExcelSheets) {
                                String trimmedSheet = sheet.trim();

                                List<String> subsheets = null;
                                try {
                                    subsheets = fetchSubsheets(trimmedSheet);
                                } catch (UnsupportedEncodingException e1) {
                                    e1.printStackTrace();
                                }
                                excelFileSubsheetMap.put(trimmedSheet, subsheets);
                            }
                            suitToExcelFileSubsheetMap.put(suitName, excelFileSubsheetMap);
                        } else {
                        }
                    }
                }

                if (!selectedSuits.isEmpty()) {
                    showSummaryFrameWithSubsheets(selectedSuits, suitToExcelFileSubsheetMap);
                } else {
                    JOptionPane.showMessageDialog(frame, "No suits selected!");
                }
            });

            DeleteButton.addActionListener(e -> {
                // Collect names of selected suits
                List<Integer> selectedIndices = new ArrayList<>();
                List<String> selectedSuitNames = new ArrayList<>();

                for (int i = 0; i < checkBoxes.size(); i++) {
                    if (checkBoxes.get(i).isSelected()) {
                        selectedIndices.add(i);
                        selectedSuitNames.add(suitNames.get(i));
                    }
                }

                if (!selectedIndices.isEmpty()) {
                    // Show confirmation dialog
                    String message = "Are you sure you want to delete the following suits?  \n"
                            + String.join(", ", selectedSuitNames);
                    int confirmation = JOptionPane.showConfirmDialog(
                            frame,
                            message,
                            "Confirm Deletion",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    // Proceed with deletion if user confirms
                    if (confirmation == JOptionPane.YES_OPTION) {
                        for (int i = selectedIndices.size() - 1; i >= 0; i--) {
                            int index = selectedIndices.get(i);

                            // Delete the actual file from the directory
                            File fileToDelete = filteredFiles.get(index);
                            if (fileToDelete.delete()) {
                                System.out.println("Deleted file: " + fileToDelete.getName());
                            } else {
                                System.err.println("Failed to delete file: " + fileToDelete.getName());
                            }

                            // Remove from the lists
                            checkBoxes.remove(index);
                            suitNames.remove(index);
                            filteredFiles.remove(index);
                        }

                        // Refresh the display panel
                        try {
                            displaySuits(frame, query); // Reload the display with the updated lists
                        } catch (UnsupportedEncodingException e1) {
                            e1.printStackTrace();
                        }

                        JOptionPane.showMessageDialog(frame, "Selected suits have been deleted successfully!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "No suits selected to delete!");
                }
            });

            // Add suit list to scroll pane
            if (suitNames.size() > 2) {
                JScrollPane scrollPane = new JScrollPane(suitPanel);
                scrollPane.setPreferredSize(new Dimension(400, 350)); // Scrollable area size
                contentPanel.add(scrollPane, BorderLayout.CENTER);
            } else if (!suitNames.isEmpty()) {
                suitPanel.setPreferredSize(new Dimension(400, 150)); // Single suit panel size
                contentPanel.add(suitPanel, BorderLayout.CENTER);
            }

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // FlowLayout with center alignment and
                                                                            // padding

            // Add the buttons to the buttonPanel
            buttonPanel.add(executeButton);
            buttonPanel.add(RunTestCase);
            buttonPanel.add(DeleteButton);

            contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        } else {
            JOptionPane.showMessageDialog(frame, "No properties files found in the directory.");
        }

        contentPanel.revalidate(); // Revalidate content
        contentPanel.repaint(); // Repaint content
    }

    private static List<String> fetchSubsheets(String excelFilePath) throws UnsupportedEncodingException {
        List<String> subsheetNames = new ArrayList<>();

        jarPath = URLDecoder.decode(jarPath, "UTF-8");
        String xlsxDirectory = jarPath + "//Test Cases Sheets" + File.separator + excelFilePath;
        File excelFile1 = new File(xlsxDirectory);

        try (FileInputStream fis = new FileInputStream(excelFile1)) {

            try {
                workbook = new XSSFWorkbook(fis);
            } catch (Exception e) {
                JFrame frame = new JFrame("");
                JOptionPane.showMessageDialog(frame, e);
            }

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

                subsheetNames.add(workbook.getSheetName(i));
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Excel file not found: " + excelFilePath, "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading Excel file: " + excelFilePath + "\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return subsheetNames;
    }

    private static void showSummaryFrameWithSubsheets(List<String> selectedSuits,
            Map<String, Map<String, List<String>>> suitToExcelFileSubsheetMap) {
        JFrame summaryFrame = new JFrame("Execution Summary with Subsheets");
        summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 250, 255));

        // Add a spacer below the header
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Radio Buttons for Run Type
        JPanel runTypePanel = new JPanel();
        runTypePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        runTypePanel.setBackground(new Color(245, 250, 255));

        JRadioButton runAllRadioButton = new JRadioButton("Run All Test Cases");
        JRadioButton runFailOnlyRadioButton = new JRadioButton("Run Only Fail Test Cases");

        runAllRadioButton.setFont(new Font("Roboto", Font.BOLD, 12));
        runAllRadioButton.setBackground(new Color(245, 250, 255));
        runAllRadioButton.setSelected(true); // Default selection

        runFailOnlyRadioButton.setFont(new Font("Roboto", Font.BOLD, 12));
        runFailOnlyRadioButton.setBackground(new Color(245, 250, 255));

        // Group the radio buttons
        ButtonGroup runTypeGroup = new ButtonGroup();
        runTypeGroup.add(runAllRadioButton);
        runTypeGroup.add(runFailOnlyRadioButton);

        runTypePanel.add(runAllRadioButton);
        runTypePanel.add(runFailOnlyRadioButton);

        // Add the run type panel to the main panel
        mainPanel.add(runTypePanel);

        Map<String, JCheckBox> checkboxMap = new HashMap<>();

        // Populate Content for Each Suit
        int index = 1;

        for (String suit : selectedSuits) {
            // Panel for Suit Label and Radio Button
            JPanel suitPanel = new JPanel(new BorderLayout());
            suitPanel.setBackground(new Color(245, 250, 255));

            // Suit Label
            JLabel suitLabel = new JLabel("Suit: " + suit);
            suitLabel.setFont(new Font("Roboto", Font.BOLD, 16));
            suitLabel.setForeground(new Color(60, 60, 60));
            suitLabel.setHorizontalAlignment(SwingConstants.LEFT);
            suitPanel.add(suitLabel, BorderLayout.CENTER);
            mainPanel.add(suitPanel);

            // Spacer below suit label
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            // Excel Files and Subsheets for Each Suit
            Map<String, List<String>> excelFileSubsheetMap = suitToExcelFileSubsheetMap.get(suit);

            if (excelFileSubsheetMap != null) {
                for (Map.Entry<String, List<String>> entry : excelFileSubsheetMap.entrySet()) {
                    JPanel excelFilePanel = new JPanel(new BorderLayout());
                    excelFilePanel.setBackground(new Color(250, 250, 255));
                    excelFilePanel.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(new Color(200, 220, 250), 1),
                            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                    // Left-aligned Details
                    JPanel detailsPanel = new JPanel();
                    detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
                    detailsPanel.setBackground(new Color(250, 250, 255));

                    JLabel excelLabel = new JLabel(index + ". " + entry.getKey());
                    excelLabel.setFont(new Font("Roboto", Font.BOLD, 14));
                    excelLabel.setForeground(new Color(40, 80, 160));
                    detailsPanel.add(excelLabel);

                    JLabel subsheetCountLabel = new JLabel(" Number of Subsheets: " + entry.getValue().size());
                    subsheetCountLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
                    subsheetCountLabel.setForeground(new Color(100, 100, 100));
                    detailsPanel.add(subsheetCountLabel);

                    excelFilePanel.add(detailsPanel, BorderLayout.WEST);

                    // Checkboxes for Subsheets
                    JPanel checkboxPanel = new JPanel();
                    checkboxPanel.setLayout(new GridLayout(0, 3, 10, 10)); // 0 rows (auto), 3 columns, 10px gap
                    checkboxPanel.setBackground(new Color(250, 250, 255));

                    for (String subsheet : entry.getValue()) {
                        JCheckBox checkBox = new JCheckBox(subsheet);
                        checkBox.setSelected(true);
                        checkBox.setFont(new Font("Roboto", Font.PLAIN, 12));
                        checkBox.setBackground(new Color(250, 250, 255));
                        checkBox.setToolTipText("Select " + subsheet);

                        // Store checkbox in map using the Excel file name and subsheet name as key
                        checkboxMap.put(entry.getKey() + "_" + subsheet, checkBox);
                        checkboxPanel.add(checkBox);
                    }
                    excelFilePanel.add(checkboxPanel, BorderLayout.CENTER);

                    // Add Excel File Panel to Main Panel
                    mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
                    mainPanel.add(excelFilePanel);
                    index++;
                }
            }
        }

        // Scroll Pane to Handle Large Content
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        summaryFrame.add(scrollPane, BorderLayout.CENTER);

        // Footer Section
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(new Color(230, 245, 250));

        pauseButton = createButton("Pause/Resume");
        pauseButton.setFont(new Font("Roboto", Font.BOLD, 13));
        pauseButton.setBackground(new Color(70, 130, 180));
        pauseButton.setForeground(Color.WHITE);
        pauseButton.setEnabled(false);
        pauseButton.setPreferredSize(new Dimension(150, 33));
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PauseResumeAutomation.togglePause();
            }
        });

        JButton exeButton = new JButton("Start Execution");
        exeButton.setFont(new Font("Roboto", Font.BOLD, 13));
        exeButton.setBackground(new Color(70, 130, 180));
        exeButton.setPreferredSize(new Dimension(150, 33));
        exeButton.setForeground(Color.WHITE);

        JButton cancelButton = new JButton("Stop Execution");
        cancelButton.setFont(new Font("Roboto", Font.BOLD, 13));
        cancelButton.setBackground(new Color(70, 130, 180));
        cancelButton.setPreferredSize(new Dimension(150, 33));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setEnabled(false);

        // Action listener to stop execution
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (driver != null) {
                    driver.quit(); // Close the browser and end WebDriver session
                    System.out.println("Automation execution stopped.");
                }
            }
        });

        footerPanel.add(exeButton);
        footerPanel.add(pauseButton);
        footerPanel.add(cancelButton);
        summaryFrame.add(footerPanel, BorderLayout.SOUTH);

        summaryFrame.pack();
        summaryFrame.setLocationRelativeTo(null);
        summaryFrame.setVisible(true);

        // ActionListener for Execute Button
        exeButton.addActionListener(e -> {

            if (runAllRadioButton.isSelected()) {
                System.out.println("Run All Cases.");
                TestRunStatus = "RunAllCases";
            } else if (runFailOnlyRadioButton.isSelected()) {
                TestRunStatus = "RunFailCases";
                System.out.println("Run Only Fail Cases.");
            }

            List<int[]> fileIndices = new ArrayList<>();

            // Iterate through selected suits
            for (String suit : selectedSuits) {
                SuitProperiesFileName = suit;

                Map<String, List<String>> excelFileSubsheetMap = suitToExcelFileSubsheetMap.get(suit);
                if (excelFileSubsheetMap != null) {
                    for (Map.Entry<String, List<String>> entry : excelFileSubsheetMap.entrySet()) {
                        String excelFileName = entry.getKey();
                        List<String> subsheets = entry.getValue();
                        List<Integer> selectedIndices = new ArrayList<>();

                        // Iterate through the subsheets for this Excel file
                        for (int i = 0; i < subsheets.size(); i++) {
                            String subsheet = subsheets.get(i);
                            JCheckBox checkBox = checkboxMap.get(excelFileName + "_" + subsheet);

                            if (checkBox != null && checkBox.isSelected()) {
                                selectedIndices.add(i); // Add the index of the selected subsheet
                            }
                        }

                        if (!selectedIndices.isEmpty()) {
                            fileIndices.add(selectedIndices.stream().mapToInt(Integer::intValue).toArray());
                        }
                    }
                }
            }
            // summaryFrame.dispose();
            frame.dispose();

            // Do not dispose the summary frame immediately
            exeButton.setEnabled(false); // Prevent multiple executions
            cancelButton.setEnabled(true); // Prevent multiple executions
            pauseButton.setEnabled(true);

            // Run execution in a separate thread
            new Thread(() -> {
                for (int[] indices : fileIndices) {
                    executionType = Arrays.toString(indices).replaceAll("[\\[\\] ]", "");
                    LoginScreen.Run();
                }
                SwingUtilities.invokeLater(() -> {
                    exeButton.setEnabled(true);
                });
            }).start();

        });

    }

    protected static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Roboto", Font.BOLD, 14));
        button.setBackground(new Color(000, 000, 50)); // Light Blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(180, 38));
        button.setMargin(new Insets(10, 20, 10, 20));
        button.setBorder(BorderFactory.createLineBorder(new Color(245, 255, 255, 200)));
        button.setBorderPainted(true);
        return button;
    }

    private static String loadExcelSheetName(String propertiesFileName) throws UnsupportedEncodingException {
        jarPath = URLDecoder.decode(jarPath, "UTF-8");
        String xlsxDirectory = jarPath + "//Suits";

        String excelSheetName = "";
        try (InputStream input = new FileInputStream(new File(xlsxDirectory, propertiesFileName))) {
            Properties prop = new Properties();
            prop.load(input);
            excelSheetName = prop.getProperty("InputDataExcel");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return excelSheetName;
    }
}
