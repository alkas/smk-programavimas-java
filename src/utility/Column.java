package utility;

public class Column<T> {
    private String header;
    private int width;
    private ValueGetter<T> valueGetter;

    public Column(String header, int width, ValueGetter<T> valueGetter) {
        this.header = header;
        this.width = width;
        this.valueGetter = valueGetter;
    }

    public String getHeader() {
        return String.format("| %-" + width + "s | ", header);
    }

    public String getSeparator() {
        return "|" + "-".repeat(width + 2);
    }

    public String getValue(T object) {
        String value = valueGetter.getValue(object);
        return String.format("| %-" + width + "s | ", value);
    }
}
