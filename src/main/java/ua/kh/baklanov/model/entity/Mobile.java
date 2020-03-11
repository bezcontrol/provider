package ua.kh.baklanov.model.entity;

public class Mobile extends Entity {
    private int numOfConnectedPhones;

    public int getNumOfConnectedPhones() {
        return numOfConnectedPhones;
    }

    public void setNumOfConnectedPhones(int numOfConnectedPhones) {
        this.numOfConnectedPhones = numOfConnectedPhones;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "numOfConnectedPhones=" + numOfConnectedPhones +
                '}';
    }
}
