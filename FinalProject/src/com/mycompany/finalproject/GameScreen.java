package com.mycompany.finalproject;

public class GameScreen extends javax.swing.JFrame {

    public GameScreen() {
        initComponents();
        setTitle("Adventure Shooter - " + GameState.character + " (" + GameState.weapon + ")");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new com.mycompany.finalproject.GamePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adventure Shooter");
        setResizable(false);
        getContentPane().add(gamePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) gamePanel.requestFocusInWindow();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new GameScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.finalproject.GamePanel gamePanel;
    // End of variables declaration//GEN-END:variables
}
