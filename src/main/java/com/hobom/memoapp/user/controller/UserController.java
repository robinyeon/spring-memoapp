package com.hobom.memoapp.user.controller;

import com.hobom.memoapp.dto.ApiResponse;
import com.hobom.memoapp.url.Urls;
import com.hobom.memoapp.user.dto.UserDto;
import com.hobom.memoapp.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Urls.UserUrl.BASE_URL)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserDto.Response>> createOneUser(@RequestBody @Valid UserDto.Request userCreateRequestDto) {
        UserDto.Response responseDto = userService.createOneUser(userCreateRequestDto);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, "유저 생성 성공", responseDto));
    }

    @GetMapping(Urls.ID_PARAM)
    public ResponseEntity<ApiResponse<UserDto.Response>> getOneUser(@PathVariable Long id) {
        UserDto.Response responseDto = userService.getOneUser(id);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, "유저 한명 조회 성공", responseDto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDto.Response>>> getAllUser() {
        List<UserDto.Response> responseDto = userService.getAllUser();
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, "유저 전체 조회 성공", responseDto));
    }

    @PatchMapping(Urls.ID_PARAM)
    public ResponseEntity<ApiResponse<UserDto.Response>> updateOneUser(@PathVariable Long id, @RequestBody @Valid UserDto.Request userUpdateRequestDto) {
        UserDto.Response responseDto = userService.updateOneUser(id, userUpdateRequestDto);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, "유저 수정 성공", responseDto));
    }

    @DeleteMapping(Urls.ID_PARAM)
    public ResponseEntity<ApiResponse<UserDto.Response>> removeOneUser(@PathVariable Long id) {
        UserDto.Response responseDto = userService.removeOneUser(id);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, "유저 삭제 성공", responseDto));
    }
}
