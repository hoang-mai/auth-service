package com.example.keycloak.service.impl;

import com.example.keycloak.dto.account.CreateAccountDTO;
import com.example.keycloak.entity.Account;
import com.example.keycloak.entity.AccountStatus;
import com.example.keycloak.exception.DuplicateException;
import com.example.keycloak.repository.AccountRepository;
import com.example.keycloak.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    /**
     * Tạo tài khoản mới.
     * @param createAccountDTO DTO chứa thông tin tài khoản mới
     * @throws DuplicateException nếu email đã tồn tại
     */
    @Override
    public void createAccount(CreateAccountDTO createAccountDTO) {
        boolean emailExists = accountRepository.existsByEmail(createAccountDTO.getEmail());
        if (emailExists) {
            throw new DuplicateException("Email already exists");
        }
        Account account = Account.builder()
                .email(createAccountDTO.getEmail())
                .password(createAccountDTO.getPassword())
                .role(createAccountDTO.getRole())
                .accountStatus(AccountStatus.ACTIVE)
                .build();
        accountRepository.save(account);
    }
}
