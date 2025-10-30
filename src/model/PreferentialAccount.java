package model;

public class PreferentialAccount extends Account {
    private static final double FEE_RATE = 0.01;

    public PreferentialAccount(String number, String pin, double balance, ATM atm) {
        super(number, pin, balance, atm);
    }

    @Override
    public double calculateFee(double sum) { return sum * FEE_RATE; }

    @Override
    public String getAccountType() {
        return "Regular";
    }
}
