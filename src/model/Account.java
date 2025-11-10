package model;

public abstract class Account {
    private  String pin;
    private String number;
    private double balance;
    private ATM atm;
    private String accountType;

    public Account(String number, String pin, double balance, ATM atm, String accountType) {
        this.pin = pin;
        this.number = number;
        this.balance = balance;
        this.atm = atm;
        this.accountType = accountType;
    }

    // Getters
    public String getPin() { return pin; }
    public String getNumber() { return number; }
    public double getBalance() { return balance; }
    public ATM getATM() { return atm; }
    public String getAccountType() { return accountType; }

    // Setters
    public void setPin(String pin) { this.pin = pin; }
    public void setNumber(String number) { this.number = number; }

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

    public String getFormattedBalance() {
        return String.format("%.2f €", balance).replace(".", ",");
    }

    public int compareTo(Account other) {
        return Double.compare(balance, other.balance);
    }

    public String toString() {
        return "Account{" +
                "pin='" + pin + '\'' +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
