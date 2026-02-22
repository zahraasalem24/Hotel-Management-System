package hotelsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HotelSystem {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hotel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
            
        // Create an instance of GuestHomePage
        AdminDashboard guestHomePage = new AdminDashboard();
        frame.add(guestHomePage);
            
        frame.setVisible(true);
        frame.setResizable(false);
    
        //new LoginSignup();
    }
    
}



