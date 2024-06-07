package com.hobom.memoapp.memo.dto;

import lombok.Getter;

@Getter
public class MemoCreateRequestDto {
    private String title;
    private String contents;
}
