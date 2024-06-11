package com.hobom.memoapp.memo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "memo")
@Getter
@Setter
@NoArgsConstructor
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "title", nullable = false, length = 25)
    private String title;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    public Memo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
