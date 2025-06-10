package com.example.keycloak.controller;

import com.example.keycloak.dto.auth.ReqLoginDTO;
import com.example.keycloak.dto.auth.ResLoginDTO;
import com.example.keycloak.service.AuthService;
import com.example.keycloak.util.BaseResponse;
import com.example.keycloak.util.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = Constant.AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<ResLoginDTO>> login(@RequestBody ReqLoginDTO reqLoginDTO) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(BaseResponse
                        .<ResLoginDTO>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Login successful")
                        .data(authService.login(reqLoginDTO))
                        .build());
    }
}
