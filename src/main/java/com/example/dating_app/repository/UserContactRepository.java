package com.example.dating_app.repository;

import com.example.dating_app.entity.MatchEntity;
import com.example.dating_app.entity.UserContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserContactRepository extends JpaRepository<UserContactEntity, Long> {

    @Override
    Optional<UserContactEntity> findById(Long id);

    @Query("FROM UserContactEntity WHERE user.id = :userId")
    UserContactEntity findContactByUserId(@Param("userId") Long userId);
}
