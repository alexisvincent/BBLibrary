package networking;

import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author alexisvincent
 */
public abstract class Packet {
    
    Document xmlDocument;
    ASocket socket;
    Element rootElement;
    String from;

    public Packet(Document xmlDocument, ASocket socket) {
        this.xmlDocument = xmlDocument;
        this.socket = socket;
        this.rootElement = this.xmlDocument.getRootElement();
        this.setFrom(getRootElement().getAttributeValue("From"));
    }

    public Document getXmlDocument() {
        return xmlDocument;
    }

    public void setXmlDocument(Document xmlDocument) {
        this.xmlDocument = xmlDocument;
    }

    public ASocket getSocket() {
        return socket;
    }

    public void setSocket(ASocket socket) {
        this.socket = socket;
    }

    public Element getRootElement() {
        return rootElement;
    }

    public void setRootElement(Element rootElement) {
        this.rootElement = rootElement;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    
}
