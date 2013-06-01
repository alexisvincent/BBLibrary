package components;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author alexisvincent
 */
public class BTextPane extends JTextPane {

    private static final Color backdrop;
    private static final Color outline;
    private MutableAttributeSet set;

    static {
        backdrop = new Color(0, 172, 255, 30);
        outline = new Color(0, 172, 255, 230);
    }

    public BTextPane() {
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

        set = this.getInputAttributes();
        StyleConstants.setLineSpacing(set, 0.5f);
        StyleConstants.setFontFamily(set, this.getFont().getFamily());
        StyleConstants.setFontSize(set, this.getFont().getSize());
        StyleConstants.setForeground(set, Color.WHITE);
        this.setParagraphAttributes(set, true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setPaint(backdrop);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
        g2d.setPaint(outline);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 8, 8);

        super.paintComponent(g);
    }
}
