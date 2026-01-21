package com.university.auth;

import com.university.models.User;
import java.time.LocalDateTime;
import java.time.Duration;

/**
 * Represents a user session with timeout tracking.
 * Demonstrates ENCAPSULATION - session details are hidden from external classes.
 *
 * TODO: Decide on absolute vs. sliding timeout policy (refresh on activity).
 * TODO: Consider persisting sessions if the team adds multi-process support.
 */
public class Session {
    private final User user;
    private LocalDateTime loginTime;
    private final int timeoutMinutes;

    // Default constructor with 30-minute timeout (adjust if the team prefers).
    public Session(User user) {
        this(user, 30);
    }

    public Session(User user, int timeoutMinutes) {
        this.user = user;
        this.loginTime = LocalDateTime.now();
        this.timeoutMinutes = timeoutMinutes;
    }

    /**
     * Returns true if the session is still valid based on timeout.
     */
    public boolean isActive() {
        if (loginTime == null) return false;
        Duration elapsed = Duration.between(loginTime, LocalDateTime.now());
        return elapsed.toMinutes() < timeoutMinutes;
    }

    /**
     * Refreshes the session start time (sliding timeout).
     * Call this on meaningful user activity if the team adopts sliding sessions.
     */
    public void refresh() {
        this.loginTime = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public int getTimeoutMinutes() {
        return timeoutMinutes;
    }
}
