package com.mudit.piingouserservice.service;

import com.mudit.piingouserservice.dto.UserResponse;
import com.mudit.piingouserservice.entity.User;
import com.mudit.piingouserservice.exception.UserNotFoundException;
import com.mudit.piingouserservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getProfile(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(()-> new UserNotFoundException("User with username " + userName + " not found"));
        return UserResponse.from(user);
    }
}
