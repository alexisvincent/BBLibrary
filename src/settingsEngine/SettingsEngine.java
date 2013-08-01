package settingsEngine;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import networking.Server;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author alexisvincent
 */
public class SettingsEngine {

    Element preferences;

    public SettingsEngine() {
        File settingsFile = new File("blueballot.conf");
        preferences = new Element("Preferences");
        preferences.setAttribute("ServerAddress", "localhost");
        preferences.setAttribute("ServerPort", "12345");
        try {
            if (settingsFile.exists()) {
                System.out.println("Using existing preferences");
                preferences = new SAXBuilder().build(settingsFile).getRootElement();
            } else {
                System.out.println("File does not exist");
                settingsFile.createNewFile();
                System.out.println("Creating new preferences file");
                PrintStream ps = new PrintStream(settingsFile);
                ps.print(new XMLOutputter().outputString(new Document(preferences)));
            }
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(SettingsEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        SettingsEngine settingsEngine = new SettingsEngine();
    }

    public Server getServer() {
        return new Server(preferences.getAttributeValue("ServerName"), 
                preferences.getAttributeValue("ServerAddress"), 
                Integer.parseInt(preferences.getAttributeValue("ServerPort")));
    }
}
