package model;

public class Account {
    private  String pin;
    private String number;
    private double balance;

    public Account(String pin, String number, double balance) {
        this.pin = pin;
        this.number = number;
        this.balance = balance;
    }

    // Getters
    public String getPin() { return pin; }
    public String getNumber() { return number; }
    public double getBalance() { return balance; }

    // Setters
    public void setPin(String pin) { this.pin = pin; }
    public void setNumber(String number) { this.number = number; }
}
