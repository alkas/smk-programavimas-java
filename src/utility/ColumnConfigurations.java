package utility;

import model.Account;
import model.AccountHistory;
import model.AccountType;
import model.Bank;

import java.util.List;

public class ColumnConfigurations {

    /**
     *  Pradinio sąskaitų sąrašo lentelės stulpeliai
     */
    public static List<Column<Account>> getAccountAllColumns() {
        return List.of(
                new Column<>("Number", 12, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getNumber(); }
                }),
                new Column<>("Pin", 6, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getPin(); }
                }),
                new Column<>("Balance", 10, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getFormattedBalance(); }
                }),
                new Column<>("ATM ID", 8, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getATM().getIdNumber(); }
                }),
                new Column<>("Address", 25, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getATM().getAddress(); }
                }),
                new Column<>("Account Type", 10, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getAccountType(); }
                })
        );
    }

    /**
     *  Sąskaitų sąrašo po paprasto balanso pakeitimo lentelės stulpeliai
     */
    public static List<Column<Account>> getChangedBalanceAccountColumns() {
        return List.of(
                new Column<>("Number", 12, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getNumber(); }
                }),
                new Column<>("Pin", 6, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getPin(); }
                }),
                new Column<>("Previous Balance", 10, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getFormattedPreviousBalance(); }
                }),
                new Column<>("New Balance", 10, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getFormattedBalance(); }
                }),
                new Column<>("Account Type", 10, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getAccountType(); }
                })
        );
    }

    /**
     *  Sąskaitų, kurioms buvo pakeistas sąskaitos numeris, lentelės stulpeliai
     */
    public static List<Column<AccountHistory>> getChangedNumberAccountColumns() {
        return List.of(
                new Column<>("Old Number", 12, new IValueGetter<AccountHistory>() {
                    final
                    @Override
                    public String getValue(AccountHistory object) { return object.getPreviousNumber(); }
                }),
                new Column<>("New Number", 12, new IValueGetter<AccountHistory>() {
                    @Override
                    public String getValue(AccountHistory object) { return object.getAccount().getNumber(); }
                }),
                new Column<>("Pin", 6, new IValueGetter<AccountHistory>() {
                    @Override
                    public String getValue(AccountHistory object) { return object.getAccount().getPin(); }
                }),
                new Column<>("Balance", 10, new IValueGetter<AccountHistory>() {
                    @Override
                    public String getValue(AccountHistory object) { return object.getAccount().getFormattedBalance(); }
                }),
                new Column<>("Account Type", 10, new IValueGetter<AccountHistory>() {
                    @Override
                    public String getValue(AccountHistory object) { return object.getAccount().getAccountType(); }
                })
        );
    }


    /**
     *  Sąskaitų, nuo kurių balanso buvo nurašytos lėšos, lenetlės stulpeliai
     */
    public static List<Column<Account>> getChangedBalanceAccountColumnsWithFee(double sum) {
        return List.of(
                new Column<>("Number", 12, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getNumber(); }
                }),
                new Column<>("Pin", 6, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getPin(); }
                }),
                new Column<>("Previous Balance", 10, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getFormattedPreviousBalance(); }
                }),
                new Column<>(
                        "New Balance (after " + MoneyFormatter.format(sum) + " withdraw)",
                        10,
                        new IValueGetter<Account>() {
                            @Override
                            public String getValue(Account object) { return object.getFormattedBalance(); }
                        }),
                new Column<>("Fee", 10, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) {
                        return MoneyFormatter.format(object.calculateFee(sum));
                    }
                }),
                new Column<>("Account Type", 10, new IValueGetter<Account>() {
                    @Override
                    public String getValue(Account object) { return object.getAccountType(); }
                })
        );
    }

    /**
     *  Sąskaitų tipų suvestinės lentelės stulpeliai
     */
    public static List<Column<AccountType>> getAccountTypeSummaryColumns() {
        return List.of(
                new Column<>("Account Type", 15, new IValueGetter<AccountType>() {
                    @Override
                    public String getValue(AccountType object) {
                        return object.accountType();
                    }
                }),
                new Column<>("Accounts", 8, new IValueGetter<AccountType>() {
                    @Override
                    public String getValue(AccountType object) {
                        return object.getFormattedCount();
                    }
                }),
                new Column<>("Total Balance", 16, new IValueGetter<AccountType>() {
                    @Override
                    public String getValue(AccountType object) {
                        return object.getFormattedTotalBalance();
                    }
                })
        );
    }

}
