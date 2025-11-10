package utility;

public class Column<T> {
    private String header;
    private int width;
    private IValueGetter<T> valueGetter;

    public Column(String header, int width, IValueGetter<T> valueGetter) {
        this.header = header;
        this.width = Math.max(width, header.length()) + 2;
        this.valueGetter = valueGetter;
    }

    /**
     *  Grąžina stulpelio antraštės tekstą
     */
    public String getColumnHeader() {
        int padding = (width - header.length()) / 2;
        return String.format("%-" + width + "s", " ".repeat(padding) + header);
    }

    /**
     *  Grąžina lentelės horizontalią liniją tekstiniu formatu
     */
    public String getColumnSeparator(char separator) {
        return String.valueOf(separator).repeat(width);
    }

    /**
     *  Grąžina stulpelio reikšmę tekstiniu formatu
     */
    public String getColumnValue(T object) {
        String value = valueGetter.getValue(object);
        return String.format("%-" + width + "s", " " + value);
    }
}
