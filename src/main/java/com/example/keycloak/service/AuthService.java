package com.example.keycloak.service;

import com.example.keycloak.dto.auth.ReqLoginDTO;
import com.example.keycloak.dto.auth.ResLoginDTO;

public interface AuthService {
    ResLoginDTO login(ReqLoginDTO reqLoginDTO);
}
