package objects;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import toolkit.BToolkit;

/**
 *
 * @author alexisvincent
 */
public class Candidate {

    private String id;
    private String name;
    private String info;
    
    private String encodedImage;
    private int tally;
    private double percentage;

    public Candidate() {
        this("", "", "", "");
    }

    public Candidate(String id, String name, String info, BufferedImage image) {
        this(id, name, info, image, 0, 0);
    }
    
    public Candidate(String id, String name, String info, String image) {
        this(id, name, info, image, 0, 0);
    }

    public Candidate(String id, String name, String info, BufferedImage image, int tally, double percentage) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.tally = tally;
        this.percentage = percentage;
        
        setImage(image);
    }
    
    public Candidate(String id, String name, String info, String image, int tally, double percentage) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.encodedImage = image;
        this.tally = tally;
        this.percentage = percentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BufferedImage getImage() {
        
        try {
            return BToolkit.decodeImage(encodedImage);
        } catch (IOException ex) {
            Logger.getLogger(Candidate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    public void setImage(BufferedImage image) {
        this.encodedImage = BToolkit.encodeImage(image);
    }

    public int getTally() {
        return tally;
    }

    public void setTally(int tally) {
        this.tally = tally;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
