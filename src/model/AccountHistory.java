package model;

public class AccountHistory {
    private Account account;
    private String previousNumber;
    private double previousBalance;

    public AccountHistory(Account account, String previousNumber) {
        this.account = account;
        this.previousNumber = previousNumber;
    }
    public AccountHistory(Account account, double previousBalance) {
        this.account = account;
        this.previousBalance = previousBalance;
    }

    public Account getAccount() {
        return account;
    }

    public String getPreviousNumber() {
        return previousNumber;
    }
    public double getPreviousBalance() {
        return previousBalance;
    }
}
