package ua.kh.baklanov.model.entity;

public class User extends Entity {
    private String login;
    private String password;
    private String email;
    private long idRole;
    private long idStatus;
    private double bill;

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", idRole=" + idRole +
                ", idStatus=" + idStatus +
                '}';
    }
}
