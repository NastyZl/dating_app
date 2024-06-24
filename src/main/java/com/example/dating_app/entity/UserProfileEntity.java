package com.example.dating_app.entity;

import com.example.dating_app.enums.ZodiacSign;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_profiles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
    private UserEntity userId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "photo", columnDefinition = "TEXT")
    private String photo;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "height")
    private Integer height;

    @Enumerated(EnumType.STRING)
    @Column(name = "zodiac_sign", length = 20)
    private ZodiacSign zodiacSign;
}
