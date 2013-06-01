package objects;

import java.util.Date;

/**
 *
 * @author alexisvincent
 */
public class ElectionProfile {
    private String name;
    private Date registrationOpen, registrationClose, electionOpen, electionClose;
    private BServer[] servers;

    public ElectionProfile() {
    }

    public ElectionProfile(String name, Date registrationOpen, Date registrationClose, Date electionOpen, Date electionClose, BServer[] servers) {
        this.name = name;
        this.registrationOpen = registrationOpen;
        this.registrationClose = registrationClose;
        this.electionOpen = electionOpen;
        this.electionClose = electionClose;
        this.servers = servers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationOpen() {
        return registrationOpen;
    }

    public void setRegistrationOpen(Date registrationOpen) {
        this.registrationOpen = registrationOpen;
    }

    public Date getRegistrationClose() {
        return registrationClose;
    }

    public void setRegistrationClose(Date registrationClose) {
        this.registrationClose = registrationClose;
    }

    public Date getElectionOpen() {
        return electionOpen;
    }

    public void setElectionOpen(Date electionOpen) {
        this.electionOpen = electionOpen;
    }

    public Date getElectionClose() {
        return electionClose;
    }

    public void setElectionClose(Date electionClose) {
        this.electionClose = electionClose;
    }

    public BServer[] getServers() {
        return servers;
    }

    public void setServers(BServer[] servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        return "ElectionProfile{" + "name=" + name + ", registrationOpen=" + registrationOpen + ", registrationClose=" + registrationClose + ", electionOpen=" + electionOpen + ", electionClose=" + electionClose + ", servers=" + servers + '}';
    }
    
}
