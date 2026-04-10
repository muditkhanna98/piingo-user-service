package com.mudit.piingouserservice.service;

import com.mudit.piingouserservice.dto.UserResponse;
import com.mudit.piingouserservice.entity.User;
import com.mudit.piingouserservice.exception.UserNotFoundException;
import com.mudit.piingouserservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getProfile(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(()-> new UserNotFoundException("User with username " + userName + " not found"));
        return UserResponse.from(user);
    }

    public void validateUsersExist(List<UUID> userIds) {
        Set<UUID> foundIds = userRepository.findAllById(userIds)
                .stream()
                .map(User::getId)
                .collect(Collectors.toSet());

        List<UUID> missing = userIds.stream()
                .filter(id -> !foundIds.contains(id))
                .toList();

        if (!missing.isEmpty()) {
            throw new UserNotFoundException("Users not found with ids: " + missing);
        }
    }

}
