package com.example.dating_app.repository;

import com.example.dating_app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByLogin(String login);

    Boolean existsByLogin(String login);
}
