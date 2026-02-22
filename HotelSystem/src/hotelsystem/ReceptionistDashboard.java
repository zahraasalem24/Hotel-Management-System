package hotelsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReceptionistDashboard extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel checksPanel;
    private JPanel reservationDetailsPanel;
    private JPanel shiftsPanel;
    
    public ReceptionistDashboard() {
        setLayout(new BorderLayout());
        
        // Left Navigation Bar
        JPanel navBar = new JPanel(new GridLayout(4, 1));
        navBar.setPreferredSize(new Dimension(100, getHeight()));
        navBar.setBackground(new Color(200, 200, 200));
        
        // Home Button
        JButton homeButton = new JButton(resizeIcon("home.JPEG", 40, 40));
        styleNavButton(homeButton);
        
        // Checks Button
        JButton checksButton = new JButton(resizeIcon("checks.JPEG", 50, 50));
        styleNavButton(checksButton);
        
        // Shifts Button
        JButton shiftsButton = new JButton(resizeIcon("shifts.JPEG", 30, 30));
        styleNavButton(shiftsButton);
        
        // Profile Button
        JButton profileButton = new JButton(resizeIcon("username-1.png", 40, 40));
        styleNavButton(profileButton);
        
        // Add buttons to navigation bar
        navBar.add(homeButton);
        navBar.add(checksButton);
        navBar.add(shiftsButton);
        navBar.add(profileButton);
        
        // Main Content Panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(221, 206, 184));
        
        // Home Panel
        JPanel homePanel = new JPanel(new BorderLayout());
        
        // Add hotel image on the left
        ImageIcon hotelIcon = new ImageIcon(getClass().getResource("Hotell.JPEG"));
        Image hotelImage = hotelIcon.getImage().getScaledInstance(350, 550, Image.SCALE_SMOOTH);
        JLabel hotelLabel = new JLabel(new ImageIcon(hotelImage));
        homePanel.add(hotelLabel, BorderLayout.WEST);
        homePanel.setBackground(new Color(221, 206, 184));
        
        // Panel for buttons on the right
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        buttonPanel.setBackground(new Color(221, 206, 184));
        
        JLabel welcomeLabel = new JLabel("Welcome to the Royal Emblem Hotel!");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(welcomeLabel);
        
        JLabel checkInLabel = new JLabel("Would you like to check-in and check-out guests?");
        checkInLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        checkInLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(checkInLabel);
        
        JButton checksButtonMain = new JButton("Checks");
        styleButton(checksButtonMain);
        buttonPanel.add(checksButtonMain);
        
        JLabel shiftsLabel = new JLabel("Check time shifts and schedules");
        shiftsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        shiftsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(shiftsLabel);
        
        JButton shiftsButtonMain = new JButton("Time Shifts");
        styleButton(shiftsButtonMain);
        buttonPanel.add(shiftsButtonMain);
        
        homePanel.add(buttonPanel, BorderLayout.EAST);
        
        // Checks Panel
        checksPanel = new JPanel(new GridBagLayout());
        checksPanel.setBackground(new Color(221, 206, 184));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Title Label
        JLabel titleLabel = new JLabel("Check-ins and Check-outs");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        titleLabel.setForeground(new Color(103, 89, 71));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across both columns
        checksPanel.add(titleLabel, gbc);

        // Guest ID Label & TextField
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset width
        JLabel guestIdLabel = new JLabel("Guest ID:");
        guestIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        checksPanel.add(guestIdLabel, gbc);

        gbc.gridx = 1;
        JTextField guestIdField = new JTextField(15);
        guestIdField.setFont(new Font("Times New Roman", Font.BOLD, 16));
        guestIdField.setHorizontalAlignment(SwingConstants.CENTER);
        checksPanel.add(guestIdField, gbc);

        // Check-In & Check-Out Radio Buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        JRadioButton checkInButton = new JRadioButton("Check-In");
        checkInButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        checkInButton.setBackground(new Color(221, 206, 184)); 
        checkInButton.setHorizontalAlignment(SwingConstants.CENTER);
        

        gbc.gridx = 1;
        JRadioButton checkOutButton = new JRadioButton("Check-Out");
        checkOutButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        checkOutButton.setBackground(new Color(221, 206, 184));
        checkOutButton.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        radioPanel.setBackground(new Color(221, 206, 184)); 
        radioPanel.add(checkInButton);
        radioPanel.add(checkOutButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        checksPanel.add(radioPanel, gbc);


        ButtonGroup checkGroup = new ButtonGroup();
        checkGroup.add(checkInButton);
        checkGroup.add(checkOutButton);

        // Check Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Centered across both columns
        JButton checkButton = new JButton("Check");
        styleButton(checkButton);
        checksPanel.add(checkButton, gbc);


        // Reservation Details Panel (Initially Hidden)
        reservationDetailsPanel = new JPanel(new GridBagLayout());
        reservationDetailsPanel.setBackground(new Color(221, 206, 184));
        GridBagConstraints gbcDetails = new GridBagConstraints();
        gbcDetails.insets = new Insets(10, 10, 10, 10);
        gbcDetails.anchor = GridBagConstraints.CENTER;
        gbcDetails.gridx = 0;
        gbcDetails.gridy = 0;
        
        JLabel reservationDetailsLabel = new JLabel("Reservation Details");
        reservationDetailsLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        reservationDetailsPanel.add(reservationDetailsLabel, gbcDetails);
        
        // Labels for Reservation Details
        String[] labelsText = { 
        "Reservation ID:", "Guest ID:", "Guest Name:", "Room Type:", 
        "Check-in Date:", "Check-out Date:", "Total Price:" 
        };
        JLabel[] labels = new JLabel[labelsText.length];
        
        gbcDetails.gridy = 1; // Start below title
        for (int i = 0; i < labels.length; i++) {
        labels[i] = new JLabel(labelsText[i]);
        labels[i].setFont(new Font("Times New Roman", Font.PLAIN, 16));
        gbcDetails.gridy++;
        reservationDetailsPanel.add(labels[i], gbcDetails);
        }
        
        // Payment Method Label
        gbcDetails.gridy++;
        JLabel paymentLabel = new JLabel("Payment Method:");
        paymentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        reservationDetailsPanel.add(paymentLabel, gbcDetails);
        // Payment Method Radio Buttons
        JRadioButton creditCardButton = new JRadioButton("Credit Card");
        JRadioButton cashButton = new JRadioButton("Cash");
        JRadioButton applePayButton = new JRadioButton("Apple Pay");
        ButtonGroup paymentGroup = new ButtonGroup();
        creditCardButton.setBackground(new Color(221, 206, 184));
        cashButton.setBackground(new Color(221, 206, 184));
        applePayButton.setBackground(new Color(221, 206, 184));
        creditCardButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        cashButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        applePayButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        paymentGroup.add(creditCardButton);
        paymentGroup.add(cashButton);
        paymentGroup.add(applePayButton);

        // Panel for Payment Options
        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        paymentPanel.setBackground(new Color(221, 206, 184));
        paymentPanel.add(creditCardButton);
        paymentPanel.add(cashButton);
        paymentPanel.add(applePayButton);

        // Add Payment Panel
        gbcDetails.gridy++;
        reservationDetailsPanel.add(paymentPanel, gbcDetails);
        
        JButton confirmButton = new JButton("Confrim");

        gbcDetails.gridy++;
        gbcDetails.gridwidth = 2; // Span across two columns (if needed)
        gbcDetails.anchor = GridBagConstraints.CENTER;
        reservationDetailsPanel.add(confirmButton, gbcDetails);


        // Add action listener to Check button
        checkButton.addActionListener(e -> {
            String guestId = guestIdField.getText().trim();
            if (!guestId.isEmpty()) {
                reservationDetailsLabel.setText("Reservation Details for Guest ID: "+guestId);
                cardLayout.show(mainPanel, "reservationDetails"); // Switch panel
            } else {
                JOptionPane.showMessageDialog(checksPanel, "Please enter a Guest ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add action listener to Back button
        confirmButton.addActionListener(e -> cardLayout.show(mainPanel, "checks"));

        // Add panels to CardLayout
        
        mainPanel.add(reservationDetailsPanel, "reservationDetails"); 
        mainPanel.add(checksPanel, "checks");

        // Show the Checks Panel initially
        cardLayout.show(mainPanel, "checks");

        
        
        // Shifts Panel
        shiftsPanel = new JPanel(new GridBagLayout());
        shiftsPanel.setBackground(new Color(221, 206, 184));
        GridBagConstraints gbcs = new GridBagConstraints();
        gbcs.insets = new Insets(10, 10, 10, 10);
        gbcs.anchor = GridBagConstraints.CENTER;

        // Title Label
        JLabel shiftTitleLabel = new JLabel("Shifts and Time Schedules");
        shiftTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        shiftTitleLabel.setForeground(new Color(103, 89, 71));
        gbcs.gridx = 0;
        gbcs.gridy = 0;
        gbcs.gridwidth = 2;
        shiftsPanel.add(shiftTitleLabel, gbcs);

        // Panel to center shiftDetailsLabel
        JPanel shiftDetailsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        shiftDetailsPanel.setBackground(new Color(221, 206, 184));

        JLabel shiftDetailsLabel = new JLabel("<html><div style='text-align:center;'>"
            + "Morning shift: 7:00 AM - 1:00 PM<br>"
            + "Evening shift: 1:00 PM - 7:00 PM<br>"
            + "Night shift: 7:00 PM - 1:00 AM</div></html>", SwingConstants.CENTER);
        shiftDetailsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        shiftDetailsPanel.add(shiftDetailsLabel);

        gbcs.gridx = 0;
        gbcs.gridy = 1;
        shiftsPanel.add(shiftDetailsPanel, gbcs); 

        // Your Shift Label
        JLabel yourShiftLabel = new JLabel("Your shift is: ");
        yourShiftLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        gbcs.gridy = 2;
        shiftsPanel.add(yourShiftLabel, gbcs);

        
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

        JLabel usernameLabel = new JLabel("Username: Receptionist123");
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userInfoPanel.add(usernameLabel);

        JLabel userTypeLabel = new JLabel("User Type: Receptionist");
        userTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        userTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userInfoPanel.add(userTypeLabel);

        gbcProfile.gridy = 2;
        profilePanel.add(userInfoPanel, gbcProfile);

        // Right Side Details
        JPanel detailsPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        detailsPanel.setBackground(new Color(221, 206, 184));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        JLabel nameLabel = new JLabel("Name: Zahraa ");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        detailsPanel.add(nameLabel);

        JLabel emailLabel = new JLabel("Email: Zahraa@email.com");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        detailsPanel.add(emailLabel);

        JLabel phoneLabel = new JLabel("Phone: +123456789");
        phoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        detailsPanel.add(phoneLabel);
        
        JLabel shiftLabel = new JLabel("Shift: Morning");
        shiftLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        detailsPanel.add(shiftLabel);

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
            // Show the login panel after logout
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
        mainPanel.add(checksPanel, "checks");
        mainPanel.add(shiftsPanel, "shifts");
        mainPanel.add(profilePanel, "profile");
        
        // Add Action Listeners
        homeButton.addActionListener(e -> cardLayout.show(mainPanel, "home"));
        checksButton.addActionListener(e -> cardLayout.show(mainPanel, "checks"));
        shiftsButton.addActionListener(e -> cardLayout.show(mainPanel, "shifts"));
        profileButton.addActionListener(e -> cardLayout.show(mainPanel, "profile"));
        
        checksButtonMain.addActionListener(e -> cardLayout.show(mainPanel, "checks"));
        shiftsButtonMain.addActionListener(e -> cardLayout.show(mainPanel, "shifts"));
        
        // Add components to ReceptionistDashboard
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