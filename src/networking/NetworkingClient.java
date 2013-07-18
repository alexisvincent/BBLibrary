package networking;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexisvincent
 */
public class NetworkingClient {

    ASocket socket;
    Server server;

    public NetworkingClient(Server server) {
        setServer(server);
        try {
            socket = new ASocket(new Socket(server.getServerAddress(), server.getServerPort()));
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
        if (socket == null) {
            try {
                setSocket(new ASocket(new Socket(server.getServerAddress(), server.getServerPort())));
            } catch (UnknownHostException ex) {
                Logger.getLogger(NetworkingClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NetworkingClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
