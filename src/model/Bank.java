package model;

import java.util.Collections;
import java.util.List;

public record Bank(String name, List<Account> accounts) {

    public Bank {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Banko pavadinimas negali būti tuščias");
        }
        accounts = accounts == null ? Collections.emptyList() : List.copyOf(accounts);
    }

    public Bank(String name) {
        this(name, Collections.emptyList());
    }
}
