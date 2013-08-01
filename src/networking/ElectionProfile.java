package networking;


/**
 *
 * @author alexisvincent
 */
public class ElectionProfile {
    
    private static Server server;
    
    public ElectionProfile(Server server) {
        this.server = server;
    }
    
    public ElectionProfile() {
        //Set Defaults for testing
        server = new Server("Default", "blueballot.hopto.org", 12345);
    }

    public void setServer(Server servers) {
        this.server = server;
    }
    
    public Server getServer() {
        return server;
    }
}