package com.hobom.memoapp.memo.dto;

import lombok.Getter;

@Getter
public class MemoUpdateRequestDto {
    private String title;
    private String contents;
}
