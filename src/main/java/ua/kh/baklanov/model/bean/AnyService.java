package ua.kh.baklanov.model.bean;

import ua.kh.baklanov.model.entity.Internet;

public class AnyService<T> {
    private Internet internet;
    private T service;

    public Internet getInternet() {
        return internet;
    }

    public void setInternet(Internet internet) {
        this.internet = internet;
    }

    public T getService() {
        return service;
    }

    public void setService(T service) {
        this.service = service;
    }
}