package service;

import model.Account;
import utility.AccountNumberComparator;

import java.util.ArrayList;
import java.util.List;

public class Calculation {

    /**
     *  Surikiuoja sąskaitas pagal balansą
     */
    public List<Account> sortAccountsByBalance(List<Account> accounts) {
        List<Account> sortedAccounts = new ArrayList<>(accounts);
        sortedAccounts.sort(Account::compareTo);
        return sortedAccounts;
    }

    /**
     *  Surikiuoja sąskaitas pagal numerį
     */
    public List<Account> sortAccountsByNumber(List<Account> accounts) {
        List<Account> sortedAccounts = new ArrayList<>(accounts);
        sortedAccounts.sort(new AccountNumberComparator());
        return sortedAccounts;
    }

    /**
     *  Apskaičiuoja bendrą visų sąskaitų balansą
     */
    public double calculateTotalbalance(List<Account> accounts) {
        double totalbalance = 0;
        for (Account account : accounts) {
            totalbalance += account.getBalance();
        }
        return totalbalance;
    }
}
