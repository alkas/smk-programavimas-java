package factory;

import model.ATM;
import model.Account;
import model.PreferentialAccount;
import model.RegularAccount;

public class AccountFactory {

    /**
     *  Sukuria Account objektą
     */
    public Account createAccount(String accountNumber, String pin, double balance, ATM atm, String accountType) {
        if (accountType.equalsIgnoreCase("Regular")) {
            return new RegularAccount(accountNumber, pin, balance, atm);
        } else if (accountType.equalsIgnoreCase("Preferential")) {
            return new PreferentialAccount(accountNumber, pin, balance, atm);
        } else {
            throw new IllegalArgumentException("Nežinomas sąskaitos tipas: " + accountType);
        }
    }
}
