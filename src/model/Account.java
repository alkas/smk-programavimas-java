package model;

public abstract class Account {
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

    // Methods
    // -------------------------------
    public abstract String getAccountType();

    public abstract double calculateFee(double amount);

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean hasSuficientFunds(double amount) {
        return balance >= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "pin='" + pin + '\'' +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
