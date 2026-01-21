package com.university.auth;

import com.university.models.User;

/**
 * Centralized role-based access control.
 * Demonstrates ABSTRACTION - permissions are defined here.
 *
 * TODO: Move action names to an enum or constants if the team prefers.
 * TODO: Consider per-course or per-resource checks (ownership, instructor-of-record).
 */
public class AccessControl {

    /**
     * Check if a user can perform a given action.
     *
     * @param user   The user to check
     * @param action The action (e.g., "ENROLL_STUDENT", "ASSIGN_GRADE")
     * @return true if allowed, false otherwise
     */
    public static boolean allows(User user, String action) {
        if (user == null || user.getRole() == null || action == null) return false;

        String role = user.getRole().toUpperCase();

        switch (role) {
            case "STUDENT":
                return action.equalsIgnoreCase("ENROLL_STUDENT")
                    || action.equalsIgnoreCase("DROP_COURSE")
                    || action.equalsIgnoreCase("VIEW_GRADES")
                    || action.equalsIgnoreCase("VIEW_TRANSCRIPT");

            case "INSTRUCTOR":
                return action.equalsIgnoreCase("ASSIGN_GRADE")
                    || action.equalsIgnoreCase("MANAGE_COURSES")
                    || action.equalsIgnoreCase("GENERATE_REPORTS");

            case "ADMIN":
                // Admins have full access for now.
                // TODO: If needed, restrict certain actions or add audit requirements.
                return true;

            default:
                return false;
        }
    }
}
