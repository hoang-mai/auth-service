package com.example.keycloak.dto.account;

import com.example.keycloak.entity.Role;
import lombok.Getter;

@Getter
public class CreateAccountDTO {

    private String email;
    private String password;
    private Role role;
}
