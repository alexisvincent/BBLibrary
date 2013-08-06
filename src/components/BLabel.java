package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

/**
 * @about simple label
 * @author alexisvincent
 */
public class BLabel extends JComponent {
    
    public BLabel(String name) {
        setName(name);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        g2d.setPaint(Color.WHITE);
        g2d.drawString(getName(), 0, getHeight()/2+g2d.getFontMetrics().getAscent()/2-g2d.getFontMetrics().getDescent()/2);
    }

    
}
