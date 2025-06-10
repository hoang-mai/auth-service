package com.example.keycloak.service.impl;

import com.example.keycloak.dto.auth.ReqLoginDTO;
import com.example.keycloak.dto.auth.ResLoginDTO;
import com.example.keycloak.service.AuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Value("${keycloak.login-url}")
    private String keycloakLoginUrl;

    @Override
    public ResLoginDTO login(ReqLoginDTO reqLoginDTO) {
        return null;
    }
}
