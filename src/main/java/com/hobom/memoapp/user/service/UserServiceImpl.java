package com.hobom.memoapp.user.service;

import com.hobom.memoapp.user.dto.UserDto;
import com.hobom.memoapp.user.entity.User;
import com.hobom.memoapp.user.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDto.Response createOneUser(UserDto.Request userCreateRequestDto) {
        isNicknameValid(userCreateRequestDto.getNickname());

        User createdUser = userRepository.save(userCreateRequestDto.toEntity());

        return UserDto.Response.from(createdUser);
    }

    @Override
    @Transactional
    public UserDto.Response getOneUser(Long id) {
        User foundUser = getOneUserById(id);

        return UserDto.Response.from(foundUser);
    }

    @Override
    @Transactional
    public List<UserDto.Response> getAllUser() {
        List<User> users = userRepository.findAll();

        return users.stream().map(UserDto.Response::from).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDto.Response updateOneUser(Long id, UserDto.Request userUpdateRequestDto) {
        User foundUser = getOneUserById(id);

        isNicknameValid(userUpdateRequestDto.getNickname());

        foundUser.setNickname(userUpdateRequestDto.getNickname());

        return UserDto.Response.from(foundUser);
    }

    @Override
    @Transactional
    public UserDto.Response removeOneUser(Long id) {
        User foundUser = getOneUserById(id);

        foundUser.setDeleted(true);

        return UserDto.Response.from(userRepository.save(foundUser));
    }

    private User getOneUserById(Long id) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (foundUser.isDeleted()) {
            throw new IllegalStateException("User has been already deleted");
        }

        return foundUser;
    }

    private void isNicknameValid(String nickname) {
        userRepository.findByNickname(nickname).orElseThrow(() -> new EntityExistsException("Same nickname already exists"));
    }
}
