package ua.kh.baklanov.web.search;

public enum Sorter {
    NAME_DESCENDING("Name: A-Z"),
    NAME_ASCENDING("Name: Z-A"),
    PRICE_DESCENDING("Price: High to Low"),
    PRICE_ASCENDING("Price: Low to High");

    public final String value;

    Sorter(String value) {
        this.value = value;
    }

    public static Sorter getSorter(String select) {
        for (Sorter s:Sorter.values()) {
            if(s.name().equals(select)){
                return s;
            }
        }
        return NAME_DESCENDING;
    }

    public String getValue() {
        return value;
    }
}
