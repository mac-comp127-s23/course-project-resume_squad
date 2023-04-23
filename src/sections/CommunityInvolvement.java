package sections;
import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;

public class CommunityInvolvement {

    protected static void createAndShowGUI() {
        String[] labels = {"Organization: ", "Role: ", "Time period: ", "Description(1st bullet point): ", "Description(2nd bullet point): ", "Description(3rd bullet point): "};
        int numPairs = labels.length;
    
        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(20);
            l.setLabelFor(textField);
            p.add(textField);
        }
    
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                                        numPairs, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        15, 10);     //xPad, yPad
    
        //Create the save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              //Save the information entered by the user
              Component[] components = p.getComponents();
              File file = new File("Involvement.txt");
              try {
                  FileWriter output = new FileWriter(file, true); // append mode
                  BufferedWriter writer = new BufferedWriter(output);
                  for (Component c : components) {
                      if (c instanceof JTextField) {
                          JTextField textField = (JTextField) c;
                          String text = textField.getText();
                          writer.write(text + "\n"); // add a new line
                      }
                  }
                  writer.close();
              } catch (IOException f) {
                  f.printStackTrace();
              }
          }
      });
        
        //Create and set up the window.
        JFrame frame = new JFrame("CV Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        //Add the big label to the top center of the content pane.
        JLabel titleLabel = new JLabel("Community Involvement", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.CENTER);
    
        //Add the save button and the panel to the content pane.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(p, BorderLayout.CENTER);
        contentPane.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(contentPane);
    
        //Make the window bigger.
        frame.setPreferredSize(new Dimension(800, 400));
    
        //Display the window.
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
