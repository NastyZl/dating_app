package com.example.dating_app.repository;

import com.example.dating_app.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
    Optional<TestEntity> findById(Long id);
}
