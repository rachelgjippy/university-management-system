package com.university.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Admin user in the system.
 */
public class Admin extends User {
    private String adminId;
    private String department;
    private List<String> permissions;

    public Admin(String userId, String username, String password, String email,
            String fullName, String adminId, String department) {
        super(userId, username, password, email, fullName);
        this.adminId = adminId;
        this.department = department;
        this.permissions = new ArrayList<>();
        // Default permissions
        permissions.add("MANAGE_USERS");
        permissions.add("MANAGE_COURSES");
        permissions.add("VIEW_ALL_REPORTS");
        permissions.add("SYSTEM_CONFIG");
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getPermissions() {
        return new ArrayList<>(permissions);
    }

    public void addPermission(String permission) {
        if (!permissions.contains(permission)) {
            permissions.add(permission);
        }
    }

    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========== ADMIN INFORMATION ==========");
        System.out.println("Admin ID: " + adminId);
        System.out.println("Name: " + getFullName());
        System.out.println("Email: " + getEmail());
        System.out.println("Department: " + department);
        System.out.println("Permissions: " + permissions.toString());
        System.out.println("=======================================\n");
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }
}
