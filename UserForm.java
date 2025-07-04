import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserForm extends JFrame implements ActionListener {
    private JTextField nameField;
    private JRadioButton maleButton, femaleButton;
    private JCheckBox musicBox, swimmingBox;
    private JComboBox<String> countryBox;
    private JTextArea detailsArea;
    private JButton submitButton, exitButton;
    
    public UserForm() {
        setTitle("Welcome to fahmidasclassroom");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Components
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);

        JLabel genderLabel = new JLabel("Gender:");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JLabel interestLabel = new JLabel("Interest:");
        musicBox = new JCheckBox("Music");
        swimmingBox = new JCheckBox("Swimming");

        JLabel placeLabel = new JLabel("Favourite Place:");
        String[] places = {"Bangladesh", "India", "USA", "UK"};
        countryBox = new JComboBox<>(places);

        JLabel detailsLabel = new JLabel("Details:");
        detailsArea = new JTextArea(5, 20);
        detailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detailsArea);

        submitButton = new JButton("Submit");
        exitButton = new JButton("Exit");

        submitButton.addActionListener(this);
        exitButton.addActionListener(e -> System.exit(0));

        // Layout using GridBag
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(genderLabel, gbc);
        gbc.gridx = 1;
        add(maleButton, gbc);
        gbc.gridx = 2;
        add(femaleButton, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(interestLabel, gbc);
        gbc.gridx = 1;
        add(musicBox, gbc);
        gbc.gridx = 2;
        add(swimmingBox, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(placeLabel, gbc);
        gbc.gridx = 1;
        add(countryBox, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(detailsLabel, gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        add(scrollPane, gbc);

        gbc.gridx = 1; gbc.gridy++;
        add(submitButton, gbc);
        gbc.gridx = 2;
        add(exitButton, gbc);

        // Frame settings
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText().trim();
        String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Not selected";
        String interests = "";
        if (musicBox.isSelected()) interests += "Music ";
        if (swimmingBox.isSelected()) interests += "Swimming ";
        String place = (String) countryBox.getSelectedItem();

        String details = "Name: " + name +
                         "\nGender: " + gender +
                         "\nInterest(s): " + (interests.isEmpty() ? "None" : interests.trim()) +
                         "\nFavourite Place: " + place;

        detailsArea.setText(details);
    }

    public static void main(String[] args) {
        new UserForm();
    }
}
