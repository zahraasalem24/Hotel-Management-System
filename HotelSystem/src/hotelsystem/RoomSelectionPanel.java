package hotelsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


import javax.swing.*;
import java.awt.*;

public class RoomSelectionPanel extends JPanel {
    public RoomSelectionPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);;
        
        
        // Title Label
        JLabel titleLabel = new JLabel("Reservation Details");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBackground(new Color(221, 206, 184));
        
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(6, 1, 10, 2));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));
        detailsPanel.setBackground(new Color(221, 206, 184));
        
        
        // Initializing Labels
        JLabel reservationIdLabel = new JLabel("Reservation ID: ");
        reservationIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel roomNumberLabel = new JLabel("Room Number: ");
        roomNumberLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel roomTypeLabel = new JLabel("Room Type: ");
        roomTypeLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel roomPriceLabel = new JLabel("Room Price: ");
        roomPriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel checkInDateLabel = new JLabel("Check-in Date: ");
        checkInDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JLabel checkOutDateLabel = new JLabel("Check-out Date: ");
        checkOutDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        
       
        
        // Adding components to the panel
        detailsPanel.add(reservationIdLabel);
        detailsPanel.add(roomNumberLabel);
        detailsPanel.add(roomTypeLabel);
        detailsPanel.add(roomPriceLabel);
        detailsPanel.add(checkInDateLabel);
        detailsPanel.add(checkOutDateLabel);
        
        
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(168, 148, 121));
        JButton bookButton = new JButton("Book");
        bookButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        
        buttonPanel.add(bookButton);
        buttonPanel.add(cancelButton);
        
        add(titleLabel,BorderLayout.NORTH);
        add(detailsPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
    }
}


