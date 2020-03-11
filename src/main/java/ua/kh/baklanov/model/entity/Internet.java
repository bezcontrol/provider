package ua.kh.baklanov.model.entity;

public class Internet extends Entity {
    private int speed;
    private String technology;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "Internet{" +
                "speed=" + speed +
                ", technology='" + technology + '\'' +
                '}';
    }
}
