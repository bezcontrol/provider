package ua.kh.baklanov.model.bean;

import ua.kh.baklanov.model.entity.Internet;
import ua.kh.baklanov.model.entity.Tariff;

public class AnyTariff<T>{
    private Tariff tariff;
    private T service;
    private Internet internet;

    public AnyTariff(){}

    public Internet getInternet() {
        return internet;
    }

    public void setInternet(Internet internet) {
        this.internet = internet;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public T getService() {
        return service;
    }

    public void setService(T service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "AnyTariff{" +
                "tariff=" + tariff.toString() +
                ", service=" + service.toString() +
                ", internet=" + internet.toString() +
                '}';
    }
}
