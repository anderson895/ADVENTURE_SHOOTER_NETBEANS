package com.mycompany.finalproject;

import java.awt.Color;
import java.awt.Graphics2D;

class Enemy {
    int x, y, speed, hp, points, damage;
    Color color;
    String type;

    Enemy(int x, int y, int speed, int hp, int points, int damage,
          Color color, String type) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.hp = hp;
        this.points = points;
        this.damage = damage;
        this.color = color;
        this.type = type;
    }

    void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRoundRect(x, y, 32, 32, 8, 8);
        g2.setColor(Color.BLACK);
        g2.fillOval(x + 6, y + 8, 5, 5);
        g2.fillOval(x + 21, y + 8, 5, 5);
        g2.drawArc(x + 8, y + 18, 16, 8, 0, -180);
    }
}
