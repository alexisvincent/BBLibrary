package objects;

import java.util.Date;

/**
 *
 * @author alexisvincent
 */
public class Ballot {
    private String name, votersID, encryptionKeyUN,encryptionKeyGov,encryptedVoteUN,encryptedVoteGov;
    private Date timestamp;

    public Ballot() {
    }

    public Ballot(String name, String votersID, String encryptionKeyUN, String encryptionKeyGov, String encryptedVoteUN, String encryptedVoteGov, Date timestamp) {
        this.name = name;
        this.votersID = votersID;
        this.encryptionKeyUN = encryptionKeyUN;
        this.encryptionKeyGov = encryptionKeyGov;
        this.encryptedVoteUN = encryptedVoteUN;
        this.encryptedVoteGov = encryptedVoteGov;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVotersID() {
        return votersID;
    }

    public void setVotersID(String votersID) {
        this.votersID = votersID;
    }

    public String getEncryptionKeyUN() {
        return encryptionKeyUN;
    }

    public void setEncryptionKeyUN(String encryptionKeyUN) {
        this.encryptionKeyUN = encryptionKeyUN;
    }

    public String getEncryptionKeyGov() {
        return encryptionKeyGov;
    }

    public void setEncryptionKeyGov(String encryptionKeyGov) {
        this.encryptionKeyGov = encryptionKeyGov;
    }

    public String getEncryptedVoteUN() {
        return encryptedVoteUN;
    }

    public void setEncryptedVoteUN(String encryptedVoteUN) {
        this.encryptedVoteUN = encryptedVoteUN;
    }

    public String getEncryptedVoteGov() {
        return encryptedVoteGov;
    }

    public void setEncryptedVoteGov(String encryptedVoteGov) {
        this.encryptedVoteGov = encryptedVoteGov;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Ballot{" + "name=" + name + ", votersID=" + votersID + ", encryptionKeyUN=" + encryptionKeyUN + ", encryptionKeyGov=" + encryptionKeyGov + ", encryptedVoteUN=" + encryptedVoteUN + ", encryptedVoteGov=" + encryptedVoteGov + ", timestamp=" + timestamp + '}';
    }
    
}
