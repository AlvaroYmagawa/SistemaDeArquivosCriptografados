/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

/**
 *
 * @author ld_si
 */
public class RoundIcon implements Icon {

    Color color;

    public RoundIcon(Color c) {
        color = c;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillOval(
        x, y, getIconWidth(), getIconHeight());
    }

    public int getIconWidth() {
        return 10;
    }

    public int getIconHeight() {
        return 10;
    }

}
