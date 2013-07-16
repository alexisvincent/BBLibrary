package networking;

import org.jdom2.Document;

/**
 *
 * @author alexisvincent
 */
public class Responce extends Packet {
    
    String responceCode;
    
    public Responce(Document xmlDocument, ASocket socket) {
        super(xmlDocument, socket);
        this.setResponceCode(getRootElement().getAttributeValue("ResponceCode"));
    }

    public String getResponceCode() {
        return responceCode;
    }

    public void setResponceCode(String responceCode) {
        this.responceCode = responceCode;
    }
    
}
