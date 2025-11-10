import model.Bank;
import service.BankDataLoader;
import service.Read;

public class Main {
    public static void main(String[] args) {
        BankDataLoader loader = new BankDataLoader();
        Bank swedbank = loader.loadBankData("resources//duomenys.txt");

        System.out.println("=== NUSKAITYTI DUOMENYS ===");
        System.out.println("Bankas: " + swedbank.name());

    }
}

