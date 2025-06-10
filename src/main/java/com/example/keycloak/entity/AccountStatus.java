package com.example.keycloak.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountStatus {

    ACTIVE(1L,"active"),
    BAN(2L, "ban"),
    GRADUATED(3L,"graduated");

    private final Long statusId;

    private final String status;
}
