package com.github.s1ckcode.SalesManagement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Event {

    @JoinColumn(name = "USER_ID")
    private int user;
    @Id
    @GeneratedValue
    private int eventId;
    private String type;
    private String notes;
    private LocalDate date = LocalDate.now();

    private int leadID;
    private int userID;

    public Event() {
    }

    public int getUser() {
        return user;
    }


    public void setUser(int user) {
        this.user = user;
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

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
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