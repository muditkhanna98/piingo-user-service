CREATE TABLE users (
    id               UUID         PRIMARY KEY,
    azure_subject    VARCHAR(255) NOT NULL UNIQUE,
    email            VARCHAR(255) UNIQUE,
    email_verified   BOOLEAN     NOT NULL DEFAULT FALSE,
    username         VARCHAR(50)  UNIQUE,
    display_name     VARCHAR(100),
    bio              TEXT,
    avatar_url       VARCHAR(500),
    profile_complete BOOLEAN     NOT NULL DEFAULT FALSE,
    is_active        BOOLEAN     NOT NULL DEFAULT TRUE,
    created_at       TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at       TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    last_login_at    TIMESTAMPTZ
);

CREATE INDEX idx_users_azure_subject ON users (azure_subject);
CREATE INDEX idx_users_username ON users (username) WHERE username IS NOT NULL;

-- Sample users (profile_complete = true so they can start conversations)
INSERT INTO users (id, azure_subject, email, email_verified, username, display_name, bio, profile_complete)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'sample-subject-alice', 'alice@example.com', TRUE, 'alice',   'Alice',   'Hey there!',        TRUE),
    ('22222222-2222-2222-2222-222222222222', 'sample-subject-bob',   'bob@example.com',   TRUE, 'bob',     'Bob',     'Available to chat', TRUE),
    ('33333333-3333-3333-3333-333333333333', 'sample-subject-carol', 'carol@example.com', TRUE, 'carol',   'Carol',   NULL,                TRUE);
