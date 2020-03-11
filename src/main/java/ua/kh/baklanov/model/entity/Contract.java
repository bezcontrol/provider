package ua.kh.baklanov.model.entity;

import java.time.LocalDateTime;

public class Contract extends Entity {
    private double bill;
    private long idUser;
    private long idTariff;
    private long idStatus;
    private LocalDateTime contractConclusionDate;

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(long idTariff) {
        this.idTariff = idTariff;
    }

    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
    }

    public LocalDateTime getContractConclusionDate() {
        return contractConclusionDate;
    }

    public void setContractConclusionDate(LocalDateTime contractConclusionDate) {
        this.contractConclusionDate = contractConclusionDate;
    }
}
