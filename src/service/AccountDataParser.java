package service;

import factory.ATMFactory;
import factory.AccountFactory;
import model.ATM;
import model.Account;

public class AccountDataParser {
    private final ATMFactory atmFactory;
    private final AccountFactory accountFactory;

    public AccountDataParser() {
        this.atmFactory = new ATMFactory();
        this.accountFactory = new AccountFactory();
    }

    /**
     *  Sukuria Account objektą
     */
    public Account parseAccountLine(String line) {
        String[] parts = line.split(";");

        if (parts.length != 6) {
            throw new IllegalArgumentException(
                    "Klaida eilutės nuskaitymo metu. Turi būti 6 laukeliai, gauta " + parts.length);
        }
        String accountNumber = parts[0].trim();
        String pin = parts[1].trim();
        double balance = parseBalance(parts[2].trim());
        String atmId = parts[3].trim();
        String address = parts[4].trim();
        String accountType = parts[5].trim();

        ATM atm = atmFactory.createATM(atmId, address);
        return accountFactory.createAccount(accountNumber, pin, balance, atm, accountType);
    }

    /**
     *  Pakeičia balansą į double
     */
    private double parseBalance(String balanceString) {
        String amountString = balanceString
                .replace(" €", "")
                .replace(",", ".");
        return Double.parseDouble(amountString);
    }

}
