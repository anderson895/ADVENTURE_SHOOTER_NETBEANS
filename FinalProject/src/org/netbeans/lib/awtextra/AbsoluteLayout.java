package org.netbeans.lib.awtextra;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AbsoluteLayout implements LayoutManager2, Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<Component, AbsoluteConstraints> components = new HashMap<>();

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        if (!(constraints instanceof AbsoluteConstraints)) {
            throw new IllegalArgumentException(
                    "Constraint must be an AbsoluteConstraints instance");
        }
        components.put(comp, (AbsoluteConstraints) constraints);
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        components.remove(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return computeSize(parent, false);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return computeSize(parent, true);
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0.5f;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0.5f;
    }

    @Override
    public void invalidateLayout(Container target) {
    }

    private Dimension computeSize(Container parent, boolean minimum) {
        int width = 0;
        int height = 0;
        synchronized (parent.getTreeLock()) {
            for (Component comp : parent.getComponents()) {
                AbsoluteConstraints c = components.get(comp);
                if (c == null) continue;
                Dimension d = minimum ? comp.getMinimumSize() : comp.getPreferredSize();
                int w = c.width >= 0 ? c.width : d.width;
                int h = c.height >= 0 ? c.height : d.height;
                width = Math.max(width, c.x + w);
                height = Math.max(height, c.y + h);
            }
            Insets insets = parent.getInsets();
            width += insets.left + insets.right;
            height += insets.top + insets.bottom;
        }
        return new Dimension(width, height);
    }

    @Override
    public void layoutContainer(Container parent) {
        synchronized (parent.getTreeLock()) {
            Insets insets = parent.getInsets();
            for (Component comp : parent.getComponents()) {
                AbsoluteConstraints c = components.get(comp);
                if (c == null) continue;
                Dimension pref = comp.getPreferredSize();
                int w = c.width >= 0 ? c.width : pref.width;
                int h = c.height >= 0 ? c.height : pref.height;
                comp.setBounds(insets.left + c.x, insets.top + c.y, w, h);
            }
        }
    }
}
