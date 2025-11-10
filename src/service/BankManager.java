package service;

import model.Account;
import model.Bank;

public class BankManager {
    private Bank currentBank;

    public BankManager(Bank bank) {
        if  (bank == null) {
           throw new IllegalArgumentException("Bankas privalo būti nurodytas.");
        }
        this.currentBank = bank;
    }

    /**
     *  Grąžina banko objektą (nekeičiamą)
     */
    public Bank getCurrentBank() {
        return currentBank;
    }

    /**
     *  Prideda naują sąskaitą
     */
    public void addAccount(Account account) {}
}
