package networking;

import networking.ASocket;

/**
 *
 * @author alexisvincent
 */
public class SocketAdapter implements SocketListener {

    @Override
    public void socketConnected(ASocket socket) {}

    @Override
    public void socketDisconnected(ASocket socket) {}

    @Override
    public void socketResponded(ASocket socket, String responce) {}

}
