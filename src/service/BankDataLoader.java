package service;

import model.Account;
import model.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankDataLoader {
    private final Read fileReader;
    private final AccountDataParser parser;

    public BankDataLoader() {
        this.fileReader = new Read();
        this.parser = new AccountDataParser();
    }

    /**
     *  Įkelia banko informaciją iš failo
     */
    public Bank loadBankData(String fileName) {

        List<String> lines = fileReader.readAllLines(fileName);

        if (lines.isEmpty())
            throw new IllegalArgumentException("Failas tuščias.");

        String bankName = lines.get(0);
        List<Account> accounts = parseAccounts(lines.subList(1, lines.size()));

        return new Bank(bankName, accounts);
    }

    /**
     *  Generuoja Accountų sąrašą iš failo eilučių
     */
    private List<Account> parseAccounts(List<String> accountLines) {
        List<Account> accounts = new ArrayList<>();

        for (String line : accountLines) {
            try {
                Account account = parser.parseAccountLine(line);
                accounts.add(account);
            } catch (Exception e) {
                System.out.println("Nepavyko nuskaityti eilutės: " + line);
                System.out.println("Klaida: " + e.getMessage());
            }
        }
        return accounts;
    }
}
