package settingsEngine;

import java.io.File;
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

        electionProfiles.clear();

        for (File file : currentDirectory.listFiles()) {
            if (file.getName().contains(".blueballot")) {
                try {
                    Element profileElement = new SAXBuilder().build(file).getRootElement();
                    ElectionProfile profile = new ElectionProfile(profileElement, file);
                    electionProfiles.add(profile);
                } catch (JDOMException | IOException ex) {
                    System.out.println("Bad profile file found");
                }
            }
        }

        if (electionProfiles.isEmpty()) {
            String electionName = "DummyElection";
            Server server = new Server("DummyServer", "localhost", 12345);
            File electionFile = new File(electionName + ".blueballot");
            ElectionProfile dummyProfile = new ElectionProfile(electionName, server, electionFile);
            dummyProfile.updateFile();
            updateProfileList();
        }
    }
}
