package com.example.dating_app.repository;

import com.example.dating_app.entity.UserContactEntity;
import com.example.dating_app.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserContactRepository extends JpaRepository<UserContactEntity, Long> {

    @Query("FROM UserContactEntity WHERE user.id = :userId")
    UserContactEntity findContactByUserId(@Param("userId") Long userId);
}
