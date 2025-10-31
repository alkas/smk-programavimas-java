package utility;

import model.Account;

import java.io.*;
import java.util.List;

public class Print {
    private final String filename;

    public Print(String filename) {
        this.filename = filename;
    }

    /**
     * Spausdina sąskaitų lentelę į tekstinį failą
     */
    public void printAccountsTable(List<Account> accounts, List<Column<Account>> columns) throws IOException {

        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder lineSeparator = new StringBuilder();
            for (Column<Account> column : columns) {
                lineSeparator.append(column.getSeparator());
            }

            out.write(lineSeparator + "|");

            // antraštės
            for (Column<Account> column : columns) {
                out.write(column.getHeader());
            }
            out.write("|");

            out.write(lineSeparator + "|");

            // kiekvienos sąskaitos duomenys
            for (Account account : accounts) {
                for (Column<Account> column : columns) {
                    out.write(column.getValue(account));
                }
                out.write("|");
            }

            out.write(lineSeparator + "|");

        } catch (IOException ex) {
            System.out.println("Nepavyko įrašyti failo: " + filename);
            System.out.println("Klaida: " + ex.getMessage());
        }
    }

}
