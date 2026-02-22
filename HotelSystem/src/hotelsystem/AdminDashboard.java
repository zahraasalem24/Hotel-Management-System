package hotelsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminDashboard extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public AdminDashboard() {
        setLayout(new BorderLayout());

        // Left Navigation Bar
        JPanel navBar = new JPanel(new GridLayout(4, 1));
        navBar.setPreferredSize(new Dimension(100, getHeight()));
        navBar.setBackground(new Color(200, 200, 200));

        // Home Button
        JButton homeButton = new JButton(resizeIcon("home.JPEG", 40, 40));
        styleNavButton(homeButton);

        // Rooms Button
        JButton roomsButton = new JButton(resizeIcon("rooms.JPEG", 40, 40));
        styleNavButton(roomsButton);

        // Employees Button
        JButton employeesButton = new JButton(resizeIcon("employee.JPEG", 50, 50));
        styleNavButton(employeesButton);

        // Profile Button
        JButton profileButton = new JButton(resizeIcon("username-1.png", 40, 40));
        styleNavButton(profileButton);

        // Add buttons to navigation bar
        navBar.add(homeButton);
        navBar.add(roomsButton);
        navBar.add(employeesButton);
        navBar.add(profileButton);

        // Main Content Panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(221, 206, 184));

        // Home Panel
        JPanel homePanel = new JPanel(new BorderLayout());

        // Hotel Image on the left
        ImageIcon hotelIcon = new ImageIcon(getClass().getResource("Hotell.JPEG"));
        Image hotelImage = hotelIcon.getImage().getScaledInstance(350, 550, Image.SCALE_SMOOTH);
        JLabel hotelLabel = new JLabel(new ImageIcon(hotelImage));
        homePanel.add(hotelLabel, BorderLayout.WEST);
        homePanel.setBackground(new Color(221, 206, 184));

        // Panel for buttons on the right
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        buttonPanel.setBackground(new Color(221, 206, 184));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel welcomeLabel = new JLabel("Welcome to the Royal Emblem Hotel!");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        buttonPanel.add(welcomeLabel, gbc);

        // "Add or update rooms" label
        JLabel roomsLabel = new JLabel("Add or update rooms:");
        roomsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        roomsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        buttonPanel.add(roomsLabel, gbc);
        
        JButton roomsButtonMain = new JButton("Rooms");
        styleButton(roomsButtonMain);
        roomsButtonMain.setPreferredSize(new Dimension(300, 50));
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        buttonPanel.add(roomsButtonMain, gbc);

        // "Add or remove employees" label
        JLabel employeesLabel = new JLabel("Add or remove employees:");
        employeesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        employeesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        buttonPanel.add(employeesLabel, gbc);

        // Employees Button
        JButton employeesButtonMain = new JButton("Employees ");
        styleButton(employeesButtonMain);
        employeesButtonMain.setPreferredSize(new Dimension(300, 50));
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        buttonPanel.add(employeesButtonMain, gbc);

        homePanel.add(buttonPanel, BorderLayout.EAST);

        // Rooms Management Panel
        JPanel roomsPanel = new JPanel(new GridBagLayout());
        roomsPanel.setBackground(new Color(221, 206, 184));
        GridBagConstraints gbcRooms = new GridBagConstraints();
        gbcRooms.insets = new Insets(10, 10, 10, 10);
        gbcRooms.anchor = GridBagConstraints.CENTER;

        // Title Label
        JLabel roomsTitleLabel = new JLabel("Rooms Management");
        roomsTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        roomsTitleLabel.setForeground(new Color(103, 89, 71));
        gbcRooms.gridx = 0;
        gbcRooms.gridy = 0;
        gbcRooms.gridwidth = 2;
        gbcRooms.anchor = GridBagConstraints.CENTER;
        roomsPanel.add(roomsTitleLabel, gbcRooms);
        

        // Room ID Label
        JLabel roomIdLabel = new JLabel("Room ID:");
        roomIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        gbcRooms.gridx = 0;
        gbcRooms.gridy = 1;
        roomsPanel.add(roomIdLabel, gbcRooms);
     
        // Room ID Text Field
        JTextField roomMainIdField = new JTextField(15);
        roomMainIdField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        gbcRooms.gridx = 3; 
        gbcRooms.gridy = 1;
        gbcRooms.fill = GridBagConstraints.HORIZONTAL; // Allow stretching if needed
        roomsPanel.add(roomMainIdField, gbcRooms);


        // Update Button
        JButton updateButton = new JButton("Update");
        styleButton(updateButton);
        updateButton.setPreferredSize(new Dimension(300, 50));
        gbcRooms.gridx = 0;
        gbcRooms.gridy = 2;
        gbcRooms.gridwidth = 2;
        roomsPanel.add(updateButton, gbcRooms);

        // Add Button
        JButton addButton = new JButton("Add");
        styleButton(addButton);
        addButton.setPreferredSize(new Dimension(300, 50));
        gbcRooms.gridy = 3;
        roomsPanel.add(addButton, gbcRooms);

        // Generate Report Button
        JButton generateReportButton = new JButton("Generate Rooms Report");
        styleButton(generateReportButton);
        generateReportButton.setPreferredSize(new Dimension(300, 50));
        gbcRooms.gridy = 4;
        roomsPanel.add(generateReportButton, gbcRooms);

     // Update Room Panel
JPanel updatePanel = new JPanel(new GridBagLayout());
updatePanel.setBackground(new Color(221, 206, 184));
GridBagConstraints gbcUpdate = new GridBagConstraints();
gbcUpdate.insets = new Insets(10, 20, 10, 20);
gbcUpdate.anchor = GridBagConstraints.CENTER;

JLabel titleLabel = new JLabel("Update Room Details");
titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
gbcUpdate.gridx = 0;
gbcUpdate.gridy = 0;
gbcUpdate.gridwidth = 2;
updatePanel.add(titleLabel, gbcUpdate);

// Labels for current info (left)
String[] labels = {"Room ID:", "Room Type:", "Room Price:"};
JLabel[] currentLabels = new JLabel[labels.length];
JTextField newRoomIdField = new JTextField(15);
JComboBox<String> roomTypeDropdown = new JComboBox<>(new String[]{"Single", "Double", "Suite"});
JTextField roomPriceField = new JTextField(15);

Font customFont = new Font("Times New Roman", Font.BOLD, 14); // Example font

// Tooltips
newRoomIdField.setToolTipText("Enter new Room ID");
roomTypeDropdown.setToolTipText("Select Room Type");
roomPriceField.setToolTipText("Enter new Room Price");

for (int i = 0; i < labels.length; i++) {
    gbcUpdate.gridy = i + 1;
    gbcUpdate.gridwidth = 1;
    
    // Left side - Current info
    currentLabels[i] = new JLabel(labels[i] + " (Current)");
    currentLabels[i].setFont(customFont);
    updatePanel.add(currentLabels[i], gbcUpdate);
    
    // Right side - New info
    gbcUpdate.gridx = 1;
    if (i == 0) updatePanel.add(roomMainIdField, gbcUpdate); // Room ID TextField
    else if (i == 1) updatePanel.add(roomTypeDropdown, gbcUpdate); // Room Type Dropdown
    else updatePanel.add(roomPriceField, gbcUpdate); // Room Price TextField
    
    gbcUpdate.gridx = 0; // Reset to first column for next row
}

// Buttons
JButton cancelButton = new JButton("Cancel");
styleButton(cancelButton);
gbcUpdate.gridy = labels.length + 1;
gbcUpdate.gridx = 0;
updatePanel.add(cancelButton, gbcUpdate);

JButton updateINButton = new JButton("Update");
styleButton(updateINButton);
gbcUpdate.gridy = labels.length + 1;
gbcUpdate.gridx = 1;
updatePanel.add(updateINButton, gbcUpdate);



// Cancel button action - go back to rooms panel
cancelButton.addActionListener(e -> cardLayout.show(mainPanel, "rooms"));



// Add Room Panel
JPanel addPanel = new JPanel(new GridBagLayout());
addPanel.setBackground(new Color(221, 206, 184));
GridBagConstraints gbcAdd = new GridBagConstraints();
gbcAdd.insets = new Insets(10, 20, 10, 20);
gbcAdd.anchor = GridBagConstraints.CENTER;

JLabel addTitleLabel = new JLabel("Add New Room");
addTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
gbcAdd.gridx = 0;
gbcAdd.gridy = 0;
gbcAdd.gridwidth = 2;
addPanel.add(addTitleLabel, gbcAdd);

// Labels for new info
String[] addLabels = {"Room ID:", "Room Type:", "Room Price:"};
JLabel[] addRoomLabels = new JLabel[addLabels.length];
JTextField addRoomIdField = new JTextField(15);
JComboBox<String> newRoomTypeDropdown = new JComboBox<>(new String[]{"Single", "Double", "Suite"});
JTextField newRoomPriceField = new JTextField(15);


// Tooltips
addRoomIdField.setToolTipText("Enter Room ID");
newRoomTypeDropdown.setToolTipText("Select Room Type");
newRoomPriceField.setToolTipText("Enter Room Price ");

for (int i = 0; i < addLabels.length; i++) {
    gbcAdd.gridy = i + 1;
    gbcAdd.gridwidth = 1;

    // Left side - New info labels
    addRoomLabels[i] = new JLabel(addLabels[i]);
    addRoomLabels[i].setFont(customFont);
    addPanel.add(addRoomLabels[i], gbcAdd);

    // Right side - Input fields
    gbcAdd.gridx = 1;
    if (i == 0) addPanel.add(addRoomIdField, gbcAdd); // Room ID
    else if (i == 1) addPanel.add(newRoomTypeDropdown, gbcAdd); // Room Type Dropdown
    else addPanel.add(newRoomPriceField, gbcAdd); // Room Price

    gbcAdd.gridx = 0; // Reset to first column for next row
}

// Buttons
JButton addCancelButton = new JButton("Cancel");
styleButton(addCancelButton);
gbcAdd.gridy = addLabels.length + 1;
gbcAdd.gridx = 0;
addPanel.add(addCancelButton, gbcAdd);

JButton addINButton = new JButton("Add Room");
styleButton(addINButton);
gbcAdd.gridy = addLabels.length + 1;
gbcAdd.gridx = 1;
addPanel.add(addINButton, gbcAdd);



// Cancel button action - go back to rooms panel
addCancelButton.addActionListener(e -> cardLayout.show(mainPanel, "rooms"));


/// Report Panel
JPanel reportPanel = new JPanel(new GridBagLayout());
reportPanel.setBackground(new Color(221, 206, 184));
GridBagConstraints gbcReport = new GridBagConstraints();
gbcReport.insets = new Insets(10, 20, 10, 20);
gbcReport.anchor = GridBagConstraints.CENTER;

// Title Label
JLabel reportTitleLabel = new JLabel("Rooms Report");
reportTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
gbcReport.gridx = 0;
gbcReport.gridy = 0;
gbcReport.gridwidth = 2;
reportPanel.add(reportTitleLabel, gbcReport);

// Room Reports List (JList for future data)
DefaultListModel<String> reportListModel = new DefaultListModel<>();
JList<String> reportList = new JList<>(reportListModel);
reportList.setVisibleRowCount(10);
reportList.setFixedCellHeight(25);
reportList.setFont(new Font("Times New Roman", Font.PLAIN, 16));

// Scroll Pane for JList
JScrollPane reportScrollPane = new JScrollPane(reportList);
reportScrollPane.setPreferredSize(new Dimension(300, 200));
gbcReport.gridy = 1;
gbcReport.gridwidth = 2;
reportPanel.add(reportScrollPane, gbcReport);

// Back Button
JButton backButton = new JButton("Back");
styleButton(backButton);
backButton.setPreferredSize(new Dimension(300, 50));
gbcReport.gridy = 2;
gbcReport.gridwidth = 1;
reportPanel.add(backButton, gbcReport);

// Back button action - go back to rooms panel
backButton.addActionListener(e -> cardLayout.show(mainPanel, "rooms"));


// Add panels to card layout
mainPanel.add(roomsPanel, "rooms");
mainPanel.add(updatePanel, "updateRoom");
mainPanel.add(addPanel, "addRoom");
mainPanel.add(reportPanel, "roomReport");

// Button Action Listeners to switch panels
updateButton.addActionListener(e -> cardLayout.show(mainPanel, "updateRoom"));
addButton.addActionListener(e -> cardLayout.show(mainPanel, "addRoom"));
generateReportButton.addActionListener(e -> cardLayout.show(mainPanel, "roomReport"));

        // Employee Management Panel
JPanel employeePanel = new JPanel(new GridBagLayout());
employeePanel.setBackground(new Color(221, 206, 184));
GridBagConstraints gbcEmployee = new GridBagConstraints();
gbcEmployee.insets = new Insets(10, 20, 10, 20);
gbcEmployee.anchor = GridBagConstraints.CENTER;

// Title Label
        JLabel employeeTitleLabel = new JLabel("Employees Management",SwingConstants.CENTER);
        employeeTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        employeeTitleLabel.setForeground(new Color(103, 89, 71));
        gbcEmployee.gridx = 2;
        gbcEmployee.gridy = 0;
        gbcEmployee.gridwidth = 2;
        gbcEmployee.anchor = GridBagConstraints.CENTER;
        employeePanel.add(employeeTitleLabel, gbcEmployee);

// Employee ID Label & TextField
JLabel empIdLabel = new JLabel("Employee ID:");
empIdLabel.setFont(customFont);
JTextField empIdField = new JTextField(15);
empIdField.setToolTipText("Enter Employee ID");

// Add Employee Button
JButton addEmpButton = new JButton("Add Employee");
styleButton(addEmpButton);
addEmpButton.setPreferredSize(new Dimension(300, 50));

// Remove Employee Button
JButton removeEmpButton = new JButton("Remove Employee");
styleButton(removeEmpButton);
removeEmpButton.setPreferredSize(new Dimension(300, 50));

// Employee Report Button
JButton empReportButton = new JButton("Employee Report");
styleButton(empReportButton);
empReportButton.setPreferredSize(new Dimension(300, 50));

// Employee Report Button Action - Show Employee Report Panel
empReportButton.addActionListener(e -> cardLayout.show(mainPanel, "employeeReport"));


// Add Components to Panel
gbcEmployee.gridx = 1;
gbcEmployee.gridy = 1;
employeePanel.add(empIdLabel, gbcEmployee);

gbcEmployee.gridx = 3;
employeePanel.add(empIdField, gbcEmployee);

gbcEmployee.gridx = 1;
gbcEmployee.gridy = 2;
gbcEmployee.gridwidth = 3;
employeePanel.add(addEmpButton, gbcEmployee);

gbcEmployee.gridy = 3;
employeePanel.add(removeEmpButton, gbcEmployee);

gbcEmployee.gridy = 4; 
employeePanel.add(empReportButton, gbcEmployee);



// Remove Button Action - Show Confirmation Dialog
removeEmpButton.addActionListener(e -> {
    int choice = JOptionPane.showConfirmDialog(employeePanel, 
        "Are you sure you want to remove Employee ID: " + empIdField.getText() + "?", 
        "Confirm Removal", JOptionPane.YES_NO_OPTION);
    if (choice == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(employeePanel, "Employee Removed Successfully.");
    }
});

// Add Button Action - Open Add Employee Panel
addEmpButton.addActionListener(e -> cardLayout.show(mainPanel, "addEmployee"));


// Add Employee Panel
JPanel addEmployeePanel = new JPanel(new GridBagLayout());
addEmployeePanel.setBackground(new Color(221, 206, 184));
GridBagConstraints gbcAddEmp = new GridBagConstraints();
gbcAddEmp.insets = new Insets(10, 20, 10, 20);
gbcAddEmp.anchor = GridBagConstraints.CENTER;

// Employee ID
JLabel newEmpIdLabel = new JLabel("Employee ID:");
newEmpIdLabel.setFont(customFont);
JTextField newEmpIdField = new JTextField(15);
newEmpIdField.setToolTipText("Enter Employee ID");

// Employee Name
JLabel empNameLabel = new JLabel("Name:");
empNameLabel.setFont(customFont);
JTextField empNameField = new JTextField(15);
empNameField.setToolTipText("Enter Employee Name");

// Employee Shift (Dropdown)
JLabel empShiftLabel = new JLabel("Shift:");
String[] shifts = {"Morning", "Evening", "Night"};
JComboBox<String> empShiftDropdown = new JComboBox<>(shifts);

// Salary
JLabel empSalaryLabel = new JLabel("Salary:");
empSalaryLabel.setFont(customFont);
JTextField empSalaryField = new JTextField(15);
empSalaryField.setToolTipText("Enter Salary");

// Email
JLabel empEmailLabel = new JLabel("Email:");
empEmailLabel.setFont(customFont);
JTextField empEmailField = new JTextField(15);
empEmailField.setToolTipText("Enter Email Address");

// Phone
JLabel empPhoneLabel = new JLabel("Phone:");
empPhoneLabel.setFont(customFont);
JTextField empPhoneField = new JTextField(15);
empPhoneField.setToolTipText("Enter Phone Number");

// Add & Cancel Buttons
JButton confirmAddEmpButton = new JButton("Add Employee");
JButton cancelAddEmpButton = new JButton("Cancel");
styleButton(confirmAddEmpButton);
styleButton(cancelAddEmpButton);

// Add Components to Panel
gbcAddEmp.gridx = 0;
gbcAddEmp.gridy = 0;
addEmployeePanel.add(newEmpIdLabel, gbcAddEmp);
gbcAddEmp.gridx = 1;
addEmployeePanel.add(newEmpIdField, gbcAddEmp);

gbcAddEmp.gridx = 0;
gbcAddEmp.gridy = 1;
addEmployeePanel.add(empNameLabel, gbcAddEmp);
gbcAddEmp.gridx = 1;
addEmployeePanel.add(empNameField, gbcAddEmp);

gbcAddEmp.gridx = 0;
gbcAddEmp.gridy = 2;
addEmployeePanel.add(empShiftLabel, gbcAddEmp);
gbcAddEmp.gridx = 1;
addEmployeePanel.add(empShiftDropdown, gbcAddEmp);

gbcAddEmp.gridx = 0;
gbcAddEmp.gridy = 3;
addEmployeePanel.add(empSalaryLabel, gbcAddEmp);
gbcAddEmp.gridx = 1;
addEmployeePanel.add(empSalaryField, gbcAddEmp);

gbcAddEmp.gridx = 0;
gbcAddEmp.gridy = 4;
addEmployeePanel.add(empEmailLabel, gbcAddEmp);
gbcAddEmp.gridx = 1;
addEmployeePanel.add(empEmailField, gbcAddEmp);

gbcAddEmp.gridx = 0;
gbcAddEmp.gridy = 5;
addEmployeePanel.add(empPhoneLabel, gbcAddEmp);
gbcAddEmp.gridx = 1;
addEmployeePanel.add(empPhoneField, gbcAddEmp);

// Buttons at Bottom
gbcAddEmp.gridx = 0;
gbcAddEmp.gridy = 6;
gbcAddEmp.gridwidth = 2;
addEmployeePanel.add(confirmAddEmpButton, gbcAddEmp);

gbcAddEmp.gridy = 7;
addEmployeePanel.add(cancelAddEmpButton, gbcAddEmp);

mainPanel.add(employeePanel, "employees");
mainPanel.add(addEmployeePanel, "addEmployee");

// Button Actions
confirmAddEmpButton.addActionListener(e -> JOptionPane.showMessageDialog(addEmployeePanel, "Employee Added Successfully."));

cancelAddEmpButton.addActionListener(e -> cardLayout.show(mainPanel, "employees"));

// Employee Report Panel
JPanel employeeReportPanel = new JPanel(new GridBagLayout());
employeeReportPanel.setBackground(new Color(221, 206, 184));
GridBagConstraints gbcEmpReport = new GridBagConstraints();
gbcEmpReport.insets = new Insets(10, 20, 10, 20);
gbcEmpReport.anchor = GridBagConstraints.CENTER;

// Title Label
JLabel empReportTitleLabel = new JLabel("Employee Report");
empReportTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
gbcEmpReport.gridx = 0;
gbcEmpReport.gridy = 0;
gbcEmpReport.gridwidth = 2;
employeeReportPanel.add(empReportTitleLabel, gbcEmpReport);

// Employee Reports List (JList for future data)
DefaultListModel<String> empReportListModel = new DefaultListModel<>();
JList<String> empReportList = new JList<>(empReportListModel);
empReportList.setVisibleRowCount(10);
empReportList.setFixedCellHeight(25);
empReportList.setFont(new Font("Times New Roman", Font.PLAIN, 16));

// Scroll Pane for JList
JScrollPane empReportScrollPane = new JScrollPane(empReportList);
empReportScrollPane.setPreferredSize(new Dimension(300, 200));
gbcEmpReport.gridy = 1;
gbcEmpReport.gridwidth = 2;
employeeReportPanel.add(empReportScrollPane, gbcEmpReport);

// Back Button
JButton empBackButton = new JButton("Back");
styleButton(empBackButton);
empBackButton.setPreferredSize(new Dimension(300, 50));
gbcEmpReport.gridy = 2;
gbcEmpReport.gridwidth = 1;
employeeReportPanel.add(empBackButton, gbcEmpReport);
mainPanel.add(employeeReportPanel,"employeeReport");

// Back button action - go back to Employees panel
empBackButton.addActionListener(e -> cardLayout.show(mainPanel, "employees"));


        // Profile Panel
        JPanel profilePanel = new JPanel(new GridBagLayout());
        profilePanel.setBackground(new Color(221, 206, 184));
        GridBagConstraints gbcProfile = new GridBagConstraints();
        gbcProfile.insets = new Insets(10, 20, 10, 20);
        gbcProfile.anchor = GridBagConstraints.CENTER;

        // Title Label
        JLabel profileLabel = new JLabel("Personal Profile");
        profileLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        profileLabel.setForeground(new Color(103, 89, 71));
        gbcProfile.gridx = 0;
        gbcProfile.gridy = 0;
        gbcProfile.gridwidth = 2;
        profilePanel.add(profileLabel, gbcProfile);

        // Profile Image
        ImageIcon profileIcon = new ImageIcon(getClass().getResource("username-1.png"));
        Image profileImg = profileIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel profileImageLabel = new JLabel(new ImageIcon(profileImg));
        gbcProfile.gridy = 1;
        gbcProfile.gridwidth = 1;
        profilePanel.add(profileImageLabel, gbcProfile);

        // Username & User Type Panel (Stacked Under Image)
        JPanel userInfoPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        userInfoPanel.setBackground(new Color(221, 206, 184));

        JLabel usernameLabel = new JLabel("Username: admin123");
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userInfoPanel.add(usernameLabel);

        JLabel userTypeLabel = new JLabel("User Type: Admin");
        userTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        userTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userInfoPanel.add(userTypeLabel);

        gbcProfile.gridy = 2;
        profilePanel.add(userInfoPanel, gbcProfile);

        // Right Side Details
        JPanel detailsPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        detailsPanel.setBackground(new Color(221, 206, 184));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        JLabel nameLabel = new JLabel("Name: Admin");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        detailsPanel.add(nameLabel);

        JLabel emailLabel = new JLabel("Email: admin@email.com");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        detailsPanel.add(emailLabel);

        JLabel phoneLabel = new JLabel("Phone: +987654321");
        phoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        detailsPanel.add(phoneLabel);

        gbcProfile.gridx = 1;
        gbcProfile.gridy = 1;
        gbcProfile.gridheight = 2;
        profilePanel.add(detailsPanel, gbcProfile);

        JLabel logoutLabel = new JLabel("<html><u>Log Out</u></html>");
        logoutLabel.setForeground(Color.BLUE);
        logoutLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoutLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                cardLayout.show(mainPanel, "login");
                JOptionPane.showMessageDialog(profilePanel, "You have been logged out.");
            }
        });

        gbcProfile.gridx = 0;
        gbcProfile.gridy = 3;
        gbcProfile.gridwidth = 2;
        gbcProfile.anchor = GridBagConstraints.CENTER;
        profilePanel.add(logoutLabel, gbcProfile);

        // Add Panels to CardLayout
        mainPanel.add(homePanel, "home");
        mainPanel.add(roomsPanel, "rooms");
        mainPanel.add(profilePanel, "profile");
        cardLayout.show(mainPanel, "home");

        // Add Action Listeners
        homeButton.addActionListener(e -> cardLayout.show(mainPanel, "home"));
        roomsButton.addActionListener(e -> cardLayout.show(mainPanel, "rooms"));
        employeesButton.addActionListener(e -> cardLayout.show(mainPanel, "employees"));
        profileButton.addActionListener(e -> cardLayout.show(mainPanel, "profile"));

        roomsButtonMain.addActionListener(e -> cardLayout.show(mainPanel, "rooms"));
        employeesButtonMain.addActionListener(e -> cardLayout.show(mainPanel, "employees"));

        // Add components to AdminDashboard
        add(navBar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    private void styleNavButton(JButton button) {
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBackground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(150, 50));
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Times New Roman", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}

