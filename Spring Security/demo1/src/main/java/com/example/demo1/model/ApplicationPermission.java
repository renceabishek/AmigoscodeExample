package com.example.demo1.model;

public enum ApplicationPermission {
    MANAGEMENT_READ("management:read"),
    MANAGEMENT_WRITE("management:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private String permission;

    ApplicationPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
