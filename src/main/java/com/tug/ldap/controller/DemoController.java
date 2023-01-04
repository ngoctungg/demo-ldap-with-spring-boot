package com.tug.ldap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class DemoController {

    @Autowired
    LdapTemplate ldapTemplate;

    @PostMapping("/login")
    public ResponseEntity<AuthDto> handleLogin(@RequestBody AuthDto authDto){
        String base = "uid="+authDto.getUsername();
        boolean authenticate = ldapTemplate.authenticate("", base, authDto.getPassword());
        authDto.setIsAuth(authenticate);
        return ResponseEntity.ok(authDto);
    }


}
