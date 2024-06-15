package com.hobom.memoapp.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "nickname", nullable = false, length = 25)
    private String nickname;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    public User(String nickname) {
        this.nickname = nickname;
    }
}
