package ua.kh.baklanov.model.entity;

public class PC extends Entity {
    private int numOfConnectedPC;

    public int getNumOfConnectedPC() {
        return numOfConnectedPC;
    }

    public void setNumOfConnectedPC(int numOfConnectedPC) {
        this.numOfConnectedPC = numOfConnectedPC;
    }

    @Override
    public String toString() {
        return "PC{" +
                "numOfConnectedPC=" + numOfConnectedPC +
                '}';
    }
}
