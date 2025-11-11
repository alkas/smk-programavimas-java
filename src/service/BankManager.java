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
     *  Randa sąskaitą pagal jos numerį
     */
    public Account getAccount(String number) {
        return accountsByNumber.get(number);
    }

    /**
     * Pašalina sąskaitą pagal jos numerį.
    */
    public boolean removeAccountByNumber(String accountNumber) {

        Account accountToRemove = getAccount(accountNumber);

        if (accountToRemove == null) {
            return false;
        }
        accounts.remove(accountToRemove);
        accountsByNumber.remove(accountNumber);
        return true;
    }

    /**
     *  Pakeičia sąskaitos numerį
     */
    public Account updateAccountNumber(String number, String newNumber) {
        Account accountToChange = getAccount(number);
        if (accountToChange != null) {
            accountToChange.setNumber(newNumber);
        }
        return accountToChange;
    }

    /**
     *  Pakeičia sąskaitos balansą
     */
    public Account updateAccountBalance(String accountNumber, double newBalance) {
        Account accountToChange = getAccount(accountNumber);
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

    /**
     *  Nurašo sumą nuo visų sąskaitų iš karto,
     *  jei nors vienoje sąskaitoje trūks lėšų, operacija nebus atlikta.
     */
    public boolean withdrawFromAllAccounts(double sum) {
        Calculation calculator = new Calculation();
        if (!calculator.allAccountsHaveSufficientFunds(accounts, sum)) {
            return false;
        }
        for (Account account : accounts) {
            double amount = calculator.calculateWithdrawalAmount(account, sum);
            account.withdraw(amount);
        }
        return true;
    }
}
