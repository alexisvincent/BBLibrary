package networking;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author alexisvincent
 */
public class NetworkingClient {

    ASocket socket;
    Server server;

    public NetworkingClient(Server server) {
        try {
            socket = new ASocket(new Socket(server.getServerAddress(), server.getServerPort()));
            socket.setActive(true);
            System.out.println("Successfully connected to Server");
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(NetworkingClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NetworkingClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Responce postRequest(Request request) {
        return getSocket().postRequest(request);
    }

    public ASocket getSocket() {
        return socket;
    }

    public void setSocket(ASocket socket) {
        this.socket = socket;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
    
}
