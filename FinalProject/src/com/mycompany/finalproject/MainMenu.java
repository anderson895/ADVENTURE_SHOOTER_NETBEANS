package com.mycompany.finalproject;

import java.awt.Cursor;
import javax.swing.JOptionPane;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
        setLocationRelativeTo(null);
        Cursor hand = new Cursor(Cursor.HAND_CURSOR);
        jBtnStart.setCursor(hand);
        jBtnCharacter.setCursor(hand);
        jBtnWeapon.setCursor(hand);
        jBtnInfo.setCursor(hand);
        jBtnExit.setCursor(hand);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelSubtitle = new javax.swing.JLabel();
        jBtnStart = new javax.swing.JButton();
        jBtnCharacter = new javax.swing.JButton();
        jBtnWeapon = new javax.swing.JButton();
        jBtnInfo = new javax.swing.JButton();
        jBtnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adventure Shooter - Main Menu");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentPanel.setBackground(new java.awt.Color(20, 20, 40));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("ADVENTURE SHOOTER");
        contentPanel.add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 500, 50));

        jLabelSubtitle.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabelSubtitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubtitle.setText("A Java Swing Final Project");
        contentPanel.add(jLabelSubtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 500, 25));

        jBtnStart.setBackground(new java.awt.Color(0, 150, 0));
        jBtnStart.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jBtnStart.setForeground(new java.awt.Color(255, 255, 255));
        jBtnStart.setText("START GAME");
        jBtnStart.setFocusPainted(false);
        jBtnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStartActionPerformed(evt);
            }
        });
        contentPanel.add(jBtnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 175, 300, 45));

        jBtnCharacter.setBackground(new java.awt.Color(0, 100, 200));
        jBtnCharacter.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jBtnCharacter.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCharacter.setText("CHARACTER SELECT");
        jBtnCharacter.setFocusPainted(false);
        jBtnCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCharacterActionPerformed(evt);
            }
        });
        contentPanel.add(jBtnCharacter, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 300, 45));

        jBtnWeapon.setBackground(new java.awt.Color(180, 100, 0));
        jBtnWeapon.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jBtnWeapon.setForeground(new java.awt.Color(255, 255, 255));
        jBtnWeapon.setText("WEAPON SELECT");
        jBtnWeapon.setFocusPainted(false);
        jBtnWeapon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnWeaponActionPerformed(evt);
            }
        });
        contentPanel.add(jBtnWeapon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 285, 300, 45));

        jBtnInfo.setBackground(new java.awt.Color(100, 50, 150));
        jBtnInfo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jBtnInfo.setForeground(new java.awt.Color(255, 255, 255));
        jBtnInfo.setText("GAME INFO");
        jBtnInfo.setFocusPainted(false);
        jBtnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInfoActionPerformed(evt);
            }
        });
        contentPanel.add(jBtnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 300, 45));

        jBtnExit.setBackground(new java.awt.Color(150, 0, 0));
        jBtnExit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jBtnExit.setForeground(new java.awt.Color(255, 255, 255));
        jBtnExit.setText("EXIT");
        jBtnExit.setFocusPainted(false);
        jBtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExitActionPerformed(evt);
            }
        });
        contentPanel.add(jBtnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 395, 300, 45));

        getContentPane().add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 500));

        setSize(new java.awt.Dimension(600, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnStartActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new GameScreen().setVisible(true);
    }

    private void jBtnCharacterActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new CharacterSelect().setVisible(true);
    }

    private void jBtnWeaponActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new WeaponSelect().setVisible(true);
    }

    private void jBtnInfoActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new GameInfo().setVisible(true);
    }

    private void jBtnExitActionPerformed(java.awt.event.ActionEvent evt) {
        int result = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit?",
                "Exit Game",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MainMenu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton jBtnCharacter;
    private javax.swing.JButton jBtnExit;
    private javax.swing.JButton jBtnInfo;
    private javax.swing.JButton jBtnStart;
    private javax.swing.JButton jBtnWeapon;
    private javax.swing.JLabel jLabelSubtitle;
    private javax.swing.JLabel jLabelTitle;
    // End of variables declaration//GEN-END:variables
}
