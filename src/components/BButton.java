package components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import toolkit.UIToolkit;

/**
 * O.o ... A Wild Button Appeared
 *
 * @author alexisvincent
 */
public class BButton extends JComponent {

    private Color outline, backdrop, font;
    private static final Color outlineMouseOver, outlineNormal, backdropNormal, backdropMouseOver, fontNormal, fontMouseOver;
    private String name;

    static {
        backdropNormal = new Color(40, 40, 40, 100);
        backdropMouseOver = new Color(0, 172, 255, 100);
        
        outlineNormal = new Color(0, 172, 255, 200);
        outlineMouseOver = new Color(0, 172, 255, 255);
        
        fontNormal = new Color(0, 172, 255, 200);
        fontMouseOver = new Color(0, 0, 0, 200);
    }

    public BButton(String name) {
        
        outline = outlineNormal;
        backdrop = backdropNormal;
        font = fontNormal;
        
        this.name = name;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                outline = outlineMouseOver;
                backdrop = backdropMouseOver;
                font = fontMouseOver;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                outline = outlineNormal;
                backdrop = backdropNormal;
                font = fontNormal;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = UIToolkit.getPrettyGraphics(g);

        g2d.setPaint(backdrop);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

        g2d.setStroke(new BasicStroke(2f));
        g2d.setPaint(outline);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        
        g2d.setPaint(font);
        g2d.drawString(name, getWidth() / 2 - g2d.getFontMetrics().stringWidth(name) / 2, getHeight() / 2 + g2d.getFontMetrics().getAscent() / 2 - g2d.getFontMetrics().getDescent() / 2);
    }
}
