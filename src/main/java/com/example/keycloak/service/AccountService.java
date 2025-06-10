package com.example.keycloak.service;

import com.example.keycloak.dto.account.CreateAccountDTO;

public interface AccountService {
    void createAccount(CreateAccountDTO createAccountDTO);
}
