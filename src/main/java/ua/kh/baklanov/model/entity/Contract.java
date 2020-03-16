package ua.kh.baklanov.model.entity;

import java.time.LocalDateTime;

public class Contract extends Entity {
    private long idUser;
    private long idTariff;
    private LocalDateTime contractConclusionDate;

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

    public LocalDateTime getContractConclusionDate() {
        return contractConclusionDate;
    }

    public void setContractConclusionDate(LocalDateTime contractConclusionDate) {
        this.contractConclusionDate = contractConclusionDate;
    }
}
