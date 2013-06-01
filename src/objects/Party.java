/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author alexisvincent
 */
public class Party {
    
    private int partyID, candidateID;
    private String name, history, summery;

    public Party() {
    }

    public Party(int partyID, int candidateID, String name, String history, String summery) {
        this.partyID = partyID;
        this.candidateID = candidateID;
        this.name = name;
        this.history = history;
        this.summery = summery;
    }

    public int getPartyID() {
        return partyID;
    }

    public void setPartyID(int partyID) {
        this.partyID = partyID;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }

    @Override
    public String toString() {
        return "Party{" + "partyID=" + partyID + ", candidateID=" + candidateID + ", name=" + name + ", history=" + history + ", summery=" + summery + '}';
    }
    
    
}
