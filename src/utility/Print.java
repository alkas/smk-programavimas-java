package utility;

import model.Account;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Print {
    private String filename;

    public Print(String filename) {
        this.filename = filename;
    }

    /**
     * Spausdina sąskaitų lentelę į tekstinį failą
     */
    public void printAccountsTable(List<Account> account) throws IOException {

        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            printTableHeader(out);
        } catch (IOException ex) {
            System.out.println("Nepavyko įrašyti failo: " + filename);
            System.out.println("Klaida: " + ex.getMessage());
        }
    }

    /**
     *  Spausdina lentelės antraštes
     */
    private void printTableHeader(BufferedWriter out) throws IOException {
        String header = String.format("| %-18s | %-6s | %-10s | %-8s | %-25s | %-14s | %-28s |",
                "Account Number", "PIN", "Balance", "ATM ID", "Address", "Account Type",
                "New Balance (withdraw 200€)");
        out.write(header);
    }

    /**
     * Prints a separator line for the table
     */
    private void printTableSeparator(PrintWriter writer) {
        writer.println("|" + "-".repeat(20) + "|" + "-".repeat(8) + "|" + "-".repeat(12) +
                "|" + "-".repeat(10) + "|" + "-".repeat(27) + "|" + "-".repeat(16) +
                "|" + "-".repeat(30) + "|");
    }

    /**
     * Prints a single account row in the table
     */
    private void printAccountRow(PrintWriter writer, Account account,
                                 Map<String, Double> balancesAfterWithdrawal) {
        Double newBalance = balancesAfterWithdrawal.get(account.getNumber());
        String newBalanceStr = newBalance != null ? String.format("%.2f €", newBalance) : "N/A";

        String row = String.format("| %-18s | %-6s | %8.2f € | %-8s | %-25s | %-14s | %-28s |",
                account.getNumber(),
                account.getPin(),
                account.getBalance(),
                account.getATM().getIdNumber(),
                account.getATM().getAddress(),
                account.getAccountType(),
                newBalanceStr);

        writer.println(row);
    }

}
