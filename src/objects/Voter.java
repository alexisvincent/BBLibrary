package objects;

/**
 *
 * @author alexisvincent
 */
public class Voter {
    private String idNumber, firstName, middleNames, surname, votersID, encryptionKey;
    private Address address;

    public Voter() {
        this("", "", "", "", "", "", new Address("", "", "", "", ""));
    }

    public Voter(String idNumber, String firstName, String middleNames, String surname, String votersID, String encryptionKey, Address address) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.surname = surname;
        this.votersID = votersID;
        this.encryptionKey = encryptionKey;
        this.address = address;
    }

    public String getVotersID() {
        return votersID;
    }

    public void setVotersID(String votersID) {
        this.votersID = votersID;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

}
