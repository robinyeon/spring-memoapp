package com.hobom.memoapp.user.controller;

import com.hobom.memoapp.url.Urls;
import com.hobom.memoapp.user.dto.UserDto;
import com.hobom.memoapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Urls.UserUrl.BASE_URL)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto.Response createOneUser(@RequestBody UserDto.Request userCreateRequestDto) {
        return userService.createOneUser(userCreateRequestDto);
    }

    @GetMapping(Urls.ID_PARAM)
    public UserDto.Response getOneUser(@PathVariable Long id) {
        return userService.getOneUser(id);
    }

    @GetMapping
    public List<UserDto.Response> getAllUser() {
        return userService.getAllUser();
    }

    @PatchMapping(Urls.ID_PARAM)
    public UserDto.Response updateOneUser(@PathVariable Long id, @RequestBody UserDto.Request userUpdateRequestDto) {
        return userService.updateOneUser(id, userUpdateRequestDto);
    }

    @DeleteMapping(Urls.ID_PARAM)
    public UserDto.Response removeOneUser(@PathVariable Long id) {
        return userService.removeOneUser(id);
    }
}
