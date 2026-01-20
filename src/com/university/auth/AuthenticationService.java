package com.university.auth;

import com.university.models.User;
import com.university.services.UserManager;
import java.util.Optional;

/**
 * Service for user authentication and session management.
 * Demonstrates ENCAPSULATION - internal authentication logic is hidden.
 * 
 * TODO: Implement login, logout, and role-based access control.
 */
public class AuthenticationService {
    private User currentUser;
    private UserManager userManager;

    public AuthenticationService(UserManager userManager) {
        this.userManager = userManager;
        this.currentUser = null;
    }

    /**
     * Authenticate a user with username and password.
     * 
     * @param username The username
     * @param password The password
     * @return The authenticated user if successful, null otherwise
     */
    public User login(String username, String password) {
        Optional<User> userOpt = userManager.getUser(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // In a real system, we would hash the password
            if (user.getPassword().equals(password)) {
                this.currentUser = user;
                return user;
            }
        }
        return null;
    }

    /**
     * Log out the current user.
     */
    public void logout() {
        this.currentUser = null;
    }

    /**
     * Check if a user is currently logged in.
     * 
     * @return true if logged in, false otherwise
     */
    public boolean isLoggedIn() {
        return currentUser != null;
    }

    /**
     * Get the currently logged in user.
     * 
     * @return The current user, or null if not logged in
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Check if the current user has a specific role.
     * 
     * @param role The role to check (e.g., "ADMIN", "INSTRUCTOR", "STUDENT")
     * @return true if user has the role, false otherwise
     */
    public boolean hasRole(String role) {
        if (currentUser == null) {
            return false;
        }
        return currentUser.getRole().equalsIgnoreCase(role);
    }

    /**
     * Check if the current user can perform an action.
     * 
     * @param action The action to check (e.g., "ENROLL_STUDENT", "ASSIGN_GRADE")
     * @return true if user can perform the action, false otherwise
     */
    public boolean canPerformAction(String action) {
        if (!isLoggedIn()) {
            return false;
        }

        String role = currentUser.getRole().toUpperCase();

        // Delegating to AccessControl would be better, but implementing simple logic
        // here for now
        switch (action) {
            case "ENROLL_STUDENT":
                return role.equals("STUDENT") || role.equals("ADMIN");
            case "ASSIGN_GRADE":
                return role.equals("INSTRUCTOR") || role.equals("ADMIN");
            case "MANAGE_USERS":
                return role.equals("ADMIN");
            case "MANAGE_COURSES":
                return role.equals("ADMIN");
            case "VIEW_TRANSCRIPT":
                return true;
            case "GENERATE_REPORTS":
                return role.equals("ADMIN") || role.equals("INSTRUCTOR");
            default:
                return false;
        }
    }
}
