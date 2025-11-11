package utility;

public class MoneyFormatter {

    /**
     *  Formatuoja piniginę sumą į tekstą su € ženklu
     */
    public static String format(Double amount) {
        if (amount == null) {
            return "-";
        }
        return String.format("%.2f €", amount).replace(".", ",");
    }
}
