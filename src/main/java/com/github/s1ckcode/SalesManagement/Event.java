package com.github.s1ckcode.SalesManagement;

import java.sql.Date;

public class Event {

    private int id;
    private String type;
    private String notes;
    private Date date;

    private int leadID;
    private int userID;

    public Event() {
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
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

}