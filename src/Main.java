import model.Account;
import model.Bank;
import service.BankDataLoader;
import service.BankManager;
import service.Calculation;
import service.Print;
import utility.ColumnConfigurations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankDataLoader loader = new BankDataLoader();
        Print printer = new Print("resources//rezultatai.txt");
        Calculation calculator = new Calculation();

        Bank originalBank = loader.loadBankData("resources//duomenys.txt");

        System.out.println("=== NUSKAITYTI DUOMENYS ===");
        System.out.println("Bankas: " + originalBank.name());

        printer.printAccountsTable(
                "Banko " + originalBank.name() + " sąskaitų sąrašas",
                originalBank.accounts(),
                ColumnConfigurations.getFullAccountColumns());

        double totalBalance = calculator.calculateTotalbalance(originalBank.accounts());
        printer.printAmount("Visų sąskaitų balansas: ", totalBalance);

        List<Account> sortedByBalance = calculator.sortAccountsByBalance(originalBank.accounts());
        printer.printAccountsTable(
                "Išrikiuotas banko " + originalBank.name() + " sąskaitų sąrašas pagal balansą",
                sortedByBalance,
                ColumnConfigurations.getFullAccountColumns());

        List<Account> sortedByNumber = calculator.sortAccountsByNumber(originalBank.accounts());
        printer.printAccountsTable(
                "Išrikiuotas banko " + originalBank.name() + " sąskaitų sąrašas pagal sąskaitos numerį",
                sortedByNumber,
                ColumnConfigurations.getFullAccountColumns());

        BankManager manager = new BankManager(originalBank);

        String accountToRemove = "LT347654";
        boolean removed = manager.removeAccountByNumber(accountToRemove);
        if (removed) {
            printer.printAccountsTable(
                    "Banko " + manager.getCurrentBank().name() + " sąskaitų sąrašas po sąskaitos pašalinimo",
                    manager.getAccounts(),
                    ColumnConfigurations.getFullAccountColumns());
        } else {
            printer.printMessage("Nepavyko pašalinti sąskaitos " + accountToRemove);
        }


        manager.discardChanges();
        String accountToChange = "LT347654";
        double newBalance = 5000d;
        Account changedAccount = manager.updateAccountBalance(accountToChange, newBalance);
        if (changedAccount != null) {
            List<Account> accountsToPrint = new ArrayList<>();
            accountsToPrint = calculator.selectAccountForPrint(changedAccount, accountsToPrint);
            printer.printAccountsTable(
                    "Banko " + manager.getCurrentBank().name() + " sąskaitų sąrašas po sąskaitos pašalinimo",
                    accountsToPrint,
                    ColumnConfigurations.getFullAccountColumns());
        }

        //String accountToUpdate = "LT347654";
    }


}

