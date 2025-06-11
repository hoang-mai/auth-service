package com.example.keycloak.feign;

import com.example.keycloak.dto.keycloak.ResKeycloakTokenDTO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "keycloak-client", url = "${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
public interface KeyCloakFeignClient {

    @PostMapping(value = "/protocol/openid-connect/token",
            consumes = "application/x-www-form-urlencoded")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    ResKeycloakTokenDTO login(
            @RequestBody Map<String, String> formData
    );
}
