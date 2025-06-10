package com.example.keycloak.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class BaseResponse<T> {
    private int statusCode;
    private  String message;
    private T data;
}
