package service;

import model.Account;
import model.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankManager {
    private Bank currentBank;
    private List<Account> accounts;
    private HashMap<String, Account> accountsByNumber;

    public BankManager(Bank bank) {
        if  (bank == null) {
           throw new IllegalArgumentException("Bankas privalo būti nurodytas.");
        }
        this.currentBank = bank;
        this.accounts = new ArrayList<>(bank.accounts());
        this.accountsByNumber = new HashMap<>();

        for (Account account : bank.accounts()) {
            accountsByNumber.put(account.getNumber(), account);
        }
    }

    /**
     * Grąžina banko objektą
     */
    public Bank getCurrentBank() {
        return currentBank;
    }

    /**
     * Grąžina dabartinį sąskaitų sąrašą
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Pašalina sąskaitą pagal jos numerį.
    */
    public boolean removeAccountByNumber(String accountNumber) {

        Account accountToRemove = accountsByNumber.get(accountNumber);

        if (accountToRemove == null) {
            return false;
        }
        accounts.remove(accountToRemove);
        accountsByNumber.remove(accountNumber);
        return true;
    }

    /**
     *  Pakeičia sąskaitos balansą
     */
    public Account updateAccountBalance(String accountNumber, double newBalance) {
        Account accountToChange = accountsByNumber.get(accountNumber);
        if (accountToChange != null) {
            accountToChange.setBalance(newBalance);
        }
        return accountToChange;
    }

    /**
     *  Atstato sąskaitų sąrašą
     */
    public void discardChanges() {
        accounts = new ArrayList<>(currentBank.accounts());
        for (Account account : currentBank.accounts()) {
            accountsByNumber.put(account.getNumber(), account);
        }
    }
}
