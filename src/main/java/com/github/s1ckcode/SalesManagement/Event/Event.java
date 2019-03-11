package com.github.s1ckcode.SalesManagement.Event;

import com.github.s1ckcode.SalesManagement.User.User;

import javax.persistence.*;
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
    private LocalDate date = LocalDate.now();
    private int leadID;
    private double sum;
    private String place;

    public static final int CONTACT = 0;  //yht.otto
    public static final int MEETING = 1;  //tapaaminen
    public static final int OFFER = 2;    //tarjous
    public static final int SALE = 3;     //kauppa

    public Event() {
    }

    //Kontakti
    public Event(User user, int eventType, String notes, LocalDate date) {
        setUser(user);
        setEventType(eventType);
        setNotes(notes);
        setDate(date);
    }

    //Kauppa tarjous
    public Event(User user, int eventType, String notes, LocalDate date, Double sum) {
        setUser(user);
        setEventType(eventType);
        setNotes(notes);
        setDate(date);
        setSum(sum);
    }

    //Tapaaminen
    public Event(User user, int eventType, String notes, LocalDate date, String place) {
        setUser(user);
        setEventType(eventType);
        setNotes(notes);
        setDate(date);
        setPlace(place);
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
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
