package com.example.keycloak.dto.auth;

import lombok.Getter;

@Getter
public class ReqLoginDTO {
    private String email;
    private String password;
    private String clientId;

}
