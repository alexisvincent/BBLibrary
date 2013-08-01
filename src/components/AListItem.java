/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

/**
 *
 * @author alexisvincent
 */
public class AListItem extends AComponent {

    private String displayName;
    private Paint backgroundPaint;
    private Paint displayNamePaint;
    
    private boolean focus;
    private boolean selected;

    public AListItem() {
        this("DefaultName");
    }

    public AListItem(String displayName) {
        setDisplayName(displayName);
        this.setPreferredSize(new Dimension(0, 30));
        displayNamePaint = new Color(53, 53, 123);
        backgroundPaint = new Color(53, 123, 123);
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2f));
        g2d.setPaint(backgroundPaint);
        g2d.fillRoundRect(0, 0, this.getWidth()-1, this.getHeight()-1, 15, 15);
        g2d.setPaint(displayNamePaint);
        g2d.drawRoundRect(0, 0, this.getWidth()-1, this.getHeight()-1, 15, 15);
        g2d.drawString(getDisplayName(), 15, 20);
    }

    
}
