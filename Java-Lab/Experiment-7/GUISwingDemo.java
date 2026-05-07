// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 7: Implementation of a program for designing the GUI using swing components
// Program 1: Basic Swing Components (JLabel, JButton, JTextField, JTextArea)

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUISwingDemo extends JFrame {
    private JTextField nameField;
    private JTextArea displayArea;
    private JButton submitBtn, clearBtn;

    public GUISwingDemo() {
        // Set Frame properties
        setTitle("Swing Components Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // Create components
        JLabel label = new JLabel("Enter your name:");
        nameField = new JTextField(20);
        submitBtn = new JButton("Submit");
        clearBtn  = new JButton("Clear");
        displayArea = new JTextArea(5, 30);
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Add action listeners
        submitBtn.addActionListener(e -> {
            String name = nameField.getText();
            if (!name.isEmpty()) {
                displayArea.append("Hello, " + name + "! Welcome to Java Swing.\n");
                nameField.setText("");
            }
        });

        clearBtn.addActionListener(e -> {
            displayArea.setText("");
            nameField.setText("");
        });

        // Add components to frame
        add(label);
        add(nameField);
        add(submitBtn);
        add(clearBtn);
        add(new JScrollPane(displayArea));

        // Center on screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new GUISwingDemo());
    }
}

