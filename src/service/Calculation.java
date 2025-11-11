package service;

import model.Account;
import model.AccountType;
import utility.AccountNumberComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     *  Parenkamas objektas spausdinimui (gali būti Account arba AccountHistory)
     */
    public <T> List<T> selectObjectForPrint(T selectedObject, List<T> objectsForPrint) {
        if (!objectsForPrint.contains(selectedObject)) {
            objectsForPrint.add(selectedObject);
        }
        return objectsForPrint;
    }

    /**
     *  Suskaičiuoja bendrą balansą pagal sąskaitos tipą
     */
    public List<AccountType> calculateTotalBalanceByType (List<Account> accounts) {
        Map<String, List<Account>> accountsByType = groupAccountsByType(accounts);

        List<AccountType> accountTypes = new ArrayList<>();
        for (Map.Entry<String, List<Account>> entry : accountsByType.entrySet()) {
            String type = entry.getKey();
            List<Account> accountList = entry.getValue();
            double balance = 0.0;
            for (Account account : accountList) {
                balance += account.getBalance();
            }
            AccountType accountType = new AccountType(
                    type,
                    accountList.size(),
                    balance
            );
            accountTypes.add(accountType);
        }
        return accountTypes;
    }

    /**
     *  Sugrupuoja sąskaitas pagal tipą
     */
    private Map<String, List<Account>> groupAccountsByType (List<Account> accounts) {
        Map<String, List<Account>> accountsByType = new HashMap<>();
        for (Account account : accounts) {
            String type = account.getAccountType();
            if (!accountsByType.containsKey(type)) {
                accountsByType.put(type, new ArrayList<>());
            }
            accountsByType.get(type).add(account);
        }
        return accountsByType;
    }

    /**
     *  Apskaičiuoja bendrą visų sąskaitų balansą
     */
    public double calculateTotalBalance(List<Account> accounts) {
        double totalbalance = 0;
        for (Account account : accounts) {
            totalbalance += account.getBalance();
        }
        return totalbalance;
    }

    /**
     *  Patikrina ar visos sąskaitos turi reikalingą nurašymui sumą
     */
    public boolean allAccountsHaveSufficientFunds(List<Account> accounts, double sum) {
        for (Account account : accounts) {
            double amount = calculateWithdrawalAmount(account, sum);
            if (!account.hasSuficientFunds(amount)) {
                return false;
            }
        }
        return true;
    }

    /**
     *  Suskaičiuoja kokią sumą reikia nurašyti
     */
    public double calculateWithdrawalAmount(Account account, double sum) {
        return sum + account.calculateFee(sum);
    }


}
