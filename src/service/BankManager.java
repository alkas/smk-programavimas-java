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
        // Patikriname, ar tokia sąskaita egzistuoja
        Account accountToRemove = accountsByNumber.get(accountNumber);

        if (accountToRemove == null) {
            return false;
        }
        accounts.remove(accountToRemove);
        accountsByNumber.remove(accountNumber);
        return true;
    }

    /**
     *  Sukuria Hashmap sąskaitų kolekciją
     */
    private HashMap<String, Account> createHashMap(List<Account> accounts) {
        HashMap<String, Account> accountsByNumber = new HashMap<>();
        for (Account account : accounts) {
            accountsByNumber.put(account.getNumber(), account);
        }
        return accountsByNumber;
    }
}
