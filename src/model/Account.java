package model;

import utility.MoneyFormatter;

public abstract class Account {
    private  String pin;
    private String number;
    private double balance;
    private ATM atm;
    private String accountType;
    private double previousBalance;

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
    public void setNumber(String number) { this.number = number; }
    public void setBalance(double balance) {
        setPreviousBalance(this.balance);
        this.balance = balance;
    }
    public void setPreviousBalance(double previousBalance) {
        this.previousBalance = previousBalance;
    }

    public abstract double calculateFee(double amount);

    public void withdraw(double amount) {
        setPreviousBalance(balance);
        balance -= amount;
    }

    public boolean hasSuficientFunds(double amount) {
        return balance >= amount;
    }

    public String getFormattedBalance() {
        return MoneyFormatter.format(balance);
    }

    public String getFormattedPreviousBalance() {
        return MoneyFormatter.format(previousBalance);
    }

    public int compareTo(Account other) {
        return Double.compare(other.balance, balance);
    }

    public String toString() {
        return "Account{" +
                "pin='" + pin + '\'' +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
