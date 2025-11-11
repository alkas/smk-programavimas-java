package model;

import utility.MoneyFormatter;

public record AccountType(
        String accountType,
        int accountCount,
        double totalBalance
) {
    public String getFormattedTotalBalance() {
        return MoneyFormatter.format(totalBalance);
    }
    public String getFormattedCount() { return accountCount + " sąsk."; }
}
