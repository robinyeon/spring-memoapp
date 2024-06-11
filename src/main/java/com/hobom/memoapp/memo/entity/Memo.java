package com.hobom.memoapp.memo.entity;

import jakarta.persistence.*;
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
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    @Column(name = "deleted")
    private boolean deleted = false;

    public Memo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

//    public void update(String title, String contents) {
//        this.title = title;
//        this.contents = contents;
//    }
}
