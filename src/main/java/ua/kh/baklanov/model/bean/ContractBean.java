package ua.kh.baklanov.model.bean;

import ua.kh.baklanov.model.entity.Contract;
import ua.kh.baklanov.model.entity.ContractState;
import ua.kh.baklanov.model.entity.Tariff;

public class ContractBean {

    private UserBean userBean;
    private Tariff tariff;
    private Contract contract;
    private ContractState contractState;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ContractState getContractState() {
        return contractState;
    }

    public void setContractState(ContractState contractState) {
        this.contractState = contractState;
    }
}
