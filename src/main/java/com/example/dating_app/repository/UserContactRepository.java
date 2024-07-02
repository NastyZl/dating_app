package com.example.dating_app.repository;

import com.example.dating_app.entity.UserContactEntity;
import com.example.dating_app.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContactRepository extends JpaRepository<UserContactEntity, Long> {

}
