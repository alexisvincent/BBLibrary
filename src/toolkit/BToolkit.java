/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

import java.awt.AlphaComposite;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author alexisvincent
 */
public class BToolkit {

    private static Image close, closeMouseOver, minimize, minimizeMouseOver;
    private static Image locked, lockedMouseOver, unlocked, unlockedMouseOver;
    private static Image logo, logoSmall, splash;

    static {
        //init images
        try {
            close = ImageIO.read(BToolkit.class.getResource("/resources/images/close.png"));
            closeMouseOver = ImageIO.read(BToolkit.class.getResource("/resources/images/closeMouseOver.png"));
            minimize = ImageIO.read(BToolkit.class.getResource("/resources/images/minimize.png"));
            minimizeMouseOver = ImageIO.read(BToolkit.class.getResource("/resources/images/minimizeMouseOver.png"));
            locked = ImageIO.read(BToolkit.class.getResource("/resources/images/locked.png"));
            lockedMouseOver = ImageIO.read(BToolkit.class.getResource("/resources/images/lockedMouseOver.png"));
            unlocked = ImageIO.read(BToolkit.class.getResource("/resources/images/unlocked.png"));
            unlockedMouseOver = ImageIO.read(BToolkit.class.getResource("/resources/images/unlockedMouseOver.png"));
            logo = ImageIO.read(BToolkit.class.getResource("/resources/images/logo.png"));
        } catch (IOException ex) {
            Logger.getLogger(BToolkit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Concatenates a String by parsing through a password character array.
     *
     * @param password <i>A password character array.</i>    
     * @return A concatenated String containing the password.    
     */
    public static String getPass(char charPassword[]) {
        //generate the password
        String stringPassword = "";
        for (char c : charPassword) {
            stringPassword += c;
        }
        return stringPassword;
    }

    public static Image getImage(String resource) {
        Image image = null;

        //It might be possible to reduce this... Check it out later
        switch (resource) {
            case "close":
                image = close;
                break;
            case "closeMouseOver":
                image = closeMouseOver;
                break;
            case "minimize":
                image = minimize;
                break;
            case "minimizeMouseOver":
                image = minimizeMouseOver;
                break;
            case "locked":
                image = locked;
                break;
            case "lockedMouseOver":
                image = lockedMouseOver;
                break;
            case "unlocked":
                image = unlocked;
                break;
            case "unlockedMouseOver":
                image = unlockedMouseOver;
                break;
            case "logo":
                image = logo;
                break;
            case "splash":
                image = logo;
                break;

        }
        return image;
    }
}
