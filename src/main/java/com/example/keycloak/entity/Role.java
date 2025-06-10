package com.example.keycloak.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Role {
    ADMIN(1L, "admin"),
    PRINCIPAL(2L, "principal"),
    TEACHER(3L, "teacher"),
    STUDENT(4L, "student");

    private final Long roleId;
    private final String role;
}
