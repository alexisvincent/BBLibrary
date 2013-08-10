
package components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import toolkit.UIToolkit;

/**
 *
 * @author alexisvincent
 */
public class BPanel extends AComponent {
    
    private static final GradientPaint paint;
    
    static {
        paint = new GradientPaint(new Point(400,400), Color.BLACK, new Point(0,0), new Color(70,70,70));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = UIToolkit.getPrettyGraphics(g);
        g2d.setPaint(paint);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

    }
    
}
