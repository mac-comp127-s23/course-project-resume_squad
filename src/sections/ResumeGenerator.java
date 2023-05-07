package sections;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResumeGenerator {

    private JFrame frame;

    public ResumeGenerator() {
        frame = new JFrame("Resume Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setLocationRelativeTo(null);
    }

    public void generateResume() {
        JPanel contentPane = new JPanel(new BorderLayout());
        frame.setContentPane(contentPane);

        JLabel titleLabel = new JLabel("Resume", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.CENTER);
        contentPane.add(topPanel, BorderLayout.NORTH);

        JPanel resumePanel = new JPanel(new GridLayout(0, 2));
        contentPane.add(resumePanel, BorderLayout.CENTER);

        try {
            addSectionToPanel(resumePanel, "Primary Information", "PrimaryInformation.txt");
            addSectionToPanel(resumePanel, "Education", "Education.txt");
            addSectionToPanel(resumePanel, "Work Experience", "WorkExperience.txt");
            addSectionToPanel(resumePanel, "Skills", "Skills.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setVisible(true);
    }

    private void addSectionToPanel(JPanel panel, String sectionTitle, String fileName) throws IOException {
        JPanel sectionPanel = new JPanel(new SpringLayout());
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            JLabel label = new JLabel(line, JLabel.TRAILING);
            sectionPanel.add(label);
            JTextField textField = new JTextField(20);
            label.setLabelFor(textField);
            textField.setText(line);
            textField.setEditable(false);
            sectionPanel.add(textField);
        }
        reader.close();
        SpringUtilities.makeCompactGrid(sectionPanel, sectionPanel.getComponentCount() / 2, 2, 6, 6, 15, 10);
        panel.add(new JLabel(sectionTitle));
        panel.add(sectionPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ResumeGenerator generator = new ResumeGenerator();
            generator.generateResume();
        });
    }

    public static void run() {
        SwingUtilities.invokeLater(() -> {
            ResumeGenerator generator = new ResumeGenerator();
            generator.generateResume();
    });
}
}
