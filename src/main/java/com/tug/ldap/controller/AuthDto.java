package com.tug.ldap.controller;


import lombok.Data;

@Data
public class AuthDto {

    private String username;
    private String password;
    private Boolean isAuth;
}
