package settingsEngine;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import networking.ElectionProfile;
import networking.Server;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author alexisvincent
 */
public class ProfileEngine {

    private ArrayList<ElectionProfile> electionProfiles;

    public ProfileEngine() {

        electionProfiles = new ArrayList<>();

        updateProfileList();

        if (electionProfiles.isEmpty()) {
            String electionName = "DummyElection";
            Server server = new Server("DummyServer", "localhost", 12345);
            File electionFile = new File(electionName+"/blueballot.conf");
            ElectionProfile dummyProfile = new ElectionProfile(electionName, server, electionFile);
            dummyProfile.updateFile();
            updateProfileList();
        }
    }
    
    public ElectionProfile getFirstProfile() {
        return electionProfiles.get(0);
    }

    public ArrayList<ElectionProfile> getElectionProfiles() {
        return electionProfiles;
    }

    public void setElectionProfiles(ArrayList<ElectionProfile> electionProfiles) {
        this.electionProfiles = electionProfiles;
    }

    public void updateProfileList() {
        File currentDirectory = new File(".");

        FileFilter directoryFilter = new FileFilter() {
            public boolean accept(File f) {
                return f.isDirectory();
            }
        };

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File f) {
                return f.isFile();
            }
        };

        for (File file : currentDirectory.listFiles(directoryFilter)) {
            for (File subFile : file.listFiles(fileFilter)) {
                if (subFile.getName().equals("blueballot.conf")) {
                    try {
                        Element profileElement = new SAXBuilder().build(subFile).getRootElement();
                        ElectionProfile profile = new ElectionProfile(profileElement, subFile);
                        electionProfiles.add(profile);
                    } catch (JDOMException | IOException ex) {
                        System.out.println("Bad profile file found");
                    }
                }
            }
        }
    }
}
