import model.Account;
import model.Bank;
import service.BankDataLoader;
import service.BankManager;
import service.Print;
import utility.ColumnConfigurations;

public class Main {
    public static void main(String[] args) {
        BankDataLoader loader = new BankDataLoader();
        Bank swedbank = loader.loadBankData("resources//duomenys.txt");

        System.out.println("=== NUSKAITYTI DUOMENYS ===");
        System.out.println("Bankas: " + swedbank.name());

        Print printer = new Print("resources//rezultatai.txt");

        printer.printAccountsTable(
                "Banko " + swedbank.name() + " sąskaitų sąrašas",
                swedbank.accounts(),
                ColumnConfigurations.getFullAccountColumns());

        BankManager manager = new BankManager(swedbank);


    }


}

