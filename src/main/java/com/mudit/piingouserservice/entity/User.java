package com.mudit.piingouserservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "azure_subject")
    private String azureSubject;

    @Column(name="email")
    private String email;

    @Column(name="email_verified")
    private boolean emailVerified;

    @Column(name="username")
    private String username;

    @Column(name="display_name")
    private String displayName;

    @Column(name="bio")
    private String bio;

    @Column(name="avatar_url")
    private String avatarUrl;

    @Column(name="profile_complete")
    private boolean profileComplete;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="created_at")
    private OffsetDateTime createdAt;

    @Column(name="updated_at")
    private OffsetDateTime updatedAt;
}
