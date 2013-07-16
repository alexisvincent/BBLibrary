package networking;

import networking.ASocket;

/**
 *
 * @author alexisvincent
 */
public interface SocketListener {

    public void socketConnected(ASocket socket);
    
    public void socketDisconnected(ASocket socket);
    
    public void socketResponded(ASocket socket, String responce);
}
