// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 9: Implementation of programs for demonstrating different Layout Managers
// Program 2: GridBagLayout and CardLayout

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridBagCardLayoutDemo extends JFrame implements ActionListener {

    private JTabbedPane tabbedPane;

    GridBagCardLayoutDemo() {
        setTitle("GridBagLayout & CardLayout Demo");
        setSize(600, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("GridBagLayout", createGridBagPanel());
        tabbedPane.addTab("CardLayout",    createCardLayoutPanel());

        add(tabbedPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ====================================================
    // Tab 1 — GridBagLayout
    // Flexible grid — cells can span multiple rows/columns
    // ====================================================
    JPanel createGridBagPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill   = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel(
            "<html><b>GridBagLayout</b>: A powerful layout where each component "
            + "can span multiple rows/columns with custom weights.</html>"
        );
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // First Name
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        panel.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        panel.add(new JTextField(15), gbc);

        // Last Name
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3;
        panel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        panel.add(new JTextField(15), gbc);

        // Email (spans full width)
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.3;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        panel.add(new JTextField(20), gbc);

        // Phone
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0.3;
        panel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        panel.add(new JTextField(12), gbc);

        // Address — spans 2 rows via textarea
        gbc.gridx = 0; gbc.gridy = 5; gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.NORTH;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7; gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        JTextArea addr = new JTextArea(3, 20);
        addr.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(addr, gbc);

        // Submit button
        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
        gbc.gridheight = 1; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitBtn = new JButton("  Submit  ");
        submitBtn.setBackground(new Color(70, 130, 180));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.addActionListener(this);
        panel.add(submitBtn, gbc);

        return panel;
    }

    // ====================================================
    // Tab 2 — CardLayout
    // Shows one card (panel) at a time — like a wizard/tabs
    // ====================================================
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JButton prevBtn, nextBtn;
    private JLabel pageLabel;
    private String[] cardNames = { "Card 1", "Card 2", "Card 3" };
    private int currentCard = 0;

    JPanel createCardLayoutPanel() {
        JPanel outer = new JPanel(new BorderLayout(5, 5));
        outer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel info = new JLabel(
            "<html><b>CardLayout</b>: Stacks components like a deck of cards. "
            + "Only one card visible at a time. Great for wizards/tabs.</html>",
            SwingConstants.CENTER
        );
        info.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Cards
        cardLayout = new CardLayout();
        cardPanel  = new JPanel(cardLayout);

        // Card 1
        JPanel c1 = new JPanel(new GridLayout(3, 1, 10, 10));
        c1.setBorder(BorderFactory.createTitledBorder("Card 1 — Personal Info"));
        c1.setBackground(new Color(224, 255, 255));
        c1.add(new JLabel("  Name   : Bhumi Bhadre",    SwingConstants.LEFT));
        c1.add(new JLabel("  Roll No: 31",             SwingConstants.LEFT));
        c1.add(new JLabel("  Class  : SY Computer Engg", SwingConstants.LEFT));

        // Card 2
        JPanel c2 = new JPanel(new GridLayout(3, 1, 10, 10));
        c2.setBorder(BorderFactory.createTitledBorder("Card 2 — Academic Info"));
        c2.setBackground(new Color(255, 255, 224));
        c2.add(new JLabel("  Branch  : Computer Engineering", SwingConstants.LEFT));
        c2.add(new JLabel("  Subject  : Java Programming",    SwingConstants.LEFT));
        c2.add(new JLabel("  Lab      : Experiment 9",        SwingConstants.LEFT));

        // Card 3
        JPanel c3 = new JPanel(new GridLayout(3, 1, 10, 10));
        c3.setBorder(BorderFactory.createTitledBorder("Card 3 — Contact Info"));
        c3.setBackground(new Color(255, 228, 225));
        c3.add(new JLabel("  Email   : atharv@email.com",  SwingConstants.LEFT));
        c3.add(new JLabel("  Phone   : 9876543210",        SwingConstants.LEFT));
        c3.add(new JLabel("  Address : Ichalkaranji",      SwingConstants.LEFT));

        cardPanel.add(c1, cardNames[0]);
        cardPanel.add(c2, cardNames[1]);
        cardPanel.add(c3, cardNames[2]);

        // Navigation buttons
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        prevBtn   = new JButton("◀  Previous");
        nextBtn   = new JButton("Next  ▶");
        pageLabel = new JLabel("Page 1 of 3", SwingConstants.CENTER);
        pageLabel.setPreferredSize(new Dimension(100, 30));

        prevBtn.setEnabled(false);
        prevBtn.addActionListener(this);
        nextBtn.addActionListener(this);

        navPanel.add(prevBtn);
        navPanel.add(pageLabel);
        navPanel.add(nextBtn);

        outer.add(info,      BorderLayout.NORTH);
        outer.add(cardPanel, BorderLayout.CENTER);
        outer.add(navPanel,  BorderLayout.SOUTH);
        return outer;
    }

    // ====================================================
    // ActionListener
    // ====================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevBtn) {
            currentCard--;
            cardLayout.show(cardPanel, cardNames[currentCard]);
        } else if (e.getSource() == nextBtn) {
            currentCard++;
            cardLayout.show(cardPanel, cardNames[currentCard]);
        } else {
            JOptionPane.showMessageDialog(this, "Form Submitted!",
                "GridBagLayout Demo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        pageLabel.setText("Page " + (currentCard + 1) + " of " + cardNames.length);
        prevBtn.setEnabled(currentCard > 0);
        nextBtn.setEnabled(currentCard < cardNames.length - 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GridBagCardLayoutDemo());
    }
}

