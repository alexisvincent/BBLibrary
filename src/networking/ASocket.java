package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.output.XMLOutputter;

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
    
    private SocketAdapter serverResponceListener;
    
    private Responce responce;

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
        out.flush();
    }

    public Responce postRequest(Request request) {
        
        setResponce(null);
        
        final PacketBuilder packetBuilder = new PacketBuilder();
        
        serverResponceListener = new SocketAdapter() { 

            @Override
            public void socketResponded(final ASocket socket, final String responceString) {
                Thread t1 = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        setResponce(packetBuilder.addResponcePiece(responceString, socket));
                    }
                });
                t1.start();
            }
        
        };
        
        this.addSocketListener(serverResponceListener);
        
        String requestString = new XMLOutputter().outputString(request.getXmlDocument().getRootElement());
        this.write(requestString.length()+" "+requestString);
        System.out.println("Request Posted: " + requestString);
        
        int counter = 0;
        while (this.responce==null) {
            try {
                counter++;
                Thread.sleep(50);
                if (counter>=20) {
                    //Timeout
                    this.removeSocketListener(serverResponceListener);
                    break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ASocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return this.responce;
    }
    
    public void postResponce(Responce responce) {
        String responceString = new XMLOutputter().outputString(responce.getXmlDocument().getRootElement());
        this.write(responceString.length()+" "+responceString);
        System.out.println("Responce Posted: " + responceString);
    }
    
    private void setResponce(Responce responce) {
        this.responce = responce;
        //method Purely for the responce listener
        if (responce!=null) {
            this.removeSocketListener(serverResponceListener);
        }
    }

    public String readLine() throws IOException {
        return in.readLine();
    }

    public void addSocketListener(SocketListener listener) {
        socketListeners.add(listener);
    }

    public void removeSocketListener(SocketListener listener) {
        socketListeners.remove(listener);
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
