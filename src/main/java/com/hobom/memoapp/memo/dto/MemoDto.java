package com.hobom.memoapp.memo.dto;

import com.hobom.memoapp.memo.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class MemoDto {

    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Memo memo;

        public static Response from(Memo memo) {
            return new Response(memo);
        }
    }


    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private Memo memo;

        public Memo toEntity() {
            return new Memo(memo.getTitle(), memo.getContents());
        }
    }
}
