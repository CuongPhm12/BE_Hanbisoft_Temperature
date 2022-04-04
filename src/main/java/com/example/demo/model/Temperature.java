package com.example.demo.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float temperature;
    private Date datetime;
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private User user;
    private boolean status;
    public Temperature() {
    }

    public Temperature(Long id, float temperature, Date datetime) {
        this.id = id;
        this.temperature = temperature;
        this.datetime = datetime;
    }

    public Temperature(Long id, User user, float temperature, Date datetime) {
        this.id = id;
        this.user = user;
        this.temperature = temperature;
        this.datetime = datetime;
    }

    public Temperature(Long id, float temperature, Date datetime, User user, boolean status) {
        this.id = id;
        this.temperature = temperature;
        this.datetime = datetime;
        this.user = user;
        this.status = status;
    }

    public Temperature(float temperature, Date datetime, boolean status) {
        this.temperature = temperature;
        this.datetime = datetime;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
