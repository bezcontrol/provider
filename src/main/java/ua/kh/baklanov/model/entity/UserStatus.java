package ua.kh.baklanov.model.entity;

public enum  UserStatus {
    WAITING(1),
    REGISTERED(2),
    BLOCKED(3);

    private long value;

    UserStatus(long value) {
        this.value=value;
    }

    public long getValue() {
        return value;
    }
}
