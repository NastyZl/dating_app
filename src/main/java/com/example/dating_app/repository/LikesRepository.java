package com.example.dating_app.repository;

import com.example.dating_app.entity.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<LikesEntity, Long> {
    @Override
    Optional<LikesEntity> findById(Long user_id);
}
