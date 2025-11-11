package utility;

import model.Account;

import java.util.Comparator;

public class AccountNumberComparator implements Comparator<Account> {
    public int compare(Account a1, Account a2) {
        return a1.getNumber().compareTo(a2.getNumber());
    }
}
