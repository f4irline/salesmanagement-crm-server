package com.github.s1ckcode.SalesManagement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Event {


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    @Id
    @GeneratedValue
    private int eventId;
    private int eventType;
    private String notes;
    private final LocalDate date = LocalDate.now();
    private int leadID;
    private double sum;

    public static final int CONTACT = 0;  //yht.otto
    public static final int MEETING = 1;  //tapaaminen
    public static final int OFFER = 2;    //tarjous
    public static final int SALE = 3;     //kauppa

    public Event() {
    }

    public Event(User user, int eventType, String notes) {
        this.user = user;
        this.eventType = eventType;
        this.notes = notes;
    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }






	/**
     * @return the id
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * @param id the id to set
     */
    public void setEventId(int id) {
        this.eventId = id;
    }

    /**
     * @return the type
     */
    public int getEventType() {
        return eventType;
    }

    /**
     * @param eventType the type to set
     */
    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @return the leadID
     */
    public int getLeadID() {
        return leadID;
    }

    /**
     * @param leadID the leadID to set
     */
    public void setLeadID(int leadID) {
        this.leadID = leadID;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}