package com.hobom.memoapp.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "deleted")
    private boolean deleted = false;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public void update(String nickname) {
        this.nickname = nickname;
    }
}
