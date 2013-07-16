package networking;

import org.jdom2.Document;

/**
 *
 * @author alexisvincent
 */
public class Request extends Packet {

    String requestType;

    public Request(Document xmlDocument, ASocket socket) {
        super(xmlDocument, socket);
        this.setRequestType(getRootElement().getAttributeValue("RequestType"));
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
