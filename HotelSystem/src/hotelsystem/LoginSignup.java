 package hotelsystem;
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class LoginSignup extends JFrame implements ActionListener {
    private  JTextField usernameField;
    private  JPasswordField passwordField;
    private  JButton loginButton;
    private final JPanel mainPanel;
    private final CardLayout cardLayout;

    public LoginSignup() {
        setTitle("Hotel Management System - Login/Signup");
        setSize(900, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // CardLayout to switch between login and signup
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Login Panel
        JPanel loginPanel = createLoginPanel();

        // Signup Panel
        JPanel signupPanel = createSignupPanel();

        // Add panels to the CardLayout
        mainPanel.add(loginPanel, "login");
        mainPanel.add(signupPanel, "signup");

        // Add mainPanel to the frame
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new BorderLayout());

        // Left panel for the hotel logo
        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(350, 450));
        logoPanel.setLayout(new BorderLayout());
        JLabel logoLabel = new JLabel();

        // Add the hotel logo
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("Hotel_Logo.PNG"));
        Image logoImage = logoIcon.getImage().getScaledInstance(320, 320, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(logoImage));
        logoPanel.add(logoLabel, BorderLayout.CENTER);

        // Right panel for login form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(221, 206, 184));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Welcome label
        formPanel.add(Box.createVerticalStrut(20));
        JLabel titleLabel = new JLabel("Welcome to the Royal Emblem Hotel!");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(titleLabel);
        formPanel.add(Box.createVerticalStrut(25));

        // Subtitle text
        JLabel subtitleLabel = new JLabel("Please enter your information");
        subtitleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(subtitleLabel);
        formPanel.add(Box.createVerticalStrut(30));

        // Username Field with Icon
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        usernamePanel.setBackground(new Color(221, 206, 184));

        JLabel userIconLabel = new JLabel();
        ImageIcon userIcon = new ImageIcon(getClass().getResource("username-1.png"));
        Image userImage = userIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        userIconLabel.setIcon(new ImageIcon(userImage));

        JTextField usernameField = new JTextField(15);
        usernamePanel.add(userIconLabel);
        usernamePanel.add(new JLabel("Username:"));
        usernamePanel.add(usernameField);
        formPanel.add(usernamePanel);

        // Password Field with Icon
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        passwordPanel.setBackground(new Color(221, 206, 184));

        JLabel passIconLabel = new JLabel();
        ImageIcon passIcon = new ImageIcon(getClass().getResource("password-76.png"));
        Image passImage = passIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        passIconLabel.setIcon(new ImageIcon(passImage));

        JPasswordField passwordField = new JPasswordField(15);
        passwordPanel.add(passIconLabel);
        passwordPanel.add(new JLabel("Password:"));
        passwordPanel.add(passwordField);
        formPanel.add(passwordPanel);

       
        // Login button
        JPanel buttonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5));
        buttonContainer.setBackground(new Color(221, 206, 184));
        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 35));
        loginButton.addActionListener(this);
        buttonContainer.add(loginButton);
        formPanel.add(buttonContainer);

        // Sign-up label
        JLabel signUpLabel = new JLabel("<html><u>Don't have an account? Sign up now!</u></html>");
        signUpLabel.setForeground(Color.BLUE);
        signUpLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signUpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                cardLayout.show(mainPanel, "signup"); // Switch to Signup Panel
            }
        });
        formPanel.add(signUpLabel);

        // Add panels to loginPanel
        loginPanel.add(logoPanel, BorderLayout.WEST);
        loginPanel.add(formPanel, BorderLayout.CENTER);

        return loginPanel;
    }

    private JPanel createSignupPanel() {
        JPanel signupPanel = new JPanel(new BorderLayout());

    // Left panel for the hotel logo
    JPanel logoPanel = new JPanel();
    logoPanel.setPreferredSize(new Dimension(350, 450));
    logoPanel.setLayout(new BorderLayout());
    JLabel logoLabel = new JLabel();

    // Add the hotel logo
    ImageIcon logoIcon = new ImageIcon(getClass().getResource("Hotel_Logo.PNG"));
    Image logoImage = logoIcon.getImage().getScaledInstance(320, 320, Image.SCALE_SMOOTH);
    logoLabel.setIcon(new ImageIcon(logoImage));
    logoPanel.add(logoLabel, BorderLayout.CENTER);

    // Right panel for signup form
    JPanel formPanel = new JPanel();
    formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
    formPanel.setBackground(new Color(221, 206, 184));
    formPanel.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50)); // Reduced padding

    // Welcome label
    JLabel titleLabel = new JLabel("Create an Account");
    titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
    titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    formPanel.add(titleLabel);
    formPanel.add(Box.createVerticalStrut(10)); // Reduced spacing

    // Subtitle text
    JLabel subtitleLabel = new JLabel("Fill in your details to sign up");
    subtitleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    formPanel.add(subtitleLabel);
    formPanel.add(Box.createVerticalStrut(15)); // Reduced spacing

    // Username panel
    JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Less spacing
    usernamePanel.setBackground(new Color(221, 206, 184));
    usernamePanel.add(new JLabel("Username:"));
    JTextField usernameField = new JTextField(15);
    usernamePanel.add(usernameField);
    formPanel.add(usernamePanel);

    // Email panel
    JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    emailPanel.setBackground(new Color(221, 206, 184));
    emailPanel.add(new JLabel("Email:"));
    JTextField emailField = new JTextField(15);
    emailPanel.add(emailField);
    formPanel.add(emailPanel);

    // Phone panel
    JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    phonePanel.setBackground(new Color(221, 206, 184));
    phonePanel.add(new JLabel("Phone:"));
    JTextField phoneField = new JTextField(15);
    phonePanel.add(phoneField);
    formPanel.add(phonePanel);

    // Password panel
    JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    passwordPanel.setBackground(new Color(221, 206, 184));
    passwordPanel.add(new JLabel("Password:"));
    JPasswordField passwordField = new JPasswordField(15);
    passwordPanel.add(passwordField);
    formPanel.add(passwordPanel);

    // Confirm Password panel
    JPanel confirmPasswordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    confirmPasswordPanel.setBackground(new Color(221, 206, 184));
    confirmPasswordPanel.add(new JLabel("Confirm Password:"));
    JPasswordField confirmPasswordField = new JPasswordField(15);
    confirmPasswordPanel.add(confirmPasswordField);
    formPanel.add(confirmPasswordPanel);

    // Role selection panel
    JPanel rolePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    rolePanel.setBackground(new Color(221, 206, 184));
    rolePanel.add(new JLabel("Account Type:"));
    String[] roles = {"Guest", "Receptionist", "Admin"};
    JComboBox<String> roleComboBox = new JComboBox<>(roles);
    rolePanel.add(roleComboBox);
    formPanel.add(rolePanel);

    // Sign-up button
    JButton signupButton = new JButton("Sign Up");
    signupButton.setPreferredSize(new Dimension(120, 35));
    signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    signupButton.addActionListener(e -> {
        System.out.println("User Signed Up: " + usernameField.getText());
    });
    formPanel.add(Box.createVerticalStrut(10)); // Reduced spacing
    formPanel.add(signupButton);

    // Back to login label
    JLabel loginLabel = new JLabel("<html><u>Already have an account? Login here!</u></html>");
    loginLabel.setForeground(Color.BLUE);
    loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
    loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    loginLabel.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent evt) {
        cardLayout.show(mainPanel, "login");
        }
    });
    formPanel.add(loginLabel);

    // Add panels
    signupPanel.add(logoPanel, BorderLayout.WEST);
    signupPanel.add(formPanel, BorderLayout.CENTER);

    return signupPanel;


    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            System.out.println("Login: " + username + ", " + password);
        }
    }

    
}
