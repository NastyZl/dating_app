package com.example.dating_app.repository;

import com.example.dating_app.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
    @Override
    Optional<MatchEntity> findById(Long user_id);
}
