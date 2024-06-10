package com.hobom.memoapp.user.service;

import com.hobom.memoapp.user.dto.UserDto;
import com.hobom.memoapp.user.entity.User;

import java.util.List;

public interface UserService {
    public UserDto.Response createOneUser(UserDto.Request userCreateRequestDto);

    public UserDto.Response getOneUser(Long id);

    public List<UserDto.Response> getAllUser();

    public UserDto.Response updateOneUser(Long id, UserDto.Request userUpdateRequestDto);

    public UserDto.Response removeOneUser(Long id);
}
