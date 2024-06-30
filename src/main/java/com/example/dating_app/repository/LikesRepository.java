package com.example.dating_app.repository;

import com.example.dating_app.entity.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<LikesEntity, Long> {
    @Override
    Optional<LikesEntity> findById(Long user_id);

    @Query(value = "SELECT EXISTS(SELECT 1 FROM likes WHERE liked_user_id = :userId AND user_id = :secondUserId)", nativeQuery = true)
    boolean checkIfUserIdExistsInLikedUserIdWithUser(Long userId, Long secondUserId);

    @Query(value = "DELETE FROM Likes WHERE liked_user_id = :first_id AND user_id = :second_id", nativeQuery = true)
    void deleteByLikedUserIdAndUserId(Long first_id, Long second_id);

    @Query(value = "INSERT INTO Likes (liked_user_id, user_id) VALUES (:second_user_id, :first_user_id)", nativeQuery = true)
    void createLike(Long first_user_id, Long second_user_id);

}
