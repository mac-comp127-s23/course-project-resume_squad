package sections;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ResumeGenerator {

    public static void createAndShowGUI(Properties data) {
        
        // Create and set up the window
        JFrame frame = new JFrame("Resume");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout for the content pane
        frame.getContentPane().setLayout(new BorderLayout());

        // Create and add the header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        JLabel nameLabel = new JLabel(data.getProperty("Full Name: "));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 26));  // Updated font size and style
        headerPanel.add(nameLabel, BorderLayout.CENTER);
        frame.getContentPane().add(headerPanel, BorderLayout.NORTH);

        // Create and add the information panel
        JPanel infoPanel = new JPanel(new GridLayout(0, 1));
        
        // Create and add email label
        JLabel emailLabel = new JLabel("Email: " + data.getProperty("Email: "));
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emailLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));  // Updated font size and style
        infoPanel.add(emailLabel);
        
        // Create and add phone number label
        JLabel phoneLabel = new JLabel("Phone Number: " + data.getProperty("Phone Number: "));
        phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
        phoneLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));  // Updated font size and style
        infoPanel.add(phoneLabel);
        
        // Create and add LinkedIn label
        JLabel linkedinLabel = new JLabel("LinkedIn: " + data.getProperty("LinkedIn: "));
        linkedinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        linkedinLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));  // Updated font size and style
        infoPanel.add(linkedinLabel);
        
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));  // Add some padding
        
        // Make the email, phone number, and LinkedIn labels appear in a row with " || " separators
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        infoPanel.add(emailLabel);
        infoPanel.add(new JLabel(" || "));
        infoPanel.add(phoneLabel);
        infoPanel.add(new JLabel(" || "));
        infoPanel.add(linkedinLabel);

        frame.getContentPane().add(infoPanel, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(1000, 800));

        // Make the window visible
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Load the properties from the file
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("data.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create and show an instance of the ResumeGenerator class
        createAndShowGUI(properties);
    }
}
