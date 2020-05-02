package ua.kh.baklanov.model.entity;

import java.io.Serializable;

/**
 * Abstract class that contains id and extended by all models
 * @author Aleksei Baklanov
 */
public abstract class AbstractEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
