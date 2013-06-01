
package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.JComponent;

/**
 *
 * @author alexisvincent
 */
public class BPanel extends JComponent {
    
    private static final GradientPaint paint;
    private static final Dimension frameDimensions;
    
    static {
        paint = new GradientPaint(new Point(400,400), Color.BLACK, new Point(0,0), new Color(70,70,70));
        frameDimensions = new Dimension(400,400);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setPaint(paint);
        g2d.fillRoundRect(0, 0, frameDimensions.width, frameDimensions.height, 15, 15);

    }
    
}
