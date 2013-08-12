package networking;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author alexisvincent
 */
public class NetworkingClient {

    ASocket socket;
    Server server;

    public NetworkingClient(Server server) {
        setServer(server);
        getSocket();
    }

    public Responce postRequest(Request request) {
        return getSocket().postRequest(request);
    }

    public ASocket getSocket() {
        if (socket == null || socket.getSocket().isClosed()) {
            try {
                setSocket(new ASocket(new Socket(server.getServerAddress(), server.getServerPort())));
                System.out.println("Successfully connected to Server");
            } catch (IOException ex) {
                System.out.println("Could not connect to server");
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
