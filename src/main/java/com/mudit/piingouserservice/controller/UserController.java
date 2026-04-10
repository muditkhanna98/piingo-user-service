package com.mudit.piingouserservice.controller;

import com.mudit.piingouserservice.dto.UserResponse;
import com.mudit.piingouserservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "User profile APIs")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    @Operation(summary = "Get user profile", description = "Returns the profile for the requested username.")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable String username) {
        return ResponseEntity.ok(userService.getProfile(username));
    }

    @PostMapping("/validate")
    @Operation(summary = "Validate users exist", description = "Validates that all provided user IDs exist.")
    public ResponseEntity<Void> validateUsers(@RequestBody List<UUID> userIds) {
        userService.validateUsersExist(userIds);
        return ResponseEntity.ok().build();
    }

}