import model.Account;
import model.Bank;
import service.BankDataLoader;
import service.BankManager;
import service.Calculation;
import service.Print;
import utility.ColumnConfigurations;

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

        boolean removed = manager.removeAccountByNumber("LT347654");
        System.out.println(removed);
        printer.printAccountsTable(
                "Banko " + manager.getCurrentBank().name() + " sąskaitų sąrašas po sąskaitos pašalinimo",
                manager.getAccounts(),
                ColumnConfigurations.getFullAccountColumns());
    }


}

