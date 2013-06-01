package objects;

/**
 *
 * @author alexisvincent
 */
public class Voter {
    private int nrID;
    private int idNumber;
    private String surname, votersKey, encryptionKeyUN, encryptionKeyGOV;

    public Voter() {
    }

    public Voter(int nrID, int idNumber, String surname, String votersKey, String encryptionKeyUN, String encryptionKeyGOV) {
        this.nrID = nrID;
        this.idNumber = idNumber;
        this.surname = surname;
        this.votersKey = votersKey;
        this.encryptionKeyUN = encryptionKeyUN;
        this.encryptionKeyGOV = encryptionKeyGOV;
    }

    public int getNrID() {
        return nrID;
    }

    public void setNrID(int nrID) {
        this.nrID = nrID;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getVotersKey() {
        return votersKey;
    }

    public void setVotersKey(String votersKey) {
        this.votersKey = votersKey;
    }

    public String getEncryptionKeyUN() {
        return encryptionKeyUN;
    }

    public void setEncryptionKeyUN(String encryptionKeyUN) {
        this.encryptionKeyUN = encryptionKeyUN;
    }

    public String getEncryptionKeyGOV() {
        return encryptionKeyGOV;
    }

    public void setEncryptionKeyGOV(String encryptionKeyGOV) {
        this.encryptionKeyGOV = encryptionKeyGOV;
    }

    @Override
    public String toString() {
        return "Voter{" + "nrID=" + nrID + ", idNumber=" + idNumber + ", surname=" + surname + ", votersKey=" + votersKey + ", encryptionKeyUN=" + encryptionKeyUN + ", encryptionKeyGOV=" + encryptionKeyGOV + '}';
    }
    
}
