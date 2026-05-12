package com.mycompany.finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameInfo extends javax.swing.JFrame {

    public GameInfo() {
        initComponents();
        setLocationRelativeTo(null);
        loadTabs();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adventure Shooter - Game Info");
        setResizable(false);
        getContentPane().setLayout(null);

        contentPanel.setBackground(new java.awt.Color(40, 40, 60));
        contentPanel.setLayout(null);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 24));
        jLabelTitle.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("GAME INFO");
        contentPanel.add(jLabelTitle);
        jLabelTitle.setBounds(50, 15, 540, 35);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));
        contentPanel.add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 60, 600, 360);

        jButton1.setBackground(new java.awt.Color(150, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        contentPanel.add(jButton1);
        jButton1.setBounds(245, 435, 150, 40);

        getContentPane().add(contentPanel);
        contentPanel.setBounds(0, 0, 640, 520);

        setSize(new java.awt.Dimension(640, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void loadTabs() {
        jTabbedPane1.addTab("Story", buildPanel(
                "THE LEGEND BEGINS",
                "A dark force has invaded the kingdom.\n\n"
                + "Monsters pour out of the shadow rift, and only one\n"
                + "hero brave enough remains to push them back.\n\n"
                + "Choose your character, pick your weapon, and survive\n"
                + "as long as you can. The kingdom's fate depends on\n"
                + "your aim, your reflexes, and your courage.\n\n"
                + "Are you ready to begin the adventure?"));

        jTabbedPane1.addTab("Controls", buildPanel(
                "HOW TO PLAY",
                "MOVEMENT:\n"
                + "  Left Arrow  -  Move Left\n"
                + "  Right Arrow -  Move Right\n"
                + "  Up Arrow    -  Move Up\n"
                + "  Down Arrow  -  Move Down\n\n"
                + "SHOOTING:\n"
                + "  SPACEBAR    -  Fire weapon\n\n"
                + "OTHER:\n"
                + "  P           -  Pause / Resume\n"
                + "  ESC         -  Return to Main Menu"));

        jTabbedPane1.addTab("Enemies", buildPanel(
                "KNOW YOUR ENEMIES",
                "GOBLIN  (Red)\n"
                + "  Slow but plentiful. Worth 10 points.\n\n"
                + "ORC     (Green)\n"
                + "  Tougher and faster. Worth 25 points.\n\n"
                + "WIZARD  (Purple)\n"
                + "  Rare elite enemy. Worth 50 points.\n\n"
                + "Hard Mode: All enemies move faster and spawn\n"
                + "more often. Score multiplier x2!"));

        jTabbedPane1.addTab("Tips", buildPanel(
                "SURVIVAL TIPS",
                "1. Keep moving! A still hero is a dead hero.\n\n"
                + "2. Aim for the elite enemies - they are worth\n"
                + "   the most points.\n\n"
                + "3. The Mage hits hardest but dies fastest.\n"
                + "   Stay at the bottom of the map.\n\n"
                + "4. The Warrior can take hits - use that armor\n"
                + "   to push forward into danger zones.\n\n"
                + "5. The Archer balances both - perfect for\n"
                + "   beginners trying Hard Mode."));

        jTabbedPane1.addTab("Credits", buildPanel(
                "CREDITS",
                "Adventure Shooter\n\n"
                + "Final Project for Java Swing\n\n"
                + "Components Demonstrated:\n"
                + "  - JRadioButton  (Character Select)\n"
                + "  - JCheckBox     (Hard Mode toggle)\n"
                + "  - JList         (Weapon Select)\n"
                + "  - JTabbedPane   (this Game Info screen)\n"
                + "  - JButton       (navigation)\n"
                + "  - JLabel        (text and titles)\n\n"
                + "Built with NetBeans IDE"));
    }

    private JPanel buildPanel(String title, String body) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(25, 25, 40));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel header = new JLabel(title);
        header.setFont(new Font("Tahoma", Font.BOLD, 18));
        header.setForeground(Color.YELLOW);
        panel.add(header, BorderLayout.NORTH);

        JTextArea text = new JTextArea(body);
        text.setEditable(false);
        text.setFont(new Font("Consolas", Font.PLAIN, 14));
        text.setBackground(new Color(25, 25, 40));
        text.setForeground(Color.WHITE);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(text);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(25, 25, 40));
        panel.add(scroll, BorderLayout.CENTER);
        return panel;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new MainMenu().setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new GameInfo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel contentPanel;
    // End of variables declaration//GEN-END:variables
}
