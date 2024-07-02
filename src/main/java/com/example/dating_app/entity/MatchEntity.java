package com.example.dating_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "match")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "first_user", nullable = false)
    private UserEntity firstUser;

    @ManyToOne
    @JoinColumn(name = "second_user", nullable = false)
    private UserEntity secondUser;
}