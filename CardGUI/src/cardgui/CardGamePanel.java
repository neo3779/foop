package cardgui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex J Davison
 */
import javax.swing.*;
import java.awt.*;


public class CardGamePanel extends JPanel{
    private Displayable theItem;
    private int x, y;

    public void paint(Graphics g) {
        if (theItem != null)
            theItem.display(g, x, y);
    }

    public void setItem(Displayable item, int x, int y) {
        theItem = item;
        this.x = x;
        this.y = x;
    }
}

