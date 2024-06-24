package com.example.dating_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user_contacts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "telegram", length = 50)
    @Pattern(regexp = "@.*")
    private String telegram;

    @Column(name = "phone_number", length = 11)
    @Pattern(regexp = "^[0-9]{11}$")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
    private UserEntity user;
}
