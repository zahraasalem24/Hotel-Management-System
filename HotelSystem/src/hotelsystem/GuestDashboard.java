package hotelsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuestDashboard extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    public GuestDashboard() {
        
        setLayout(new BorderLayout());
        
        // Left Navigation Bar
        JPanel navBar = new JPanel(new GridLayout(4, 1));
        navBar.setPreferredSize(new Dimension(100, getHeight()));
        navBar.setBackground(new Color(200, 200, 200));
        
        // Home Button
        JButton homeButton = new JButton(resizeIcon("home.JPEG", 40, 40));
        homeButton.setOpaque(true);
        homeButton.setContentAreaFilled(true);
        homeButton.setBackground(Color.WHITE);
        homeButton.setFocusPainted(false);
        homeButton.setBorderPainted(false);
        
        // Booking Button
        JButton bookingButton = new JButton(resizeIcon("search.JPEG", 30, 30));
        bookingButton.setOpaque(true);
        bookingButton.setContentAreaFilled(true);
        bookingButton.setBackground(Color.WHITE);
        bookingButton.setFocusPainted(false);
        bookingButton.setBorderPainted(false);
        
        // Reservation Button
        JButton reservationButton = new JButton(resizeIcon("reservation.JPEG", 30, 30));
        reservationButton.setOpaque(true);
        reservationButton.setContentAreaFilled(true);
        reservationButton.setBackground(Color.WHITE);
        reservationButton.setBorderPainted(false);
        reservationButton.setFocusPainted(false);
        
        // Profile Button
        JButton profileButton = new JButton(resizeIcon("username-1.png", 40, 40));
        profileButton.setOpaque(true);
        profileButton.setContentAreaFilled(true);
        profileButton.setBackground(Color.WHITE);
        profileButton.setBorderPainted(false);
        profileButton.setFocusPainted(false);
        
        // Add buttons to navigation bar
        navBar.add(homeButton);
        navBar.add(bookingButton);
        navBar.add(reservationButton);
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
        
        JLabel bookLabel = new JLabel("Would you like to book a room?");
        bookLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        bookLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(bookLabel);
        
        JButton bookRoomButton = new JButton("Book a Room!");
        styleButton(bookRoomButton);
        buttonPanel.add(bookRoomButton);
        
        JLabel reservationLabel = new JLabel("Check your reservations history!");
        reservationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        reservationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(reservationLabel);
        
        JButton checkReservationsButton = new JButton("Check Reservations");
        styleButton(checkReservationsButton);
        buttonPanel.add(checkReservationsButton);
        
        homePanel.add(buttonPanel, BorderLayout.EAST);
        
        
        // Booking Panel
        JPanel bookingPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Reduced spacing
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        bookingPanel.setBackground(new Color(221, 206, 184));

        // Title Label
        JLabel titleLabel = new JLabel("Booking Rooms");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        titleLabel.setForeground(new Color(103, 89, 71)); // Nice blue color
        gbc.gridy = 0;
        bookingPanel.add(titleLabel, gbc);

        // Room Type Label & Dropdown
        JPanel roomTypePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        roomTypePanel.setBackground(new Color(221, 206, 184));
        JLabel roomTypeLabel = new JLabel("Room Type:");
        roomTypeLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JComboBox<String> roomTypeDropdown = new JComboBox<>(new String[]{"Single", "Double", "Suite"});
        roomTypeDropdown.setToolTipText("Choose the room type");
        roomTypePanel.add(roomTypeLabel);
        roomTypePanel.add(roomTypeDropdown);
        gbc.gridy = 1;
        bookingPanel.add(roomTypePanel, gbc);

        // Number of Rooms Label & Dropdown
        JPanel numberOfRoomsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        numberOfRoomsPanel.setBackground(new Color(221, 206, 184));
        JLabel numberOfRoomsLabel = new JLabel("Number of Rooms:");
        numberOfRoomsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        JComboBox<String> roomNumberDropdown = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        roomNumberDropdown.setToolTipText("Select the number of rooms");
        numberOfRoomsPanel.add(numberOfRoomsLabel);
        numberOfRoomsPanel.add(roomNumberDropdown);
        gbc.gridy = 2;
        bookingPanel.add(numberOfRoomsPanel, gbc);

        // Search Button
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        searchButton.setPreferredSize(new Dimension(120, 40));
        searchButton.setBackground(new Color(168, 148, 121)); 
        
        searchButton.setBorder(BorderFactory.createLineBorder(new Color(103, 89, 71), 2));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        gbc.gridy = 3;
        bookingPanel.add(searchButton, gbc);

        // Available Rooms Label
        JLabel availableRoomsLabel = new JLabel("Available Rooms:");
        availableRoomsLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        gbc.gridy = 4;
        bookingPanel.add(availableRoomsLabel, gbc);

        // Box for Available Rooms
        JPanel availableRoomsBox = new JPanel();
        availableRoomsBox.setPreferredSize(new Dimension(350, 150));
        availableRoomsBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        availableRoomsBox.setBackground(Color.WHITE);
        gbc.gridy = 5;
        bookingPanel.add(availableRoomsBox, gbc);

        // Add to Main Panel
        mainPanel.add(bookingPanel, "booking");

        // Reservation Panel
        JPanel reservationPanel = new JPanel(new GridBagLayout());
        reservationPanel.setBackground(new Color(221, 206, 184));
        GridBagConstraints gbcRes = new GridBagConstraints();
        gbcRes.insets = new Insets(5, 5, 5, 5);
        gbcRes.gridx = 0;
        gbcRes.anchor = GridBagConstraints.CENTER;

        // Active Reservations Label
        JLabel activeReservationsLabel = new JLabel("Active Reservations");
        activeReservationsLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        activeReservationsLabel.setForeground(new Color(103, 89, 71));
        gbcRes.gridy = 0;
        reservationPanel.add(activeReservationsLabel, gbcRes);

        // Active Reservations List
        DefaultListModel<String> activeReservationListModel = new DefaultListModel<>();
        JList<String> activeReservationList = new JList<>(activeReservationListModel);
        activeReservationList.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        activeReservationList.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Scroll Pane for Active Reservations
        JScrollPane activeReservationScrollPane = new JScrollPane(activeReservationList);
        activeReservationScrollPane.setPreferredSize(new Dimension(300, 150));
        gbcRes.gridy = 1;
        reservationPanel.add(activeReservationScrollPane, gbcRes);

        // Previous Reservations Label
        JLabel previousReservationsLabel = new JLabel("Previous Reservations");
        previousReservationsLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        previousReservationsLabel.setForeground(new Color(103, 89, 71));
        gbcRes.gridy = 2;
        reservationPanel.add(previousReservationsLabel, gbcRes);

        // Previous Reservations List
        DefaultListModel<String> previousReservationListModel = new DefaultListModel<>();
        JList<String> previousReservationList = new JList<>(previousReservationListModel);
        previousReservationList.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        previousReservationList.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Scroll Pane for Previous Reservations
        JScrollPane previousReservationScrollPane = new JScrollPane(previousReservationList);
        previousReservationScrollPane.setPreferredSize(new Dimension(300, 150));
        gbcRes.gridy = 3;
        reservationPanel.add(previousReservationScrollPane, gbcRes);

        // Add to Main Panel
        mainPanel.add(reservationPanel, "reservation");

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

        JLabel usernameLabel = new JLabel("Username: guest123");
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userInfoPanel.add(usernameLabel);

        JLabel userTypeLabel = new JLabel("User Type: Guest");
        userTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        userTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userInfoPanel.add(userTypeLabel);

        gbcProfile.gridy = 2;
        profilePanel.add(userInfoPanel, gbcProfile);

        // Right Side Details
        JPanel detailsPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        detailsPanel.setBackground(new Color(221, 206, 184));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        JLabel nameLabel = new JLabel("Name: Reema ");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        detailsPanel.add(nameLabel);

        JLabel emailLabel = new JLabel("Email: Reema@email.com");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        detailsPanel.add(emailLabel);

        JLabel phoneLabel = new JLabel("Phone: +123456789");
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


        // Add to Main Panel
        mainPanel.add(profilePanel, "profile");

        
        // Add Panels to CardLayout
        mainPanel.add(homePanel, "home");
        mainPanel.add(bookingPanel, "booking");
        mainPanel.add(reservationPanel, "reservation");
        mainPanel.add(profilePanel, "profile");
        
        // Add Action Listeners
        homeButton.addActionListener(e -> cardLayout.show(mainPanel, "home"));
        bookingButton.addActionListener(e -> cardLayout.show(mainPanel, "booking"));
        reservationButton.addActionListener(e -> cardLayout.show(mainPanel, "reservation"));
        profileButton.addActionListener(e -> cardLayout.show(mainPanel, "profile"));
        
        bookRoomButton.addActionListener(e -> cardLayout.show(mainPanel, "booking"));
        checkReservationsButton.addActionListener(e -> cardLayout.show(mainPanel, "reservation"));
        
        // Add components to GuestDashboard
        add(navBar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }
    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
        }
    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(150, 50));
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Times New Roman", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 2));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }


}

