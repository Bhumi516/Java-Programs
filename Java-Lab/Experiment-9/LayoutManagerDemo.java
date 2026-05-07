// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 9: Implementation of programs for demonstrating different Layout Managers
// Program 1: FlowLayout, BorderLayout, GridLayout

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LayoutManagerDemo extends JFrame implements ActionListener {

    private JTabbedPane tabbedPane;

    LayoutManagerDemo() {
        setTitle("Layout Manager Demo");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("FlowLayout",   createFlowLayoutPanel());
        tabbedPane.addTab("BorderLayout", createBorderLayoutPanel());
        tabbedPane.addTab("GridLayout",   createGridLayoutPanel());

        add(tabbedPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ====================================================
    // Tab 1 — FlowLayout
    // Arranges components left-to-right, wraps to next row
    // ====================================================
    JPanel createFlowLayoutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel info = new JLabel(
            "<html><b>FlowLayout</b>: Components are placed left-to-right, "
            + "top-to-bottom. They wrap when the row is full.</html>"
        );
        info.setPreferredSize(new Dimension(500, 50));
        panel.add(info);

        String[] colors = { "Red", "Green", "Blue", "Yellow", "Orange",
                            "Pink", "Cyan", "Magenta", "White" };
        Color[]  clrs   = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
                            Color.ORANGE, Color.PINK, Color.CYAN, Color.MAGENTA, Color.WHITE };

        for (int i = 0; i < colors.length; i++) {
            JButton btn = new JButton(colors[i]);
            btn.setBackground(clrs[i]);
            btn.setPreferredSize(new Dimension(100, 40));
            btn.addActionListener(this);
            panel.add(btn);
        }
        return panel;
    }

    // ====================================================
    // Tab 2 — BorderLayout
    // Divides container into 5 regions: N, S, E, W, CENTER
    // ====================================================
    JPanel createBorderLayoutPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton north  = new JButton("NORTH  (Navigation Bar)");
        JButton south  = new JButton("SOUTH  (Status Bar)");
        JButton east   = new JButton("EAST");
        JButton west   = new JButton("WEST");
        JTextArea center = new JTextArea(
            "CENTER\n\nThis is the main content area.\n"
            + "BorderLayout divides the container into\n"
            + "5 regions: NORTH, SOUTH, EAST, WEST, CENTER.\n\n"
            + "Click the buttons around this area!"
        );
        center.setEditable(false);
        center.setFont(new Font("Monospaced", Font.PLAIN, 13));

        north.setBackground(new Color(70, 130, 180));
        north.setForeground(Color.WHITE);
        south.setBackground(new Color(100, 149, 237));
        south.setForeground(Color.WHITE);
        east.setBackground(new Color(60, 179, 113));
        east.setForeground(Color.WHITE);
        west.setBackground(new Color(218, 112, 214));
        west.setForeground(Color.WHITE);

        north.addActionListener(this);
        south.addActionListener(this);
        east.addActionListener(this);
        west.addActionListener(this);

        panel.add(north,  BorderLayout.NORTH);
        panel.add(south,  BorderLayout.SOUTH);
        panel.add(east,   BorderLayout.EAST);
        panel.add(west,   BorderLayout.WEST);
        panel.add(new JScrollPane(center), BorderLayout.CENTER);
        return panel;
    }

    // ====================================================
    // Tab 3 — GridLayout
    // Arranges components in equal-sized rows and columns
    // ====================================================
    JPanel createGridLayoutPanel() {
        JPanel outer = new JPanel(new BorderLayout());

        JLabel info = new JLabel(
            "<html><b>GridLayout (4x3)</b>: Arranges components in a grid. "
            + "All cells are equal size — perfect for calculators!</html>",
            SwingConstants.CENTER
        );
        info.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Simple calculator keypad layout
        JPanel grid = new JPanel(new GridLayout(4, 3, 5, 5));
        grid.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        String[] keys = { "7", "8", "9", "4", "5", "6",
                          "1", "2", "3", "0", ".", "=" };

        for (String key : keys) {
            JButton btn = new JButton(key);
            btn.setFont(new Font("SansSerif", Font.BOLD, 18));
            if (key.equals("=")) {
                btn.setBackground(new Color(255, 140, 0));
                btn.setForeground(Color.WHITE);
            } else if (key.matches("[0-9]|\\.")) {
                btn.setBackground(new Color(230, 230, 230));
            }
            btn.addActionListener(this);
            grid.add(btn);
        }

        outer.add(info, BorderLayout.NORTH);
        outer.add(grid, BorderLayout.CENTER);
        return outer;
    }

    // ====================================================
    // ActionListener — show which button was clicked
    // ====================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton src = (JButton) e.getSource();
        JOptionPane.showMessageDialog(this,
            "Button clicked: \"" + src.getText() + "\"",
            "Event Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LayoutManagerDemo());
    }
}

