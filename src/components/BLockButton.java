/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import toolkit.BToolkit;

/**
 *
 * @author alexisvincent
 */
public class BLockButton extends JComponent {

    //variable declatations
    private Image imgLocked, imgLockedMouseOver, imgUnlocked, imgUnlockedMouseOver, display;
    private boolean isLocked;

    public BLockButton() {

        //init Images
        imgLocked = BToolkit.getImage("locked");
        imgUnlocked = BToolkit.getImage("unlocked");
        imgLockedMouseOver = BToolkit.getImage("lockedMouseOver");
        imgUnlockedMouseOver = BToolkit.getImage("unlockedMouseOver");
        display = imgUnlocked;

        //set BLockButton Preferences
        this.setMinimumSize(new Dimension(25, 25));
        this.setPreferredSize(new Dimension(25, 25));
        isLocked = false;

        //toggles mouseOver & normal images on mouse entry/exit
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setMouseOver(true);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setMouseOver(false);
                repaint();
            }
        });
    }

    //toggles locked & unlocked states and images
    public void setLocked(boolean locked) {
        if (locked) {
            display = imgLockedMouseOver;
            isLocked = true;
        } else {
            display = imgUnlockedMouseOver;
            isLocked = false;
        }
        repaint();
    }

    public void setMouseOver(boolean mouseOver) {
        if (mouseOver && isLocked) {
            display = imgLockedMouseOver;
        } else if (mouseOver && !isLocked) {
            display = imgUnlockedMouseOver;
        } else if (!mouseOver && isLocked) {
            display = imgLocked;
        } else {
            display = imgUnlocked;
        }
    }

    public boolean isLocked() {
        return isLocked;
    }

    //paint component
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(display, 0, 2, display.getWidth(this), display.getHeight(this), this);

    }
}
