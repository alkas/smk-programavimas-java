package model;

public class ATM {
    private String idNumber;
    private String address;

    public ATM(String idNumber, String address) {
        this.idNumber = idNumber;
        this.address = address;
    }

    // Getters
    public String getIdNumber() { return idNumber; }
    public String getAddress() { return address; }

    // Setters
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
    public void setAddress(String address) { this.address = address; }
}
