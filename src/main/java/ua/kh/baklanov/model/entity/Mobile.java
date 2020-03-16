package ua.kh.baklanov.model.entity;

public class Mobile extends Entity {
    private int numOfMinutesInside;
    private int numOfMinutesOutside;
    private int numOfSMS;
    private int numOfMbts;

    public int getNumOfMinutesInside() {
        return numOfMinutesInside;
    }

    public void setNumOfMinutesInside(int numOfMinutesInside) {
        this.numOfMinutesInside = numOfMinutesInside;
    }

    public int getNumOfMinutesOutside() {
        return numOfMinutesOutside;
    }

    public void setNumOfMinutesOutside(int numOfMinutesOutside) {
        this.numOfMinutesOutside = numOfMinutesOutside;
    }

    public int getNumOfSMS() {
        return numOfSMS;
    }

    public void setNumOfSMS(int numOfSMS) {
        this.numOfSMS = numOfSMS;
    }

    public int getNumOfMbts() {
        return numOfMbts;
    }

    public void setNumOfMbts(int numOfMbts) {
        this.numOfMbts = numOfMbts;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "numOfMinutesInside=" + numOfMinutesInside +
                ", numOfMinutesOutside=" + numOfMinutesOutside +
                ", numOfSMS=" + numOfSMS +
                ", numOfMbts=" + numOfMbts +
                '}';
    }
}
