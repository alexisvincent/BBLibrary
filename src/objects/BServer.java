package objects;

/**
 *
 * @author alexisvincent
 */
public class BServer {
    private int serverID;
    private String address, discription;
    private int[] serverFunctions;

    public BServer() {
    }

    public BServer(int serverID, String address, String discription, int[] serverFunctions) {
        this.serverID = serverID;
        this.address = address;
        this.discription = discription;
        this.serverFunctions = serverFunctions;
    }

    public int getServerID() {
        return serverID;
    }

    public void setServerID(int serverID) {
        this.serverID = serverID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int[] getServerFunctions() {
        return serverFunctions;
    }

    public void setServerFunctions(int[] serverFunctions) {
        this.serverFunctions = serverFunctions;
    }

    @Override
    public String toString() {
        return "BServer{" + "serverID=" + serverID + ", address=" + address + ", discription=" + discription + ", serverFunctions=" + serverFunctions + '}';
    }
    
}
