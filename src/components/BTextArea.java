package components;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

/**
 *
 * @author alexisvincent
 */
public class BTextArea extends JTextArea{

    private static final Color backdrop;
    private static final Color outline;
    
    static{
        backdrop = new Color(0,172,255,30);
        outline = new Color(0,172,255,230);
    }

    public BTextArea() {
        this.setOpaque(false);
        this.setForeground(Color.WHITE);
        this.setCaretColor(Color.WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(10, 5, 3, 5));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(backdrop);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(),8,8);
        g2d.setPaint(outline);
        g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1,8,8);
        super.paintComponent(g);
    }
    
    
}