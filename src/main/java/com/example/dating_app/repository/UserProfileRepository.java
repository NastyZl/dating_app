package com.example.dating_app.repository;

import com.example.dating_app.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    @Override
    Optional<UserProfileEntity> findById(Long user_id);

}
