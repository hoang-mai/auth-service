package com.example.keycloak.controller;

import com.example.keycloak.component.MessageService;
import com.example.keycloak.dto.auth.ReqLoginDTO;
import com.example.keycloak.dto.auth.ResLoginDTO;
import com.example.keycloak.service.AuthService;
import com.example.keycloak.util.BaseResponse;
import com.example.keycloak.util.Constant;
import com.example.keycloak.util.MessageSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(Constant.AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final MessageService messageService;

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<ResLoginDTO>> login(@RequestBody ReqLoginDTO reqLoginDTO) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(BaseResponse
                        .<ResLoginDTO>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message(messageService.getMessage(MessageSuccess.LOGIN_SUCCESS))
                        .data(authService.login(reqLoginDTO))
                        .build());
    }
}
