
package objects;

import java.util.Date;

/**
 *
 * @author alexisvincent
 */
public class Citizen {
    
    private int registryID, idNumber;
    private String names, surname, title, addressLine1, addressLine2, Suburb, city, province;
    private char gender;
    private Date dateOfBirth;

    public Citizen() {
    }

    public Citizen(int registryID, int idNumber, String names, String surname, String title, String addressLine1, String addressLine2, String Suburb, String city, String province, char gender, Date dateOfBirth) {
        this.registryID = registryID;
        this.idNumber = idNumber;
        this.names = names;
        this.surname = surname;
        this.title = title;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.Suburb = Suburb;
        this.city = city;
        this.province = province;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public int getRegistryID() {
        return registryID;
    }

    public void setRegistryID(int registryID) {
        this.registryID = registryID;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getSuburb() {
        return Suburb;
    }

    public void setSuburb(String Suburb) {
        this.Suburb = Suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Citizen{" + "registryID=" + registryID + ", idNumber=" + idNumber + ", names=" + names + ", surname=" + surname + ", title=" + title + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", Suburb=" + Suburb + ", city=" + city + ", province=" + province + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + '}';
    }
    
    
    
}
