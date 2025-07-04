import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicCalculator extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subButton, mulButton, divButton, clearButton;

    public BasicCalculator() {
        // Set up the frame
        setTitle("Basic Calculator");
        setLayout(new GridLayout(5, 2, 10, 10));
        
        // Components
        JLabel num1Label = new JLabel("Number 1:");
        JLabel num2Label = new JLabel("Number 2:");
        JLabel resultLabel = new JLabel("Result:");

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("Add");
        subButton = new JButton("Subtract");
        mulButton = new JButton("Multiply");
        divButton = new JButton("Divide");
        clearButton = new JButton("Clear");

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add components to frame
        add(num1Label); add(num1Field);
        add(num2Label); add(num2Field);
        add(resultLabel); add(resultField);
        add(addButton); add(subButton);
        add(mulButton); add(divButton);
        add(new JLabel()); add(clearButton); // Empty label for alignment

        // Frame settings
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = 0, num2 = 0;
        try {
            num1 = Double.parseDouble(num1Field.getText());
            num2 = Double.parseDouble(num2Field.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            return;
        }

        if (e.getSource() == addButton) {
            resultField.setText(String.valueOf(num1 + num2));
        } else if (e.getSource() == subButton) {
            resultField.setText(String.valueOf(num1 - num2));
        } else if (e.getSource() == mulButton) {
            resultField.setText(String.valueOf(num1 * num2));
        } else if (e.getSource() == divButton) {
            if (num2 == 0) {
                JOptionPane.showMessageDialog(this, "Cannot divide by zero.");
            } else {
                resultField.setText(String.valueOf(num1 / num2));
            }
        } else if (e.getSource() == clearButton) {
            num1Field.setText("");
            num2Field.setText("");
            resultField.setText("");
        }
    }

    public static void main(String[] args) {
        new BasicCalculator();
    }
}

