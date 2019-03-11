package com.github.s1ckcode.SalesManagement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Event {

    /*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    */
    //private User user;
    private int user;
    @Id
    @GeneratedValue
    private int eventId;
    private String type;
    private String notes;
    private LocalDate date = LocalDate.now();

    private int leadID;

    public Event() {
    }

    public Event(int user, String type, String notes) {
        this.user = user;
        this.type = type;
        this.notes = notes;
    }

    public int getUser() {
        return user;
    }

/*
    public void setUser(User user) {
        this.user = user;
    }
    */
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
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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

}