package settingsEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import networking.Server;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author alexisvincent
 */
public class SettingsEngine {

    Element preferences;

    public SettingsEngine() {
        File settingsFile = new File("Preferences");
        preferences = new Element("Preferences");
        preferences.setAttribute("ServerAddress", "localhost");
        preferences.setAttribute("ServerPort", "12345");
//        if (settingsFile.exists()) {
//            Scanner scnFile = null;
//            try {
//                scnFile = new Scanner(settingsFile);
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(SettingsEngine.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            String xml = "";
//            while (scnFile.hasNextLine()) {
//                xml += scnFile.nextLine();
//            }
//            preferences = new Document(new Element(xml)).getRootElement();
//        } else {
//            try {
//                settingsFile.createNewFile();
//                System.out.println("Creating file");
//                PrintStream ps = new PrintStream(settingsFile);
//                ps.print(new XMLOutputter().outputString(preferences));
//            } catch (IOException ex) {
//                Logger.getLogger(SettingsEngine.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

    }

    public Server getServer() {
        return new Server(preferences.getAttributeValue("ServerAddress"), "", Integer.parseInt(preferences.getAttributeValue("ServerPort")));
    }
}
