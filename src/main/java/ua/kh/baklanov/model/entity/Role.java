package ua.kh.baklanov.model.entity;

public enum Role {
    ADMIN(1),
    CLIENT(2);

    private long value;

    Role(long value) {
        this.value=value;
    }

    public long getValue() {
        return value;
    }

    public static Role getRole(User user) {
        long idRole = user.getIdRole();
        for(Role e : values()) {
            if(e.value==idRole) {
                return e;
            }
        }
        return CLIENT;
    }
}
