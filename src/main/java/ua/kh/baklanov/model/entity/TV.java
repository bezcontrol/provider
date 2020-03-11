package ua.kh.baklanov.model.entity;

public class TV extends Entity{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TV{" +
                "type='" + type + '\'' +
                '}';
    }
}
