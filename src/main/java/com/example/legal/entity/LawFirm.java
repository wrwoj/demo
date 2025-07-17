package com.example.legal.entity;

// LawFirm.java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LawFirm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String specialties;
    private String contactInfo;
    private String website;
    private Integer foundingYear;

    // Default constructor
    public LawFirm() {
    }

    // Parameterized constructor
    public LawFirm(String name, String description, String specialties, String contactInfo, String website, int foundingYear) {
        this.name = name;
        this.description = description;
        this.specialties = specialties;
        this.contactInfo = contactInfo;
        this.website = website;
        this.foundingYear = foundingYear;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSpecialties() {
        return specialties;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getWebsite() {
        return website;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }

    @Override
    public String toString() {
        return "LawFirm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", specialties='" + specialties + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", website='" + website + '\'' +
                ", foundingYear=" + foundingYear +
                '}';
    }
}