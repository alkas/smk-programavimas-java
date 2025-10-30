package model;

public class RegularAccount extends Account {
    private static final double FEE_RATE = 0.05;

    public RegularAccount(String number, String pin, double balance) {
        super(number, pin, balance);
    }

    @Override
    public double calculateFee(double sum) { return sum * FEE_RATE; }

    @Override
    public String getAccountType() {
        return "Regular";
    }
}
