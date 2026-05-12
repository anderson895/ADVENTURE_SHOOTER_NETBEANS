package org.netbeans.lib.awtextra;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;

public class AbsoluteConstraints implements Serializable {

    private static final long serialVersionUID = 1L;

    public int x;
    public int y;
    public int width = -1;
    public int height = -1;

    public AbsoluteConstraints(Point position) {
        this.x = position.x;
        this.y = position.y;
    }

    public AbsoluteConstraints(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public AbsoluteConstraints(Rectangle bounds) {
        this.x = bounds.x;
        this.y = bounds.y;
        this.width = bounds.width;
        this.height = bounds.height;
    }

    public AbsoluteConstraints(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
