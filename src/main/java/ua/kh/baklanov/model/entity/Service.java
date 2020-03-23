package ua.kh.baklanov.model.entity;

public class Service extends AbstractEntity {
    private long idPC;
    private long idTV;
    private long idMobile;
    private long idInternet;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public long getIdInternet() {
        return idInternet;
    }

    public void setIdInternet(long idInternet) {
        this.idInternet = idInternet;
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
