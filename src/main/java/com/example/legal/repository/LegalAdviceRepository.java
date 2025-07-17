package com.example.legal.repository;

import com.example.legal.entity.LegalAdvice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalAdviceRepository extends JpaRepository<LegalAdvice, Long> {

    // Note: findAll() is inherited from JpaRepository and does not need to be redeclared.

    /**
     * Finds legal advice items by their type (article or question).
     * @param isQuestion true for questions, false for articles.
     * @return A list of LegalAdvice items.
     */
    List<LegalAdvice> findByIsQuestion(boolean isQuestion);

    /**
     * Finds all questions submitted for a specific law firm.
     * Assumes a 'lawFirm' field exists in the LegalAdvice entity.
     * @param lawFirmId The ID of the law firm.
     * @return A list of questions for the firm.
     */
    List<LegalAdvice> findByLawFirmIdAndIsQuestionTrue(Long lawFirmId);

    /**
     * Finds all unanswered questions for a specific law firm using a derived query.
     * @param lawFirmId The ID of the law firm.
     * @return A list of unanswered questions.
     */
    List<LegalAdvice> findByLawFirmIdAndIsQuestionTrueAndAnswerContentIsNull(Long lawFirmId);

    /**
     * Finds all answered questions for a specific law firm using a derived query.
     * @param lawFirmId The ID of the law firm.
     * @return A list of answered questions.
     */
    List<LegalAdvice> findByLawFirmIdAndIsQuestionTrueAndAnswerContentIsNotNull(Long lawFirmId);

    /**
     * Finds all legal advice items answered by a specific provider.
     * Assumes an 'answeredBy' entity relationship with an 'id' field.
     * @param providerId The ID of the provider who answered.
     * @return A list of answered LegalAdvice items.
     */
    List<LegalAdvice> findByAnsweredById(Long providerId);

    /**
     * Searches questions for a specific law firm by a query string in the content.
     * This query is case-insensitive.
     * @param firmId The ID of the law firm.
     * @param query The search term.
     * @return A list of matching questions.
     */
    @Query("SELECT la FROM LegalAdvice la WHERE la.lawFirm.id = :firmId AND la.isQuestion = true AND " +
            "LOWER(la.content) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<LegalAdvice> searchQuestionsByContent(@Param("firmId") Long firmId, @Param("query") String query);

    /**
     * Finds all featured articles.
     * @return A list of featured LegalAdvice articles.
     */
    List<LegalAdvice> findByIsQuestionFalseAndFeaturedTrue();

    /**
     * Finds all articles belonging to a specific category.
     * @param category The name of the category.
     * @return A list of articles in that category.
     */
    List<LegalAdvice> findByIsQuestionFalseAndCategory(String category);

    /**
     * Finds the most recent questions.
     * @param pageable A Pageable object to control the number of results (e.g., PageRequest.of(0, 5)).
     * @return A list of recent questions.
     */
    @Query("SELECT la FROM LegalAdvice la WHERE la.isQuestion = true ORDER BY la.datePublished DESC")
    List<LegalAdvice> findRecentQuestions(Pageable pageable);

    /**
     * Finds the most recent answers.
     * @param pageable A Pageable object to control the number of results (e.g., PageRequest.of(0, 5)).
     * @return A list of recently answered questions.
     */
    @Query("SELECT la FROM LegalAdvice la WHERE la.isQuestion = true AND la.answerContent IS NOT NULL ORDER BY la.answerDate DESC")
    List<LegalAdvice> findRecentAnswers(Pageable pageable);
}