import model.Account;
import model.AccountHistory;
import model.AccountType;
import model.Bank;
import service.BankDataLoader;
import service.BankManager;
import service.Calculation;
import service.Print;
import utility.ColumnConfigurations;
import utility.MoneyFormatter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankDataLoader loader = new BankDataLoader();
        Print printer = new Print("resources//rezultatai.txt");
        Calculation calculator = new Calculation();

        // Duomenų nuskaitymas ir spausdinimas
        Bank originalBank = loader.loadBankData("resources//duomenys.txt");
        BankManager manager = new BankManager(originalBank);

        printer.printTable(
                "Banko " + originalBank.name() + " sąskaitų sąrašas",
                originalBank.accounts(),
                ColumnConfigurations.getAccountAllColumns()
        );


        // Bendro balanso skaičiavimas ir spausdinimas
        double totalBalance = calculator.calculateTotalBalance(originalBank.accounts());
        printer.printAmount("Visų sąskaitų balansas: ", totalBalance);

        // Nuo visų sąskaitų nuskaičiuota suma
        double sum = 200d;
        boolean changed = manager.withdrawFromAllAccounts(sum);
        if (changed) {
            printer.printTable(
                    "Banko " + manager.getCurrentBank().name()
                            + " sąskaitų sąrašas po " + MoneyFormatter.format(sum) + " nurašymo",
                    manager.getAccounts(),
                    ColumnConfigurations.getChangedBalanceAccountColumnsWithFee(sum)
            );
        } else {
            printer.printMessage("Ne visose sąskaitose yra pakankamai lėšų "
                    + MoneyFormatter.format(sum) + " nurašymui, todėl operacija nevykdoma.");
        }


        // Duomenų rikiavimas
        List<Account> sortedByBalance = calculator.sortAccountsByBalance(originalBank.accounts());
        printer.printTable(
                "Išrikiuotas banko " + originalBank.name() + " sąskaitų sąrašas pagal balansą",
                sortedByBalance,
                ColumnConfigurations.getAccountAllColumns()
        );

        List<Account> sortedByNumber = calculator.sortAccountsByNumber(originalBank.accounts());
        printer.printTable(
                "Išrikiuotas banko " + originalBank.name() + " sąskaitų sąrašas pagal sąskaitos numerį",
                sortedByNumber,
                ColumnConfigurations.getAccountAllColumns()
        );


        // Duomenų grupavimas pagal kriterijų (accountType)
        List<AccountType> accountTypes = calculator.calculateTotalBalanceByType(originalBank.accounts());
        printer.printTable(
                "Sąskaitų tipai",
                accountTypes,
                ColumnConfigurations.getAccountTypeSummaryColumns()
        );


        // Vieno kintamojo pakeitimas pasirinktoje sąskaitoje
        String accountToChange = "LT347654";
        double newBalance = 5000d;
        Account changedAccount = manager.updateAccountBalance(accountToChange, newBalance);
        if (changedAccount != null) {
            List<Account> accountsToPrint = new ArrayList<>();
            accountsToPrint = calculator.selectObjectForPrint(changedAccount, accountsToPrint);
            printer.printTable(
                    "Surasta sąskaita " + accountToChange + " ir pakeistas jos balansas",
                    accountsToPrint,
                    ColumnConfigurations.getChangedBalanceAccountColumns()
            );
        } else {
            printer.printMessage("Įvyko klaida keičiant sąskaitos " + accountToChange + " balansą.");
        }

        // sąskaitos numerio pakeitimas
        String oldNumber = "LT347654";
        String newNumber = "LT340000";
        Account updatedAccount = manager.updateAccountNumber(oldNumber, newNumber);
        AccountHistory accountHistory = new AccountHistory(updatedAccount, oldNumber);
        if (updatedAccount != null) {
            List<AccountHistory> objectsToPrint = new ArrayList<>();
            objectsToPrint = calculator.selectObjectForPrint(accountHistory, objectsToPrint);
            printer.printTable(
                    "Surasta sąskaita " + oldNumber + " ir pakeistas jos numeris",
                    objectsToPrint,
                    ColumnConfigurations.getChangedNumberAccountColumns()
            );
        } else {
            printer.printMessage("Įvyko klaida keičiant sąskaitos " + oldNumber + " numerį.");
        }


        // Sąskaitos ištrynimas
        String accountToRemove = "LT123456";
        boolean removed = manager.removeAccountByNumber(accountToRemove);
        if (removed) {
            printer.printTable(
                    "Banko " + manager.getCurrentBank().name() + " sąskaitų sąrašas po sąskaitos "
                    + accountToRemove + " pašalinimo",
                    manager.getAccounts(),
                    ColumnConfigurations.getAccountAllColumns()
            );
        } else {
            printer.printMessage("Nepavyko pašalinti sąskaitos " + accountToRemove);
        }
    }
}

