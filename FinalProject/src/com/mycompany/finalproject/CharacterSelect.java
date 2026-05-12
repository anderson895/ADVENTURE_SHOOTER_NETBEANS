package com.mycompany.finalproject;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class CharacterSelect extends javax.swing.JFrame {

    private final ButtonGroup characterGroup = new ButtonGroup();

    public CharacterSelect() {
        initComponents();
        setLocationRelativeTo(null);
        characterGroup.add(jRB1);
        characterGroup.add(jRB2);
        characterGroup.add(jRB3);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRB1 = new javax.swing.JRadioButton();
        jRB2 = new javax.swing.JRadioButton();
        jRB3 = new javax.swing.JRadioButton();
        jLabelDesc = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adventure Shooter - Character Select");
        setResizable(false);
        getContentPane().setLayout(null);

        contentPanel.setBackground(new java.awt.Color(40, 40, 60));
        contentPanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD | java.awt.Font.ITALIC, 24));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose your hero!");
        contentPanel.add(jLabel1);
        jLabel1.setBounds(50, 30, 500, 35);

        jRB1.setBackground(new java.awt.Color(40, 40, 60));
        jRB1.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16));
        jRB1.setForeground(new java.awt.Color(255, 255, 255));
        jRB1.setSelected(true);
        jRB1.setText("Warrior  (HP: 150, ATK: 20)");
        jRB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB1ActionPerformed(evt);
            }
        });
        contentPanel.add(jRB1);
        jRB1.setBounds(80, 90, 320, 30);

        jRB2.setBackground(new java.awt.Color(40, 40, 60));
        jRB2.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16));
        jRB2.setForeground(new java.awt.Color(255, 255, 255));
        jRB2.setText("Archer   (HP: 100, ATK: 30)");
        jRB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB2ActionPerformed(evt);
            }
        });
        contentPanel.add(jRB2);
        jRB2.setBounds(80, 130, 320, 30);

        jRB3.setBackground(new java.awt.Color(40, 40, 60));
        jRB3.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16));
        jRB3.setForeground(new java.awt.Color(255, 255, 255));
        jRB3.setText("Mage     (HP: 80,  ATK: 40)");
        jRB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB3ActionPerformed(evt);
            }
        });
        contentPanel.add(jRB3);
        jRB3.setBounds(80, 170, 320, 30);

        jLabelDesc.setFont(new java.awt.Font("Tahoma", java.awt.Font.ITALIC, 14));
        jLabelDesc.setForeground(new java.awt.Color(255, 255, 0));
        jLabelDesc.setText("A balanced fighter with high HP.");
        contentPanel.add(jLabelDesc);
        jLabelDesc.setBounds(80, 215, 450, 25);

        jCheckBox1.setBackground(new java.awt.Color(40, 40, 60));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Hard Mode (Enemies are faster and stronger)");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        contentPanel.add(jCheckBox1);
        jCheckBox1.setBounds(80, 260, 450, 30);

        jButton1.setBackground(new java.awt.Color(0, 150, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        contentPanel.add(jButton1);
        jButton1.setBounds(110, 330, 150, 40);

        jButton2.setBackground(new java.awt.Color(150, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        contentPanel.add(jButton2);
        jButton2.setBounds(330, 330, 150, 40);

        getContentPane().add(contentPanel);
        contentPanel.setBounds(0, 0, 600, 450);

        setSize(new java.awt.Dimension(600, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void jRB1ActionPerformed(java.awt.event.ActionEvent evt) {
        jLabelDesc.setText("A balanced fighter with high HP.");
    }

    private void jRB2ActionPerformed(java.awt.event.ActionEvent evt) {
        jLabelDesc.setText("Quick shooter with strong attack power.");
    }

    private void jRB3ActionPerformed(java.awt.event.ActionEvent evt) {
        jLabelDesc.setText("Glass cannon - low HP but devastating damage.");
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jCheckBox1.isSelected()) {
            jCheckBox1.setForeground(Color.RED);
            jCheckBox1.setText("Hard Mode is ON - Good luck, hero!");
        } else {
            jCheckBox1.setForeground(Color.WHITE);
            jCheckBox1.setText("Hard Mode (Enemies are faster and stronger)");
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jRB1.isSelected()) {
            GameState.character = "Warrior";
            JOptionPane.showMessageDialog(this,
                    "Warrior selected! Your high HP will keep you alive.");
        } else if (jRB2.isSelected()) {
            GameState.character = "Archer";
            JOptionPane.showMessageDialog(this,
                    "Archer selected! Take aim and strike fast.");
        } else if (jRB3.isSelected()) {
            GameState.character = "Mage";
            JOptionPane.showMessageDialog(this,
                    "Mage selected! One spell, one kill - if you survive.");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please choose a character first!");
            return;
        }
        GameState.hardMode = jCheckBox1.isSelected();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new MainMenu().setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new CharacterSelect().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDesc;
    private javax.swing.JRadioButton jRB1;
    private javax.swing.JRadioButton jRB2;
    private javax.swing.JRadioButton jRB3;
    private javax.swing.JPanel contentPanel;
    // End of variables declaration//GEN-END:variables
}
