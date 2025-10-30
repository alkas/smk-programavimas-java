import model.ATM;
import model.Account;
import model.Bank;

public class Main {
    public static void main(String[] args) {
        Bank seb = new Bank("SEB");

        Account account1 = new Account("0123", "LT120252584660023", 0);
        Account account2 = new Account("0124", "LT120252584660024", 125.30);
        Account account3 = new Account("0125", "LT120252584660025", 500.00);
        Account account4 = new Account("0126", "LT120252584660026", 75.50);

        ATM atm1 = new ATM("atm1", "Taikos pr.61, Klaipėda");
        ATM atm2 = new ATM("atm2", "Ozo g. 25, Vilnius");
        ATM atm3 = new ATM("atm3", "Aido g. 8, Šiauliai");
    }
}
