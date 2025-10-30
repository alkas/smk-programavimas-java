package utility;

import model.ATM;
import model.Account;
import model.PreferentialAccount;
import model.RegularAccount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Read {

    // Nuskaito banko ir sąskaitų informaciją iš failo
    public List<Account> readAccountsFromFile(String fileName) {
        List<Account> accounts = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String bankName = reader.readLine();

            String line = null;
            while ((line = reader.readLine()) != null) {
                try {
                    Account account = parseLine(line);
                    accounts.add(account);
                } catch (Exception e) {
                    System.out.println("Nepavyko nuskaityti eilutės: " + line);
                    System.out.println("Klaida: " + e.getMessage());
                }
            }
        } catch(IOException ex) {

            System.out.println("Klaida: " + ex.getMessage());
        }
        return accounts;
    }

    // Nuskaitytos eilutės duomenis įrašo į objektą
    private Account parseLine(String line) {
        String[] parts = line.split(";");

        if (parts.length != 6) {
            throw new IllegalArgumentException(
                    "Klaida eilutės nuskaitymo metu. Turi būti 6 laukeliai, o gauta " + parts.length
            );
        }

        String accountNumber = parts[0].trim();
        String pin = parts[1].trim();
        String balanceString = parts[2].trim()
                .replace(" €", "")
                .replace(",", ".");
        double balance = Double.parseDouble(balanceString);
        String atmId = parts[3].trim();
        String address = parts[4].trim();
        String accountType = parts[5].trim();

        ATM atm = new ATM(atmId, address);
        if (accountType.equalsIgnoreCase("Regular")) {
            return new RegularAccount(accountNumber, pin, balance, atm);
        } else if (accountType.equalsIgnoreCase("Preferential")) {
            return new PreferentialAccount(accountNumber, pin, balance, atm);
        } else {
            throw new IllegalArgumentException("Nežinomas sąskaitos tipas: " + accountType);
        }
    }
}
