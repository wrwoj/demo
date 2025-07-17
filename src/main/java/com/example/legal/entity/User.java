package com.example.legal.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String role; // USER, PROVIDER, ADMIN

    @ManyToOne
    @JoinColumn(name = "law_firm_id")
    private LawFirm lawFirm;

    @OneToMany(mappedBy = "answeredBy")
    private List<LegalAdvice> answeredQuestions;

    // Constructors
    public User() {
    }

    public User(String username, String password, String name, String email, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LawFirm getLawFirm() {
        return lawFirm;
    }

    public void setLawFirm(LawFirm lawFirm) {
        this.lawFirm = lawFirm;
    }

    public List<LegalAdvice> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<LegalAdvice> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", lawFirm=" + (lawFirm != null ? lawFirm.getName() : "null") +
                '}';
    }
}