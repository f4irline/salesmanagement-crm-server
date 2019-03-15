package com.github.s1ckcode.SalesManagement.Lead;

import com.github.s1ckcode.SalesManagement.Event.Event;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Lead {

    @Id
    @GeneratedValue
    private int leadId;
    private LocalDate date;
    private String companyName;
    private String industry;
    private String contactPerson;
    private String contactRole;
    private String phoneNumber;
    private String email;
    private String website;
    private String notes;

    public Lead() {
    }

    public Lead(LocalDate date, String companyName, String contactPerson, String contactRole, String phoneNumber, String email, String website, String industry, String notes) {
        this.date = date;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.contactRole = contactRole;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        this.industry = industry;
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContactRole() {
        return contactRole;
    }

    public void setContactRole(String contactRole) {
        this.contactRole = contactRole;
    }

    public int getLeadId() {
        return leadId;
    }

    public void setLeadId(int leadId) {
        this.leadId = leadId;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return companyName;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.companyName = company;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contactPerson;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contactPerson = contact;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phoneNumber;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phoneNumber = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }
}