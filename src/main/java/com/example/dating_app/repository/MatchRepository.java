package com.example.dating_app.repository;

import com.example.dating_app.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
    @Override
    Optional<MatchEntity> findById(Long user_id);

    @Query(value = "INSERT INTO Match (first_user_id, second_user_id) VALUES (:first_user_id, :second_user_id)", nativeQuery = true)
    void createMatch(Long first_user_id, Long second_user_id);

    @Query("FROM MatchEntity WHERE firstUserId.id = :userId OR secondUserId.id = :userId")
    List<MatchEntity> findMatchesByUserId(@Param("userId") Long userId);
}
