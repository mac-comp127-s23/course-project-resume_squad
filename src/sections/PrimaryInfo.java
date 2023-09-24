package sections;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.awt.*;
import java.util.Properties;

public class PrimaryInfo {

    public static Map<String, String> primaryInfo = new HashMap<>();

    protected static void createAndShowGUI() {
        String[] labels = {"Full Name: ", "Email: ", "Phone Number: ", "LinkedIn: "};
        int numPairs = labels.length;

        // Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(20);
            l.setLabelFor(textField);
            p.add(textField);
        }

        // Lay out the panel.
        SpringUtilities.makeCompactGrid(p, numPairs, 2, 6, 6, 15, 10);

        // Create the save button
        JButton saveButton = new JButton("Save and continue");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Save the information entered by the user
                Component[] components = p.getComponents();
                primaryInfo = new HashMap<>();
                for (int i = 0; i < numPairs; i++) {
                    Component component = components[i * 2 + 1];
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        String text = textField.getText();
                        primaryInfo.put(labels[i], text);
                    }
                }

                // Load the existing properties file
                Properties properties = new Properties();
                try (FileInputStream fis = new FileInputStream("data.properties")) {
                    properties.load(fis);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // Update the properties with the new values
                for (Map.Entry<String, String> entry : primaryInfo.entrySet()) {
                    properties.setProperty(entry.getKey(), entry.getValue());
                }

                // Save the updated properties to the file
                try (FileOutputStream fos = new FileOutputStream("data.properties")) {
                    properties.store(fos, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // Create and show an instance of the Education class
                Education.createAndShowGUI();

                // Close the current window
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(p);
                frame.dispose();
            }
        });

        // Create and set up the window.
        JFrame frame = new JFrame("CV Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the big label to the top center of the content pane.
        JLabel titleLabel = new JLabel("Primary Information", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Add the save button and the panel to the content pane.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(p, BorderLayout.CENTER);
        contentPane.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(contentPane);

        // Make the window bigger.
        frame.setPreferredSize(new Dimension(800, 400));

        // Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
