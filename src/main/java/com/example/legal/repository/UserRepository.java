package com.example.legal.repository;

import com.example.legal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username (for authentication)
    Optional<User> findByUsername(String username);

    // Find all providers belonging to a specific law firm
    List<User> findByLawFirmIdAndRole(Long lawFirmId, String role);

    // Find all users with provider role
    List<User> findByRole(String role);

    // Custom query to find users who have answered questions
    @Query("SELECT DISTINCT u FROM User u JOIN u.answeredQuestions q WHERE q.lawFirm.id = :firmId")
    List<User> findProvidersWhoAnsweredQuestions(@Param("firmId") Long firmId);

    // Check if a user belongs to a specific law firm
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END " +
            "FROM User u WHERE u.id = :userId AND u.lawFirm.id = :firmId")
    boolean existsByIdAndLawFirmId(@Param("userId") Long userId, @Param("firmId") Long firmId);

    // Find users by name (for search functionality)
    List<User> findByNameContainingIgnoreCase(String name);

    // Find provider by email
    Optional<User> findByEmail(String email);
}