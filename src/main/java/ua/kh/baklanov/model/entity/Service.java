package ua.kh.baklanov.model.entity;

public class Service extends Entity {
    private long idPC;
    private long idTV;
    private long idMobile;

    public long getIdPC() {
        return idPC;
    }

    public void setIdPC(long idPC) {
        this.idPC = idPC;
    }

    public long getIdTV() {
        return idTV;
    }

    public void setIdTV(long idTV) {
        this.idTV = idTV;
    }

    public long getIdMobile() {
        return idMobile;
    }

    public void setIdMobile(long idMobile) {
        this.idMobile = idMobile;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idPC=" + idPC +
                ", idTV=" + idTV +
                ", idMobile=" + idMobile +
                '}';
    }
}
