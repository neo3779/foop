/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgui;

/**
 *
 * @author Alex J Davison
 */

import java.awt.*;
import javax.swing.*;


public class DisplayableCard implements Displayable extends Card {

    private ImageIcon image;
    private int x;
    private int y;
    
    public void  DisplayableCard(ImageIcon imagePra) {
        image = imagePra;
    }

    public void moveTo(int xPra, int yPra) {
        x = xPra;
        y = yPra;
    }

    public boolean contains(int xPra, int yPra) {
        return (xPra > x && x < (x + getWidth()) &&
                yPra > y && y < (y + getHeight()));
    }

    public int getWidth() {
        return image.getIconWidth();
    }

    public int getHeight() {
        return image.getIconHeight();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return x;
    }

    public void display(Graphics g, Component c) {
        image.paintIcon(c, g, x, y);
    }

}
