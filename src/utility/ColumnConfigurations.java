package utility;

import model.Account;

import java.util.List;

public class ColumnConfigurations {

    /**
     *  Visi sąskaitos stulpeliai
     */
    public static List<Column<Account>> getFullAccountColumns() {
        return List.of(
                new Column<>("Number", 18, new IValueGetter<Account>() {
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
                }));
    }

}
