package utility;

import model.Account;

import java.util.Comparator;

public class AccountNumberComparator implements Comparator<Account> {
    public int compare(Account o1, Account o2) {
        return o1.getNumber().compareTo(o2.getNumber());
    }
}
