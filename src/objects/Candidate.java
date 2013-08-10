/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.Image;

/**
 *
 * @author alexisvincent
 */
public class Candidate {

    private String id;
    private String name;
    private String info;
    private Image image;
    private int tally;
    private double percentage;

    public Candidate() {
        this("", "", "", null);
    }

    public Candidate(String id, String name, String info, Image image) {
        this(id, name, info, image, 0, 0);
    }

    public Candidate(String id, String name, String info, Image image, int tally, double percentage) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.image = image;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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
