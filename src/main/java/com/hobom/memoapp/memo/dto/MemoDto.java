package com.hobom.memoapp.memo.dto;

import com.hobom.memoapp.memo.entity.Memo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemoDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;

        private String title;

        private String contents;

        private boolean deleted;

        public static Response from(Memo memo) {
            return new Response(memo.getId(), memo.getTitle(), memo.getContents(), memo.isDeleted());
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotEmpty(message = "Memo title required.")
        private String title;

        @NotEmpty(message = "Memo contents required.")
        private String contents;

        public Memo toEntity() {
            return new Memo(title, contents);
        }
    }
}
