package networking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author alexisvincent
 */
public class ElectionProfile {

    private Server server;
    private String name;
    private File file;

    public ElectionProfile(String name, Server server, File file) {
        this.server = server;
        this.name = name;
        this.file = file;
    }

    public ElectionProfile(Element profileElement, File file) {
        this("", new Server("", "", 0), file);
        setProfileElement(profileElement);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void updateFile() {
        if (!getFile().exists()) {
            try {
                if (!getFile().getParentFile().exists()) {
                    getFile().getParentFile().mkdir();
                }
                getFile().createNewFile();
            } catch (IOException ex) {
                System.out.println("Could not create election profile");
            }
        }

        try {
            PrintStream ps = new PrintStream(getFile());
            ps.print(new XMLOutputter().outputString(new Document(getProfileElement())));
        } catch (FileNotFoundException ex) {
            System.out.println("Could not update profile");
        }
    }

    public void deleteFile() {
        System.out.println("Attempted Delete");
        if (getFile().exists()) {
            try {
                deleteFile(getFile().getParentFile());
            } catch (IOException ex) {
                Logger.getLogger(ElectionProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Element getProfileElement() {
        Element element = new Element("ElectionProfile");

        element.setAttribute("Name", getName());
        element.setAttribute("ServerName", getServer().getServerName());
        element.setAttribute("ServerAddress", getServer().getServerAddress());
        element.setAttribute("ServerPort", Integer.toString(getServer().getServerPort()));

        return element;
    }

    public void setProfileElement(Element profileFile) {

        try {
            setName(profileFile.getAttributeValue("Name"));
            getServer().setServerName(profileFile.getAttributeValue("ServerName"));
            getServer().setServerAddress(profileFile.getAttributeValue("ServerAddress"));
            getServer().setServerPort(Integer.parseInt(profileFile.getAttributeValue("ServerPort")));
        } catch (Exception e) {
            System.out.println("Invalid Profile Element");
        }
    }

    public static void deleteFile(File file)
            throws IOException {

        if (file.isDirectory()) {

            //directory is empty, then delete it
            if (file.list().length == 0) {

                file.delete();
                System.out.println("Directory is deleted : "
                        + file.getAbsolutePath());

            } else {

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    deleteFile(fileDelete);
                }

                //check the directory again, if empty then delete it
                if (file.list().length == 0) {
                    file.delete();
                    System.out.println("Directory is deleted : "
                            + file.getAbsolutePath());
                }
            }

        } else {
            //if file, then delete it
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }
}