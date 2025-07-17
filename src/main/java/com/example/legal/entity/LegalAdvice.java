package com.example.legal.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class LegalAdvice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String legalBasis;
    private String relatedLaws;
    private String contactInfo;
    private String author;

    private LocalDate datePublished;
    private LocalDate lastUpdated;

    private int views = 0;
    private boolean featured = false;
    private String difficultyLevel;

    @ManyToOne
    @JoinColumn(name = "law_firm_id")
    private LawFirm lawFirm;

    private boolean isQuestion = false;

    // Answer fields
    @Column(columnDefinition = "TEXT")
    private String answerContent;

    private LocalDate answerDate;

    @ManyToOne
    @JoinColumn(name = "answered_by_id")
    private User answeredBy;

    // Constructors
    public LegalAdvice() {
    }

    public LegalAdvice(String title, String description, String category, String content,
                       String legalBasis, String relatedLaws, String contactInfo, String author,
                       LocalDate datePublished, LocalDate lastUpdated, int views, boolean featured,
                       String difficultyLevel, LawFirm lawFirm, boolean isQuestion) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.content = content;
        this.legalBasis = legalBasis;
        this.relatedLaws = relatedLaws;
        this.contactInfo = contactInfo;
        this.author = author;
        this.datePublished = datePublished;
        this.lastUpdated = lastUpdated;
        this.views = views;
        this.featured = featured;
        this.difficultyLevel = difficultyLevel;
        this.lawFirm = lawFirm;
        this.isQuestion = isQuestion;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLegalBasis() {
        return legalBasis;
    }

    public void setLegalBasis(String legalBasis) {
        this.legalBasis = legalBasis;
    }

    public String getRelatedLaws() {
        return relatedLaws;
    }

    public void setRelatedLaws(String relatedLaws) {
        this.relatedLaws = relatedLaws;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public LawFirm getLawFirm() {
        return lawFirm;
    }

    public void setLawFirm(LawFirm lawFirm) {
        this.lawFirm = lawFirm;
    }

    public boolean isQuestion() {
        return isQuestion;
    }

    public void setQuestion(boolean question) {
        isQuestion = question;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public LocalDate getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(LocalDate answerDate) {
        this.answerDate = answerDate;
    }

    public User getAnsweredBy() {
        return answeredBy;
    }

    public void setAnsweredBy(User answeredBy) {
        this.answeredBy = answeredBy;
    }

    @Override
    public String toString() {
        return "LegalAdvice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", content='" + (content != null && content.length() > 50 ? content.substring(0, 50) + "..." : content) + '\'' +
                ", legalBasis='" + legalBasis + '\'' +
                ", relatedLaws='" + relatedLaws + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", author='" + author + '\'' +
                ", datePublished=" + datePublished +
                ", lastUpdated=" + lastUpdated +
                ", views=" + views +
                ", featured=" + featured +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", lawFirm=" + (lawFirm != null ? lawFirm.getName() : "null") +
                ", isQuestion=" + isQuestion +
                ", answerContent='" + (answerContent != null && answerContent.length() > 50 ? answerContent.substring(0, 50) + "..." : answerContent) + '\'' +
                ", answerDate=" + answerDate +
                ", answeredBy=" + (answeredBy != null ? answeredBy.getName() : "null") +
                '}';
    }
}