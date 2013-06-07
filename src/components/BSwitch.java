package components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author alexisvincent
 */
public class BSwitch extends JComponent {

    private static final Color backdrop, outlineON, outlineOFF, fontON, fontOFF;
    private Color outlineAnimation, outline, font;;
    private static final String textON, textOFF;
    private String text;
    private boolean online, isAnimating;
    private int arc;
    private Thread animation;

    static {
        backdrop = new Color(0, 172, 255, 30);
        outlineON = new Color(125, 236, 121);
        outlineOFF = new Color(148, 102, 196);
        fontON = outlineON;
        fontOFF = outlineOFF;
        textON = "ONLINE";
        textOFF = "OFFLINE";
    }

    public BSwitch() {
        online = false;
        font = fontOFF;
        outline = outlineOFF;
        text = textOFF;
        reset(); //initiate arc and isAnimating

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Thread setOnline = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        setOnline(!online);
                    }
                });
                setOnline.start();
            }
        });

    }

    public void reset() {
        arc = 0;
        isAnimating = false;
    }

    public void setOnline(boolean online) {
        if (!isAnimating) {
            isAnimating = true;
            this.online = online;
            outlineAnimation = (online) ? outlineON : outlineOFF;
            font = (online) ? fontON : fontOFF;
            text = (online) ? textON : textOFF;
            Timer timer = new Timer(1, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (arc < 360) {
                        arc++;
                        repaint();
                        font = new Color(font.getRed(), font.getGreen(), font.getBlue(), arc*255/360);
                    } else {
                        outline = outlineAnimation;
                        reset();
                        repaint();
                        ((Timer) e.getSource()).stop();
                    }
                }
            });
            timer.start();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int cornerRadius = 24;
        
        g2d.setStroke(new BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));

        g2d.setPaint(backdrop);
        g2d.fillRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, cornerRadius, cornerRadius);

        g2d.setPaint(outline);
        g2d.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, cornerRadius, cornerRadius);
        
        g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
        g2d.setPaint(font);
        g2d.drawString(text, getWidth() / 2 - g2d.getFontMetrics().stringWidth(text) / 2, getHeight() / 2 + g2d.getFontMetrics().getAscent() / 2 - g2d.getFontMetrics().getDescent() / 2);
        
        g2d.clip(new Arc2D.Double(-this.getWidth() / 2, -this.getHeight() / 2, this.getWidth() * 2, this.getHeight() * 2, 140, -arc, Arc2D.PIE));

        g2d.setStroke(new BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
        g2d.setPaint(outlineAnimation);
        g2d.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, cornerRadius, cornerRadius);

    }
}
