package me.neeejm.trackiniapi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private double latitude;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    public int getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Date getDate() {
        return date;
    }

    public void setLongitude(double l) {
        longitude = l;
    }

    public void setLatitude(double l) {
        latitude = l;
    }

    public void setDate(Date d) {
        date = d;
    }
}