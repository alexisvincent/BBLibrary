package networking;

import java.util.ArrayList;

/**
 *
 * @author alexisvincent
 */
public class ElectionProfile {
    
    private static ArrayList<Server> servers;
    
    static {
        servers = new ArrayList<>();
    }

    public ElectionProfile(ArrayList<Server> servers) {
        this.servers = servers;
    }

    public ElectionProfile() {
        //Set Defaults for testing
        servers.add(new Server("RegistrationServer", "blueballot.hopto.org", 12345));
    }

    public ArrayList<Server> getServers() {
        return servers;
    }

    public void setServers(ArrayList<Server> servers) {
        this.servers = servers;
    }
    
    public Server getServer(String serverName) {
        Server server = null;
        for (Server s : getServers()) {
            if (s.getServerName().equals(serverName)) {
                server = s;
            }
        }
        return server;
    }
}