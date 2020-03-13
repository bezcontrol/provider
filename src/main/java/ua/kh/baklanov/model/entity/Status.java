package ua.kh.baklanov.model.entity;

public enum Status {
    WAITING(1),
    REGISTERED(2),
    BLOCKED(3),
    MISSED(4);

    private long value;

    Status(long value) {
        this.value=value;
    }

    public long getValue() {
        return value;
    }

    public static Status getStatus(User user) {
        long idStatus = user.getIdStatus();
        for(Status e : values()) {
            if(e.value==idStatus) {
                return e;
            }
        }
        return Status.MISSED;
    }
}
