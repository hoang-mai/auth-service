package com.example.keycloak.controller;

import com.example.keycloak.component.MessageService;
import com.example.keycloak.dto.account.CreateAccountDTO;
import com.example.keycloak.service.AccountService;
import com.example.keycloak.util.BaseResponse;
import com.example.keycloak.util.Constant;
import com.example.keycloak.util.MessageSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(Constant.ACCOUNT)
@RequiredArgsConstructor
public class AccountController {

    private final MessageService messageService;
    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<Void>> createAccount(@RequestBody CreateAccountDTO createAccountDTO) {
        accountService.createAccount(createAccountDTO);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponse
                        .<Void>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message(messageService.getMessage(MessageSuccess.ACCOUNT_CREATED_SUCCESS))
                        .build());
    }
}
