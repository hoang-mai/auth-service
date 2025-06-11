package com.example.keycloak.service.impl;

import com.example.keycloak.dto.auth.ReqLoginDTO;
import com.example.keycloak.dto.auth.ResLoginDTO;
import com.example.keycloak.dto.keycloak.ResKeycloakTokenDTO;
import com.example.keycloak.feign.KeyCloakFeignClient;
import com.example.keycloak.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final KeyCloakFeignClient keyCloakFeignClient;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    @Override
    public ResLoginDTO login(ReqLoginDTO reqLoginDTO) {
        Map<String, String> formData = new HashMap<>();
        formData.put("grant_type", "password");
        formData.put("client_id", reqLoginDTO.getClientId());
        formData.put("client_secret", clientSecret);
        formData.put("username", reqLoginDTO.getEmail());
        formData.put("password", reqLoginDTO.getPassword());

        ResKeycloakTokenDTO resKeycloakTokenDTO=keyCloakFeignClient.login(formData);

        return ResLoginDTO.builder()
                .accessToken(resKeycloakTokenDTO.getAccessToken())
                .refreshToken(resKeycloakTokenDTO.getRefreshToken())
                .expiresIn(resKeycloakTokenDTO.getExpiresIn())
                .tokenType(resKeycloakTokenDTO.getTokenType())
                .refreshExpiresIn(resKeycloakTokenDTO.getRefreshExpiresIn())
                .sessionState(resKeycloakTokenDTO.getSessionState())
                .scope(resKeycloakTokenDTO.getScope())
                .build();
    }
}
