package com.github.s1ckcode.SalesManagement.Lead;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.User.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lead {

    @TableGenerator(name = "Lead_Gen",
            table = "LEAD_ID_GEN",
            pkColumnName = "LEAD_ID",
            valueColumnName = "GEN_VAL",
            pkColumnValue = "Lead_Gen",
            initialValue = 100000,
            allocationSize = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Lead_Gen")
    private int leadId;

    private LocalDate date;
    private String userName;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    private String companyName;
    private String industry;
    private String contactPerson;
    private String contactRole;
    private String phoneNumber;
    private String email;
    private String meeted;
    @ElementCollection
    private List<String> discussion;
    private String potential;
    private String notes;
    private String stage;

    public Lead() {
    }

    public Lead(
            LocalDate date, String userName, String companyName, String industry, String contactPerson,
            String contactRole, String phoneNumber, String email, String meeted, List<String> discussion,
            String potential, String notes, User user) {
        this.user = user;
        this.date = date;
        this.userName = userName;
        this.companyName = companyName;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.contactRole = contactRole;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.meeted = meeted;
        this.discussion = discussion;
        this.potential = potential;
        this.notes = notes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param company the company to set
     */
    public void setCompanyName(String company) {
        this.companyName = company;
    }

    /**
     * @return the contact
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * @param contact the contact to set
     */
    public void setContactPerson(String contact) {
        this.contactPerson = contact;
    }

    /**
     * @return the phone
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhoneNumber(String phone) {
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

    public String getMeeted() {
        return meeted;
    }

    public void setMeeted(String meeted) {
        this.meeted = meeted;
    }

    public List<String> getDiscussion() {
        return discussion;
    }

    public void setDiscussion(List<String> discussion) {
        this.discussion = discussion;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStage() { return stage; }

    public void setStage(String stage) { this.stage = stage; }

    /**
     *
     */
    public void clone(Lead lead) {

        setDate(lead.getDate());
        setUserName(lead.getUserName());
        setCompanyName(lead.getCompanyName());
        setIndustry(lead.getIndustry());
        setContactPerson(lead.getContactPerson());
        setContactRole(lead.getContactRole());
        setPhoneNumber(lead.getPhoneNumber());
        setEmail(lead.getEmail());
        setMeeted(lead.getMeeted());
        setDiscussion(lead.getDiscussion());
        setPotential(lead.getPotential());
        setNotes(lead.getNotes());

    }
}