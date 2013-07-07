package socketEngine;

import listeners.SocketListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexisvincent
 */
public class ASocket implements Runnable {

    private Socket socket;
    private ArrayList<SocketListener> socketListeners;
    private Thread socketThread;
    private boolean active;
    private BufferedReader in = null;
    private PrintStream out = null;

    public ASocket(Socket socket) {
        this.socket = socket;
        socketListeners = new ArrayList<>();
        socketThread = new Thread(this);
        
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ASocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void setActive(boolean active) {
        this.active = active;
        if (active) {
            socketThread.start();
        } else {
            try {
                fireSocketDisconnected(this);
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ASocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void write(String text) {
        out.println(text);
    }

    public void addSocketListener(SocketListener listener) {
        socketListeners.add(listener);
    }
    
    public void fireSocketResponded(ASocket socket, String responce) {
        for (SocketListener listener : socketListeners) {
            listener.socketResponded(socket, responce);
        }
    }
    
    public void fireSocketDisconnected(ASocket socket) {
        for (SocketListener listener : socketListeners) {
            listener.socketDisconnected(socket);
        }
    }
    
    @Override
    public void run() {
        while (this.active && in != null) {
            try {
                String responce = in.readLine();
                if (responce == null) {
                    setActive(false);
                } else {
                    fireSocketResponded(this, responce);
                }

            } catch (IOException ex) {
                Logger.getLogger(ASocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
