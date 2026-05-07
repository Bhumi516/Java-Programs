// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 8: Implementation of different types of event handling
// Program 2: ItemEvent (Checkbox/ComboBox), FocusEvent, WindowEvent

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemFocusWindowEventDemo extends JFrame
        implements ItemListener, FocusListener, WindowListener {

    private JCheckBox boldCB, italicCB;
    private JComboBox<String> fontCombo;
    private JTextField nameField, emailField;
    private JLabel previewLabel;
    private JTextArea logArea;

    ItemFocusWindowEventDemo() {
        setTitle("Item, Focus & Window Events");
        setSize(600, 500);
        setLayout(new BorderLayout(10, 10));

        // ---- Window event (add listener to this JFrame) ----
        addWindowListener(this);

        // ---- Top: Font Styling Panel ----
        JPanel stylePanel = new JPanel(new FlowLayout());
        stylePanel.setBorder(BorderFactory.createTitledBorder("ItemEvent — Checkbox & ComboBox"));

        boldCB   = new JCheckBox("Bold");
        italicCB = new JCheckBox("Italic");
        boldCB.addItemListener(this);
        italicCB.addItemListener(this);

        String[] fonts = { "Serif", "SansSerif", "Monospaced", "Dialog" };
        fontCombo = new JComboBox<>(fonts);
        fontCombo.addItemListener(this);

        previewLabel = new JLabel("Preview Text — Bhumi Bhadre");
        previewLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        previewLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        previewLabel.setPreferredSize(new Dimension(280, 40));
        previewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        stylePanel.add(boldCB);
        stylePanel.add(italicCB);
        stylePanel.add(new JLabel("  Font:"));
        stylePanel.add(fontCombo);
        stylePanel.add(previewLabel);

        // ---- Middle: Focus Event Panel ----
        JPanel focusPanel = new JPanel(new GridLayout(2, 2, 10, 5));
        focusPanel.setBorder(BorderFactory.createTitledBorder("FocusEvent — Text Fields"));

        nameField  = new JTextField();
        emailField = new JTextField();
        nameField.addFocusListener(this);
        emailField.addFocusListener(this);

        focusPanel.add(new JLabel("  Name:"));
        focusPanel.add(nameField);
        focusPanel.add(new JLabel("  Email:"));
        focusPanel.add(emailField);

        // ---- Bottom: Event Log ----
        logArea = new JTextArea(10, 50);
        logArea.setEditable(false);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        JScrollPane scroll = new JScrollPane(logArea);
        scroll.setBorder(BorderFactory.createTitledBorder("Event Log"));

        // ---- Layout ----
        JPanel topCenter = new JPanel(new GridLayout(2, 1, 5, 5));
        topCenter.add(stylePanel);
        topCenter.add(focusPanel);

        add(topCenter, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);

        log("=== Item, Focus & Window Event Demo ===");
        log("Try checking boxes, changing font, clicking in fields.");
    }

    void log(String msg) {
        logArea.append(msg + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    // Update preview label font
    void updatePreview() {
        String selectedFont = (String) fontCombo.getSelectedItem();
        int style = Font.PLAIN;
        if (boldCB.isSelected())   style |= Font.BOLD;
        if (italicCB.isSelected()) style |= Font.ITALIC;
        previewLabel.setFont(new Font(selectedFont, style, 18));
    }

    // ====================================================
    // ItemListener — Checkbox & ComboBox changes
    // ====================================================
    @Override
    public void itemStateChanged(ItemEvent e) {
        String state = (e.getStateChange() == ItemEvent.SELECTED) ? "SELECTED" : "DESELECTED";
        if (e.getSource() == boldCB) {
            log("[ItemEvent] Bold checkbox → " + state);
        } else if (e.getSource() == italicCB) {
            log("[ItemEvent] Italic checkbox → " + state);
        } else if (e.getSource() == fontCombo) {
            log("[ItemEvent] Font ComboBox → " + e.getItem() + " (" + state + ")");
        }
        updatePreview();
    }

    // ====================================================
    // FocusListener — Text field focus gained/lost
    // ====================================================
    @Override
    public void focusGained(FocusEvent e) {
        String field = (e.getSource() == nameField) ? "Name" : "Email";
        log("[FocusEvent] focusGained → " + field + " field");
    }

    @Override
    public void focusLost(FocusEvent e) {
        String field = (e.getSource() == nameField) ? "Name" : "Email";
        String value = (e.getSource() == nameField)
                ? nameField.getText() : emailField.getText();
        log("[FocusEvent] focusLost  → " + field + " field  Value entered: \"" + value + "\"");
    }

    // ====================================================
    // WindowListener — Window lifecycle events
    // ====================================================
    @Override
    public void windowOpened(WindowEvent e)    { log("[WindowEvent] windowOpened"); }

    @Override
    public void windowClosing(WindowEvent e)   {
        log("[WindowEvent] windowClosing — Goodbye!");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e)    { log("[WindowEvent] windowClosed"); }

    @Override
    public void windowIconified(WindowEvent e) { log("[WindowEvent] windowIconified (minimized)"); }

    @Override
    public void windowDeiconified(WindowEvent e) { log("[WindowEvent] windowDeiconified (restored)"); }

    @Override
    public void windowActivated(WindowEvent e)   { log("[WindowEvent] windowActivated"); }

    @Override
    public void windowDeactivated(WindowEvent e) { log("[WindowEvent] windowDeactivated"); }

    // ====================================================
    // Main method
    // ====================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ItemFocusWindowEventDemo());
    }
}

