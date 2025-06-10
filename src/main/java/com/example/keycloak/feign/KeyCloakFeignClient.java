package com.example.keycloak.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "keycloak-client", url = "${keycloak.url}")
public interface KeyCloakFeignClient {

    @PostMapping("/protocol/openid-connect/token")

}
