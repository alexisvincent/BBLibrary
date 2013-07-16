package networking;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author alexisvincent
 */
public class PacketBuilder {

    private String requestPieces;
    private String responcePieces;
    private long lastReceivedAt;
    private int requestPieceDelay;

    public PacketBuilder() {
        this.requestPieces = "";
        this.responcePieces = "";
        this.lastReceivedAt = 0;
        this.requestPieceDelay = 1000;
    }

    public Request addRequestPiece(String requestPiece, ASocket socket) {
        
        Request request = null;

        if (System.currentTimeMillis() - lastReceivedAt > requestPieceDelay) {
            requestPieces = "";
        }
        lastReceivedAt = System.currentTimeMillis();

        if (!requestPieces.equals("")) {
            requestPieces += "\n";
        }
        requestPieces += requestPiece;

        String xmlRequest = null;
        try {
            xmlRequest = buildXMLPacketString(requestPieces);
            requestPieces = "";
            request = buildRequest(xmlRequest, socket);
        } catch (BadPacketException ex) {
            requestPieces = "";
        } catch (UncompletedPacketException ex) {
            System.out.println("Uncompleted Packet");
        }
        
        return request;
    }
    
    //JOIN THIS WITH THE OBOVE SO THAT WE HAVE CODE REUSE
    public Responce addResponcePiece(String responcePiece, ASocket socket) {
        
        Responce responce = null;

        if (System.currentTimeMillis() - lastReceivedAt > requestPieceDelay) {
            responcePieces = "";
        }
        lastReceivedAt = System.currentTimeMillis();

        if (!responcePieces.equals("")) {
            responcePieces += "\n";
        }
        responcePieces += responcePiece;

        String xmlRequest = null;
        
        try {
            xmlRequest = buildXMLPacketString(responcePieces);
            responcePieces = "";
            responce = buildResponce(xmlRequest, socket);
        } catch (BadPacketException ex) {
            responcePieces = "";
        } catch (UncompletedPacketException ex) {
        }

        return responce;
    }

    private static String buildXMLPacketString(String requestString) throws BadPacketException, UncompletedPacketException {

        Scanner scnRequest = new Scanner(requestString);
        String xmlRequest = null;
        if (scnRequest.hasNextInt()) {
            int contentLength = scnRequest.nextInt();

            if (requestString.length() >= ("" + (contentLength)).length() + 1) {
                requestString = requestString.substring(("" + contentLength).length() + 1);

                if (requestString.length() >= contentLength) {
                    xmlRequest = requestString.substring(0, contentLength);
                } else {
                    throw new UncompletedPacketException();
                }

            } else {
                System.out.println("Bad Packet Recieved");
                throw new BadPacketException();
            }

        } else {
            System.out.println("Bad Packet Recieved");
            throw new BadPacketException();
        }

        return xmlRequest;
    }

    public static Request buildRequest(String xmlString, ASocket socket) throws BadPacketException {
        ByteArrayInputStream requestStream = null;
        Request request = null;
        try {
            requestStream = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
            SAXBuilder documentBuilder = new SAXBuilder();
            Document document = documentBuilder.build(requestStream);
            request = new Request(document, socket);

        } catch (JDOMException | IOException ex) {
            throw new BadPacketException();
        } finally {
            try {
                requestStream.close();
            } catch (IOException ex) {
                System.out.println("Could not close stream");
            }
        }

        return request;
    }
    
    public static Responce buildResponce(String xmlString, ASocket socket) throws BadPacketException {
        ByteArrayInputStream requestStream = null;
        Responce responce = null;
        try {
            requestStream = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
            SAXBuilder documentBuilder = new SAXBuilder();
            Document document = documentBuilder.build(requestStream);
            responce = new Responce(document, socket);

        } catch (JDOMException | IOException ex) {
            throw new BadPacketException();
        } finally {
            try {
                requestStream.close();
            } catch (IOException ex) {
                System.out.println("Could not close stream");
            }
        }

        return responce;
    }
}