package com.example.dating_app.repository;

import com.example.dating_app.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    @Override
    Optional<UserProfileEntity> findById(Long user_id);

    @Query("select u from UserProfileEntity u where u.userId.id=:id")
    Optional<UserProfileEntity> findUserProfileByUserId(@Param("id") Long id);

    @Query(value = "SELECT MAX(id) FROM user_profiles", nativeQuery = true)
    Long getMaxUserId();

    @Query(value = "SELECT user_profiles.id FROM user_profiles JOIN users ON user_profiles.user_id = users.id WHERE users.login = ?1", nativeQuery = true)
    Long findUserProfileIdByLogin(String login);

}
