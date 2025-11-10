package service;

import model.Account;
import utility.Column;

import java.io.*;
import java.util.List;

public class Print {
    private static final char VERTICAL_CHAR = '|';
    private static final char HORIZONTAL_CHAR = '-';
    private static final char INTERSECTION_CHAR = '+';
    private final String filename;

    public Print(String filename) { this.filename = filename; }

    /**
     * Spausdina sąskaitų lentelę į tekstinį failą
     */
    public void printAccountsTable(
            List<Account> accounts,
            List<Column<Account>> columns
    ) throws IOException {

        // try-with-resources blokas automatiškai uždaro BufferedWriter
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            // lentelės vertikali linija
            String separatorLine = buildSeparatorLine(columns);
            out.write(separatorLine);
            out.newLine();

            // antraštės eilutė
            String headerRow = buildHeaderRow(columns);
            out.write(headerRow);
            out.newLine();

            out.write(separatorLine);
            out.newLine();

            for (Account account : accounts) {
                // reikšmių eilutė
                String row = buildRow(columns, account);
                out.write(row);
                out.newLine();
            }

            out.write(separatorLine);
            out.newLine();

        } catch (IOException ex) {
            System.out.println("Nepavyko įrašyti failo: " + filename);
            System.out.println("Klaida: " + ex.getMessage());
        }
    }

    /**
     *  Grąžina sugeneruotą horizontalią liniją
     */
    private <T> String buildSeparatorLine(List<Column<T>> columns) {
        StringBuilder lineSeparator = new StringBuilder();
        for (Column<T> column : columns) {
            lineSeparator.append(INTERSECTION_CHAR)
                    .append(column.getColumnSeparator(HORIZONTAL_CHAR));
        }
        lineSeparator.append(INTERSECTION_CHAR);

        return lineSeparator.toString();
    }

    /**
     *  Grąžina sugeneruotą antraštės eilutę
     */
    private <T> String buildHeaderRow(List<Column<T>> columns) {
        StringBuilder header = new StringBuilder();
        for (Column<T> column : columns) {
            header.append(VERTICAL_CHAR).append(column.getColumnHeader());
        }
        header.append(VERTICAL_CHAR);
        return header.toString();
    }

    /**
     *  Grąžina sugeneruotą lentelės reikšmių eilutę
     */
    private <T> String buildRow(List<Column<T>> columns, T objectOfValues) {
        StringBuilder row = new StringBuilder();
        for (Column<T> column : columns) {
            row.append(VERTICAL_CHAR).append(column.getColumnValue(objectOfValues));
        }
        row.append(VERTICAL_CHAR);
        return row.toString();
    }

}
