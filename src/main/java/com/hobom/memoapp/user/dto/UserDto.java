package com.hobom.memoapp.user.dto;

import com.hobom.memoapp.user.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;

        private String nickname;

        private boolean deleted;

        public static Response from(User user) {
            return new Response(user.getId(), user.getNickname(), user.isDeleted());
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @NotEmpty(message = "User nickname required.")
        private String nickname;

        public User toEntity() {
            return new User(nickname);
        }
    }
}
