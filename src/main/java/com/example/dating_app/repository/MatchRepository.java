package com.example.dating_app.repository;

import com.example.dating_app.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
    @Query("FROM MatchEntity WHERE firstUser.id = :userId OR secondUser.id = :userId")
    List<MatchEntity> findMatchesByUserId(@Param("userId") Long userId);
}