package com.example.dating_app.repository;

import com.example.dating_app.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    @Override
    Optional<UserProfileEntity> findById(Long user_id);

    @Query(value = "SELECT MAX(user_id) FROM user_profiles", nativeQuery = true)
    Long getMaxUserId();

}
