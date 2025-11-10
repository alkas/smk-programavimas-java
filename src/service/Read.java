package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Read {

    /**
     *  Nuskaito failo eilutes ir grąžina eilučių sąrašą
     */
    public List<String> readAllLines(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch(IOException ex) {
            System.out.println("Failo nuskaitymo klaida: " + ex.getMessage());
        }
        return lines;
    }

}
