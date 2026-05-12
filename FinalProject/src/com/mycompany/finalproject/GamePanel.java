package com.mycompany.finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLAYER_SIZE = 36;
    private static final int BULLET_W = 6;
    private static final int BULLET_H = 12;
    private static final int ENEMY_SIZE = 32;

    private final Timer timer;
    private final Random random = new Random();

    private int playerX = WIDTH / 2 - PLAYER_SIZE / 2;
    private int playerY = HEIGHT - 80;
    private int playerSpeed = 6;
    private int maxHealth;
    private int health;
    private int attack;

    private final ArrayList<int[]> bullets = new ArrayList<>();
    private final ArrayList<Enemy> enemies = new ArrayList<>();

    private boolean leftPressed, rightPressed, upPressed, downPressed;
    private boolean gameOver = false;
    private boolean paused = false;
    private int spawnTick = 0;
    private int spawnInterval;
    private int score = 0;
    private long shootCooldown = 0;
    private int shootDelay;
    private int bulletDamage;
    private int bulletSpeed;

    public GamePanel() {
        setBackground(new Color(15, 15, 30));
        setFocusable(true);
        setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));

        applyCharacterStats();
        applyWeaponStats();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKey(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                handleKey(e.getKeyCode(), false);
            }
        });

        timer = new Timer(16, this);
        timer.start();
    }

    private void applyCharacterStats() {
        switch (GameState.character) {
            case "Warrior":
                maxHealth = 150;
                attack = 20;
                playerSpeed = 5;
                break;
            case "Archer":
                maxHealth = 100;
                attack = 30;
                playerSpeed = 7;
                break;
            case "Mage":
                maxHealth = 80;
                attack = 40;
                playerSpeed = 6;
                break;
            default:
                maxHealth = 100;
                attack = 20;
                playerSpeed = 6;
        }
        health = maxHealth;
        spawnInterval = GameState.hardMode ? 35 : 60;
    }

    private void applyWeaponStats() {
        switch (GameState.weapon) {
            case "Pistol":
                shootDelay = 220;
                bulletDamage = 10;
                bulletSpeed = 12;
                break;
            case "Shotgun":
                shootDelay = 500;
                bulletDamage = 25;
                bulletSpeed = 11;
                break;
            case "Rifle":
                shootDelay = 280;
                bulletDamage = 15;
                bulletSpeed = 14;
                break;
            case "SMG":
                shootDelay = 110;
                bulletDamage = 8;
                bulletSpeed = 13;
                break;
            case "Sniper":
                shootDelay = 800;
                bulletDamage = 50;
                bulletSpeed = 20;
                break;
            case "Rocket Launcher":
                shootDelay = 1000;
                bulletDamage = 80;
                bulletSpeed = 9;
                break;
            default:
                shootDelay = 250;
                bulletDamage = 10;
                bulletSpeed = 12;
        }
    }

    private void handleKey(int code, boolean pressed) {
        switch (code) {
            case KeyEvent.VK_LEFT:
                leftPressed = pressed;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = pressed;
                break;
            case KeyEvent.VK_UP:
                upPressed = pressed;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = pressed;
                break;
            case KeyEvent.VK_SPACE:
                if (pressed && !gameOver && !paused) shoot();
                break;
            case KeyEvent.VK_P:
                if (pressed) paused = !paused;
                break;
            case KeyEvent.VK_ESCAPE:
                if (pressed) returnToMenu();
                break;
            case KeyEvent.VK_R:
                if (pressed && gameOver) restart();
                break;
        }
    }

    private void shoot() {
        long now = System.currentTimeMillis();
        if (now - shootCooldown < shootDelay) return;
        shootCooldown = now;

        int cx = playerX + PLAYER_SIZE / 2 - BULLET_W / 2;
        int cy = playerY;

        if ("Shotgun".equals(GameState.weapon)) {
            bullets.add(new int[]{cx, cy, 0, -bulletSpeed, bulletDamage});
            bullets.add(new int[]{cx, cy, -2, -bulletSpeed, bulletDamage});
            bullets.add(new int[]{cx, cy, 2, -bulletSpeed, bulletDamage});
        } else if ("SMG".equals(GameState.weapon)) {
            int spread = random.nextInt(3) - 1;
            bullets.add(new int[]{cx, cy, spread, -bulletSpeed, bulletDamage});
        } else {
            bullets.add(new int[]{cx, cy, 0, -bulletSpeed, bulletDamage});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver && !paused) updateGame();
        repaint();
    }

    private void updateGame() {
        if (leftPressed) playerX -= playerSpeed;
        if (rightPressed) playerX += playerSpeed;
        if (upPressed) playerY -= playerSpeed;
        if (downPressed) playerY += playerSpeed;
        if (playerX < 0) playerX = 0;
        if (playerX > WIDTH - PLAYER_SIZE) playerX = WIDTH - PLAYER_SIZE;
        if (playerY < HEIGHT / 2) playerY = HEIGHT / 2;
        if (playerY > HEIGHT - PLAYER_SIZE - 10) playerY = HEIGHT - PLAYER_SIZE - 10;

        Iterator<int[]> bIt = bullets.iterator();
        while (bIt.hasNext()) {
            int[] b = bIt.next();
            b[0] += b[2];
            b[1] += b[3];
            if (b[1] < -BULLET_H || b[0] < -BULLET_W || b[0] > WIDTH) bIt.remove();
        }

        spawnTick++;
        if (spawnTick >= spawnInterval) {
            spawnEnemy();
            spawnTick = 0;
        }

        Iterator<Enemy> eIt = enemies.iterator();
        while (eIt.hasNext()) {
            Enemy en = eIt.next();
            en.y += en.speed;
            if (en.y > HEIGHT) {
                eIt.remove();
                continue;
            }
            if (collides(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE,
                    en.x, en.y, ENEMY_SIZE, ENEMY_SIZE)) {
                health -= en.damage;
                eIt.remove();
                if (health <= 0) {
                    health = 0;
                    gameOver = true;
                    if (score > GameState.highScore) GameState.highScore = score;
                }
            }
        }

        for (Iterator<int[]> bi = bullets.iterator(); bi.hasNext();) {
            int[] b = bi.next();
            boolean hit = false;
            for (Iterator<Enemy> ei = enemies.iterator(); ei.hasNext();) {
                Enemy en = ei.next();
                if (collides(b[0], b[1], BULLET_W, BULLET_H,
                        en.x, en.y, ENEMY_SIZE, ENEMY_SIZE)) {
                    en.hp -= b[4] + attack / 2;
                    hit = true;
                    if (en.hp <= 0) {
                        score += en.points * (GameState.hardMode ? 2 : 1);
                        ei.remove();
                    }
                    break;
                }
            }
            if (hit && !"Rocket Launcher".equals(GameState.weapon)) bi.remove();
        }
    }

    private void spawnEnemy() {
        int roll = random.nextInt(100);
        int x = random.nextInt(WIDTH - ENEMY_SIZE);
        Enemy e;
        if (roll < 65) {
            e = new Enemy(x, -ENEMY_SIZE, GameState.hardMode ? 3 : 2,
                    20, 10, 5, new Color(200, 60, 60), "Goblin");
        } else if (roll < 92) {
            e = new Enemy(x, -ENEMY_SIZE, GameState.hardMode ? 4 : 3,
                    45, 25, 12, new Color(60, 180, 90), "Orc");
        } else {
            e = new Enemy(x, -ENEMY_SIZE, GameState.hardMode ? 3 : 2,
                    100, 50, 25, new Color(160, 80, 200), "Wizard");
        }
        enemies.add(e);
    }

    private boolean collides(int x1, int y1, int w1, int h1,
                             int x2, int y2, int w2, int h2) {
        return x1 < x2 + w2 && x1 + w1 > x2 && y1 < y2 + h2 && y1 + h1 > y2;
    }

    private void restart() {
        bullets.clear();
        enemies.clear();
        playerX = WIDTH / 2 - PLAYER_SIZE / 2;
        playerY = HEIGHT - 80;
        health = maxHealth;
        score = 0;
        spawnTick = 0;
        gameOver = false;
        paused = false;
    }

    private void returnToMenu() {
        timer.stop();
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (parent != null) parent.dispose();
        new MainMenu().setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        drawBackground(g2);

        for (Enemy en : enemies) en.draw(g2);

        g2.setColor(Color.YELLOW);
        for (int[] b : bullets) {
            g2.fillRect(b[0], b[1], BULLET_W, BULLET_H);
        }

        drawPlayer(g2);
        drawHUD(g2);

        if (paused) drawCenteredText(g2, "PAUSED", "Press P to resume");
        if (gameOver) drawCenteredText(g2,
                "GAME OVER", "Score: " + score + "   |   Press R to restart, ESC for menu");
    }

    private void drawBackground(Graphics2D g2) {
        g2.setColor(new Color(255, 255, 255, 60));
        for (int i = 0; i < 40; i++) {
            int sx = (i * 73 + spawnTick) % WIDTH;
            int sy = (i * 41 + spawnTick * 2) % HEIGHT;
            g2.fillOval(sx, sy, 2, 2);
        }
    }

    private void drawPlayer(Graphics2D g2) {
        Color body;
        switch (GameState.character) {
            case "Warrior": body = new Color(180, 120, 60); break;
            case "Archer":  body = new Color(60, 180, 120); break;
            case "Mage":    body = new Color(140, 80, 200); break;
            default:        body = Color.CYAN;
        }
        g2.setColor(body);
        g2.fillRoundRect(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE, 10, 10);
        g2.setColor(Color.WHITE);
        g2.drawRoundRect(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE, 10, 10);
        g2.setColor(Color.BLACK);
        g2.fillOval(playerX + 8, playerY + 10, 6, 6);
        g2.fillOval(playerX + 22, playerY + 10, 6, 6);
    }

    private void drawHUD(Graphics2D g2) {
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, WIDTH, 40);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Consolas", Font.BOLD, 16));
        g2.drawString("Score: " + score, 15, 25);
        g2.drawString("High: " + Math.max(score, GameState.highScore), 130, 25);
        g2.drawString(GameState.character + "  /  " + GameState.weapon
                + (GameState.hardMode ? "  [HARD]" : ""), 280, 25);

        int barX = 600, barY = 12, barW = 180, barH = 18;
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(barX, barY, barW, barH);
        int hpW = (int) ((double) health / maxHealth * barW);
        g2.setColor(health > maxHealth * 0.5 ? Color.GREEN
                : health > maxHealth * 0.25 ? Color.ORANGE : Color.RED);
        g2.fillRect(barX, barY, hpW, barH);
        g2.setColor(Color.WHITE);
        g2.drawRect(barX, barY, barW, barH);
        g2.setFont(new Font("Consolas", Font.BOLD, 12));
        g2.drawString("HP " + health + " / " + maxHealth, barX + 50, barY + 14);
    }

    private void drawCenteredText(Graphics2D g2, String big, String small) {
        g2.setColor(new Color(0, 0, 0, 180));
        g2.fillRect(0, HEIGHT / 2 - 70, WIDTH, 140);
        g2.setColor(Color.RED);
        g2.setFont(new Font("Tahoma", Font.BOLD, 50));
        int bw = g2.getFontMetrics().stringWidth(big);
        g2.drawString(big, (WIDTH - bw) / 2, HEIGHT / 2);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        int sw = g2.getFontMetrics().stringWidth(small);
        g2.drawString(small, (WIDTH - sw) / 2, HEIGHT / 2 + 40);
    }
}
