// Name   : Prachi Chavan
// Roll No: 44
// Experiment 8: Implementation of different types of event handling
// Program 1: Demonstrates ActionEvent, MouseEvent, KeyEvent, WindowEvent

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventHandlingDemo extends JFrame
        implements ActionListener, MouseListener, KeyListener {

    // Components
    private JButton clickBtn;
    private JButton clearBtn;
    private JTextField inputField;
    private JTextArea outputArea;
    private JLabel statusLabel;
    private int clickCount = 0;

    // Constructor
    EventHandlingDemo() {
        setTitle("Event Handling Demo");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ---- Top Panel: Input + Buttons ----
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBorder(BorderFactory.createTitledBorder("Input & Button Events"));

        inputField = new JTextField(15);
        inputField.addKeyListener(this);

        clickBtn = new JButton("Click Me!");
        clickBtn.addActionListener(this);
        clickBtn.addMouseListener(this);

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(this);

        topPanel.add(new JLabel("Type here:"));
        topPanel.add(inputField);
        topPanel.add(clickBtn);
        topPanel.add(clearBtn);

        // ---- Center Panel: Output Area ----
        outputArea = new JTextArea(12, 45);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Event Log"));

        // ---- Bottom Panel: Status Label ----
        statusLabel = new JLabel("Status: Ready — Try clicking, typing, or hovering!");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);

        log("=== Event Handling Demo Started ===");
        log("Try: clicking buttons, typing in the text field, hovering over buttons.");
    }

    // ---- Helper: append to log ----
    void log(String message) {
        outputArea.append(message + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    // ====================================================
    // ActionListener — Button click events
    // ====================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clickBtn) {
            clickCount++;
            log("[ActionEvent] Button clicked! Total clicks: " + clickCount);
            statusLabel.setText("Status: Button clicked " + clickCount + " time(s)");
        } else if (e.getSource() == clearBtn) {
            outputArea.setText("");
            clickCount = 0;
            inputField.setText("");
            log("[ActionEvent] Cleared! Click count reset.");
            statusLabel.setText("Status: Cleared.");
        }
    }

    // ====================================================
    // MouseListener — Mouse events
    // ====================================================
    @Override
    public void mouseClicked(MouseEvent e) {
        log("[MouseEvent] mouseClicked — Button: " + e.getButton()
                + "  Clicks: " + e.getClickCount()
                + "  at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        String src = (e.getSource() == clickBtn) ? "Click Me! button"
                   : (e.getSource() == clearBtn) ? "Clear button"
                   : "Output area";
        log("[MouseEvent] mouseEntered → " + src);
        statusLabel.setText("Status: Mouse entered " + src);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        log("[MouseEvent] mouseExited");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        log("[MouseEvent] mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        log("[MouseEvent] mouseReleased");
    }

    // ====================================================
    // KeyListener — Keyboard events
    // ====================================================
    @Override
    public void keyTyped(KeyEvent e) {
        log("[KeyEvent] keyTyped   → char: '" + e.getKeyChar() + "'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        log("[KeyEvent] keyPressed → keyCode: " + e.getKeyCode()
                + "  key: " + KeyEvent.getKeyText(e.getKeyCode()));
        statusLabel.setText("Status: Key pressed — " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        log("[KeyEvent] keyReleased → key: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    // ====================================================
    // Main method
    // ====================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventHandlingDemo());
    }
}
