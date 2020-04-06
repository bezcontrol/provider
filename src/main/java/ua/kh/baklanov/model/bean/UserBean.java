package ua.kh.baklanov.model.bean;

import ua.kh.baklanov.model.entity.Role;
import ua.kh.baklanov.model.entity.Status;
import ua.kh.baklanov.model.entity.User;

import java.io.Serializable;

public class UserBean implements Serializable {
    private User user;
    private Role role;
    private Status status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
