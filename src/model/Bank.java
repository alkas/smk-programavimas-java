package model;

public record Bank(String name) {

    public Bank {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Banko pavadinimas negali būti tuščias");
        }
    }

}
