package com.mycompany.finalproject;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class WeaponSelect extends javax.swing.JFrame {

    private final String[] weapons = {
        "Pistol", "Shotgun", "Rifle", "SMG", "Sniper", "Rocket Launcher"
    };

    public WeaponSelect() {
        initComponents();
        setLocationRelativeTo(null);
        jList1.setListData(weapons);
        jList1.setFixedCellHeight(35);
        jLabelInfo.setBorder(BorderFactory.createLineBorder(java.awt.Color.YELLOW, 2));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabelInfo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adventure Shooter - Weapon Select");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentPanel.setBackground(new java.awt.Color(40, 40, 60));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pick your weapon!");
        contentPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 500, 35));

        jList1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jList1.setSelectionBackground(new java.awt.Color(180, 0, 0));
        jList1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        contentPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 75, 220, 250));

        jLabelInfo.setBackground(new java.awt.Color(20, 20, 30));
        jLabelInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setText("<html><center>Click a weapon to view its details.</center></html>");
        jLabelInfo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelInfo.setOpaque(true);
        contentPanel.add(jLabelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 75, 240, 250));

        jButton1.setBackground(new java.awt.Color(0, 150, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        contentPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 150, 40));

        jButton2.setBackground(new java.awt.Color(150, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        contentPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 150, 40));

        getContentPane().add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 450));

        setSize(new java.awt.Dimension(616, 464));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {
        int idx = jList1.getSelectedIndex();
        switch (idx) {
            case 0:
                jLabelInfo.setText("<html><div style='padding:10px;'><b>PISTOL</b><br><br>"
                        + "Damage: 10<br>Speed: Fast<br>Range: Medium<br><br>"
                        + "Reliable starter weapon.</div></html>");
                break;
            case 1:
                jLabelInfo.setText("<html><div style='padding:10px;'><b>SHOTGUN</b><br><br>"
                        + "Damage: 25<br>Speed: Slow<br>Range: Short<br><br>"
                        + "Devastating up close.</div></html>");
                break;
            case 2:
                jLabelInfo.setText("<html><div style='padding:10px;'><b>RIFLE</b><br><br>"
                        + "Damage: 15<br>Speed: Medium<br>Range: Long<br><br>"
                        + "Balanced all-purpose weapon.</div></html>");
                break;
            case 3:
                jLabelInfo.setText("<html><div style='padding:10px;'><b>SMG</b><br><br>"
                        + "Damage: 8<br>Speed: Very Fast<br>Range: Short<br><br>"
                        + "Spray and pray!</div></html>");
                break;
            case 4:
                jLabelInfo.setText("<html><div style='padding:10px;'><b>SNIPER</b><br><br>"
                        + "Damage: 50<br>Speed: Very Slow<br>Range: Very Long<br><br>"
                        + "One shot, one kill.</div></html>");
                break;
            case 5:
                jLabelInfo.setText("<html><div style='padding:10px;'><b>ROCKET LAUNCHER</b><br><br>"
                        + "Damage: 80<br>Speed: Slow<br>Range: Long<br><br>"
                        + "Boom! Area damage.</div></html>");
                break;
            default:
                break;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int idx = jList1.getSelectedIndex();
        if (idx < 0 || idx >= weapons.length) {
            JOptionPane.showMessageDialog(this, "Please select a weapon first!");
            return;
        }
        GameState.weapon = String.valueOf(jList1.getSelectedValue());
        JOptionPane.showMessageDialog(this,
                GameState.weapon + " equipped! Ready for battle.");
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new MainMenu().setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new WeaponSelect().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
