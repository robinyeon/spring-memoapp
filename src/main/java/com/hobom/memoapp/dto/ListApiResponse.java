package com.hobom.memoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListApiResponse<T> {
    private int statusCode;
    private String message;
    private List<T> data;

    public static <T> ListApiResponse<T> of(HttpStatus status, String message, List<T> data) {
        return new ListApiResponse<>(status.value(), message, data);
    }
}
