package com.github.s1ckcode.SalesManagement.Event;

import com.github.s1ckcode.SalesManagement.Lead.Lead;
import com.github.s1ckcode.SalesManagement.User.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Event {

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToOne
    @JoinColumn(name = "LEAD_ID")
    private Lead lead;
    @TableGenerator(name = "Event_Gen",
            table = "EVENT_ID_GEN",
            pkColumnName = "EVENT_ID",
            valueColumnName = "GEN_VAL",
            pkColumnValue = "Event_Gen",
            initialValue = 100000,
            allocationSize = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Event_Gen")
    private int eventId;
    private int eventType;
    private String notes;
    private LocalDate date = LocalDate.now();
    private double sum;
    private String place;
    private String contactPerson;
    private String phoneNumber;
    private String email;

    public static final int CONTACT = 0;  //yht.otto
    public static final int MEETING = 1;  //tapaaminen
    public static final int OFFER = 2;    //tarjous
    public static final int SALE = 3;     //kauppa

    public Event() {
    }

    //Kontakti
    public Event(User user,Lead lead, int eventType, String notes, LocalDate date) {
        setLead(lead);
        setUser(user);
        setEventType(eventType);
        setNotes(notes);
        setDate(date);
    }

    //Kauppa tarjous
    public Event(User user, Lead lead, int eventType, String notes, LocalDate date, Double sum) {
        setLead(lead);
        setUser(user);
        setEventType(eventType);
        setNotes(notes);
        setDate(date);
        setSum(sum);
    }

    //Tapaaminen
    public Event(User user,Lead lead, int eventType, String notes, LocalDate date, String place) {
        setLead(lead);
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

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
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

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
