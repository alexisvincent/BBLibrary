/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import components.AListModel.FocusListener;
import components.AListModel.SelectionListener;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author alexisvincent
 */
public class AListItem extends AComponent {

    private String displayName;
    private Paint backgroundPaint;
    private Paint displayNamePaint;
    private Paint selectedPaint;
    private Paint focusPaint;
    private boolean focus;
    private boolean selected;
    private ArrayList<SelectionListener> selectionListeners;
    private ArrayList<FocusListener> focusListeners;

    public AListItem() {
        this("DefaultName");
    }

    public AListItem(String displayName) {
        setDisplayName(displayName);
        this.setPreferredSize(new Dimension(0, 30));

        displayNamePaint = new Color(53, 53, 123);
        backgroundPaint = new Color(53, 123, 123);
        selectedPaint = new Color(123, 234, 56);
        focusPaint = new Color(20, 234, 56);

        selectionListeners = new ArrayList<>();
        focusListeners = new ArrayList<>();
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                setSelected(true);
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setFocus(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setFocus(false);
            }
            
        });
        
    }

    public Paint getBackgroundPaint() {
        return backgroundPaint;
    }

    public void setBackgroundPaint(Paint backgroundPaint) {
        this.backgroundPaint = backgroundPaint;
    }

    public Paint getDisplayNamePaint() {
        return displayNamePaint;
    }

    public void setDisplayNamePaint(Paint displayNamePaint) {
        this.displayNamePaint = displayNamePaint;
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
        if (focus) {
            fireFocusListeners();
        }
        repaint();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            fireSelectionListeners();
        }
        repaint();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void addSelectionListener(SelectionListener listener) {
        selectionListeners.add(listener);
    }

    public void removeSelectionListener(SelectionListener listener) {
        selectionListeners.remove(listener);
    }

    public void fireSelectionListeners() {
        for (SelectionListener listener : selectionListeners) {
            listener.itemSelected(this);
        }
    }
    
    public void addFocusListener(FocusListener listener) {
        focusListeners.add(listener);
    }

    public void removeFocusListener(FocusListener listener) {
        focusListeners.remove(listener);
    }

    public void fireFocusListeners() {
        for (FocusListener listener : focusListeners) {
            listener.itemFocused(this);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2f));
        g2d.setPaint(backgroundPaint);
        if (isFocus()) {
            g2d.setPaint(focusPaint);
        } else if (isSelected()) {
            g2d.setPaint(selectedPaint);
        }
        g2d.fillRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, 15, 15);
        g2d.setPaint(displayNamePaint);
        g2d.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, 15, 15);
        g2d.drawString(getDisplayName(), 15, 20);
    }
}
