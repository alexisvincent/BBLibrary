package components;

import java.awt.Color;
import java.awt.color.ColorSpace;

/**
 *
 * @author alexisvincent
 */
public class AColor extends Color {
    
    public static Color fancyLightBlue, fancyDarkBlue, fancyGreen;
    
    static {
        fancyLightBlue = new Color(0,172,255,30);
        fancyDarkBlue = new Color(0,172,255,230);
        fancyGreen = new Color(20, 200, 112, 255);
    }

    public AColor(int r, int g, int b) {
        super(r, g, b);
    }

    public AColor(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public AColor(int rgb) {
        super(rgb);
    }

    public AColor(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public AColor(float r, float g, float b) {
        super(r, g, b);
    }

    public AColor(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    public AColor(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }
    
}
