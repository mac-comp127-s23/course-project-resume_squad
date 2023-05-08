package sections;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ResumeGenerator {

    static Color dark_blue = new Color(0, 0, 100);

    public static void createAndShowGUI(Properties data) {
        
        // Create and set up the window
        JFrame frame = new JFrame(data.getProperty("Full Name: "));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout for the content pane
        frame.getContentPane().setLayout(new BorderLayout());

        // Create and add the information panel
        JPanel infoPanel = new JPanel(new GridLayout(0, 10));
        
        // Create and add email label
        JLabel emailLabel = new JLabel(data.getProperty("Email: "));
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emailLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        infoPanel.add(emailLabel);
        
        // Create and add phone number label
        JLabel phoneLabel = new JLabel(data.getProperty("Phone Number: "));
        phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
        phoneLabel.setFont(new Font("SansSerif", Font.PLAIN, 14)); 
        infoPanel.add(phoneLabel);
        
        // Create and add LinkedIn label
        JLabel linkedinLabel = new JLabel("LinkedIn: " + data.getProperty("LinkedIn: "));
        linkedinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        linkedinLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));  
        infoPanel.add(linkedinLabel);

        infoPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));  // Add some padding
        
        // Make the email, phone number, and LinkedIn labels appear in a row with " || " separators
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        infoPanel.add(emailLabel);
        infoPanel.add(new JLabel(" || "));
        infoPanel.add(phoneLabel);
        infoPanel.add(new JLabel(" || "));
        infoPanel.add(linkedinLabel);

        frame.getContentPane().add(infoPanel, BorderLayout.NORTH);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.PAGE_AXIS));  // Use BoxLayout with vertical alignment

        JLabel educationLabel = new JLabel(" Education");
        educationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        educationLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        JLabel collegeLabel = new JLabel(" College: " + data.getProperty("College: "));
        collegeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        collegeLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel graduationLabel = new JLabel(" Graduation Date: " + data.getProperty("Graduation Date: "));
        graduationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        graduationLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel majorLabel = new JLabel(" Major: " + data.getProperty("Major: "));
        majorLabel.setHorizontalAlignment(SwingConstants.LEFT);
        majorLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel gpaLabel = new JLabel(" GPA: " + data.getProperty("GPA: "));
        gpaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gpaLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel honorsLabel = new JLabel(" Honors: " + data.getProperty("Honors"));
        honorsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        honorsLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel relCourseLabel = new JLabel(" Relevant Coursework: " + data.getProperty("Relevant Coursework: "));
        relCourseLabel.setHorizontalAlignment(SwingConstants.LEFT);
        relCourseLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel space = new JLabel("          ");
        space.setHorizontalAlignment(SwingConstants.LEFT);
        space.setFont(new Font("SansSerif", Font.PLAIN, 14));

        bodyPanel.add(educationLabel);
        bodyPanel.add(collegeLabel);
        bodyPanel.add(graduationLabel);
        bodyPanel.add(majorLabel);
        bodyPanel.add(gpaLabel);
        bodyPanel.add(honorsLabel);
        bodyPanel.add(space);

        JLabel workExperienceLabel = new JLabel(" Work Experience");
        workExperienceLabel.setHorizontalAlignment(SwingConstants.LEFT);
        workExperienceLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        JLabel companyLabel = new JLabel(" Company: " + data.getProperty("Company: "));
        companyLabel.setHorizontalAlignment(SwingConstants.LEFT);
        companyLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel positionLabel = new JLabel(" Position: " + data.getProperty("Position: "));
        positionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        positionLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel timePeriodLabel = new JLabel(" Time period: " + data.getProperty("Time period: "));
        timePeriodLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        timePeriodLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel description1st = new JLabel(" \u2022  " + data.getProperty("Description(1st bullet point): "));
        description1st.setHorizontalAlignment(SwingConstants.LEFT);
        description1st.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel description2nd = new JLabel(" \u2022  " + data.getProperty("Description(2nd bullet point): "));
        description2nd.setHorizontalAlignment(SwingConstants.RIGHT);
        description2nd.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel description3rd = new JLabel(" \u2022  " + data.getProperty("Description(3rd bullet point): "));
        description3rd.setHorizontalAlignment(SwingConstants.LEFT);
        description3rd.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel space0 = new JLabel("          ");
        space0.setHorizontalAlignment(SwingConstants.LEFT);
        space0.setFont(new Font("SansSerif", Font.PLAIN, 14));

        bodyPanel.add(workExperienceLabel);
        bodyPanel.add(companyLabel);
        bodyPanel.add(positionLabel);
        bodyPanel.add(timePeriodLabel);
        bodyPanel.add(description1st);
        bodyPanel.add(description2nd);
        bodyPanel.add(description3rd);
        bodyPanel.add(space0);

        JLabel projectLabel = new JLabel(" Projects");
        projectLabel.setHorizontalAlignment(SwingConstants.LEFT);
        projectLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        JLabel projectNameLabel = new JLabel(" Project name: " + data.getProperty("Project name: "));
        projectNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        projectNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel roleLabel = new JLabel(" Project Role: " + data.getProperty("Project Role: "));
        roleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel timeDurationLabel = new JLabel(" Time duration: " + data.getProperty("Time duration: "));
        timeDurationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        timeDurationLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel descriptionPoint1st = new JLabel(" \u2022  " + data.getProperty("1st bullet point Description: "));
        descriptionPoint1st.setHorizontalAlignment(SwingConstants.LEFT);
        descriptionPoint1st.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel descriptionPoint2nd = new JLabel(" \u2022  " + data.getProperty("2nd bullet point Description: "));
        descriptionPoint2nd.setHorizontalAlignment(SwingConstants.RIGHT);
        descriptionPoint2nd.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel descriptionPoint3rd = new JLabel(" \u2022  " + data.getProperty("3rd bullet point Description: "));
        descriptionPoint3rd.setHorizontalAlignment(SwingConstants.LEFT);
        descriptionPoint3rd.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel space1 = new JLabel("          ");
        space1.setHorizontalAlignment(SwingConstants.LEFT);
        space1.setFont(new Font("SansSerif", Font.PLAIN, 14));


        bodyPanel.add(projectLabel);
        bodyPanel.add(projectNameLabel);
        bodyPanel.add(roleLabel);
        bodyPanel.add(timeDurationLabel);
        bodyPanel.add(descriptionPoint1st);
        bodyPanel.add(descriptionPoint2nd);
        bodyPanel.add(descriptionPoint3rd);
        bodyPanel.add(space1);

        JLabel communityLabel = new JLabel(" Community and Involvement");
        communityLabel.setHorizontalAlignment(SwingConstants.LEFT);
        communityLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        JLabel organizationLabel = new JLabel(" Organization: " + data.getProperty("Organization: "));
        organizationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        organizationLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel rolePositionLabel = new JLabel(" Role: " + data.getProperty("Role: "));
        rolePositionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        rolePositionLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel durationLabel = new JLabel(" Duration: " + data.getProperty("Duration: "));
        durationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        durationLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel describeLabel1 = new JLabel(" \u2022  " + data.getProperty("Describe(1st bullet point): "));
        describeLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        describeLabel1.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel describeLabel2 = new JLabel(" \u2022  " + data.getProperty("Describe(2nd bullet point): "));
        describeLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        describeLabel2.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel describeLabel3 = new JLabel(" \u2022  " + data.getProperty("Describe(3rd bullet point): "));
        describeLabel3.setHorizontalAlignment(SwingConstants.LEFT);
        describeLabel3.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel space2 = new JLabel("          ");
        space2.setHorizontalAlignment(SwingConstants.LEFT);
        space2.setFont(new Font("SansSerif", Font.PLAIN, 14));


        bodyPanel.add(communityLabel);
        bodyPanel.add(organizationLabel);
        bodyPanel.add(rolePositionLabel);
        bodyPanel.add(durationLabel);
        bodyPanel.add(describeLabel1);
        bodyPanel.add(describeLabel2);
        bodyPanel.add(describeLabel3);
        bodyPanel.add(space2);

        JLabel skillsLabel = new JLabel(" Skills");
        skillsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        skillsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        JLabel specificSkillsLabel = new JLabel(" Skills: " + data.getProperty("Specific Skills: "));
        specificSkillsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        specificSkillsLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel languagesLabel = new JLabel(" Languages: " + data.getProperty("Languages Spoken: "));
        languagesLabel.setHorizontalAlignment(SwingConstants.LEFT);
        languagesLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel interestsLabel = new JLabel(" Interests: " + data.getProperty("Interests: "));
        interestsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        interestsLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        bodyPanel.add(skillsLabel);
        bodyPanel.add(specificSkillsLabel);
        bodyPanel.add(languagesLabel);
        bodyPanel.add(interestsLabel);

        frame.getContentPane().add(bodyPanel, BorderLayout.LINE_START);

        frame.setPreferredSize(new Dimension(1100, 800));

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
        PrimaryInfo.createAndShowGUI();
    }
}