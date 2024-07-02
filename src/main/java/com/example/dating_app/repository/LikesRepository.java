package com.example.dating_app.repository;

import com.example.dating_app.entity.LikesEntity;
import com.example.dating_app.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<LikesEntity, Long> {
    @Override
    Optional<LikesEntity> findById(Long user_id);

    @Query(value = "SELECT EXISTS(SELECT 1 FROM likes WHERE liked_user_id = ?1 AND user_id = ?2)", nativeQuery = true)
    boolean checkIfUserIdExistsInLikedUserIdWithUser(Long userId, Long secondUserId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Likes WHERE liked_user_id = ?1 AND user_id = ?2", nativeQuery = true)
    void deleteLike(Long firstUserId, Long secondUserId);
}
