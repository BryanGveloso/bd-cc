package com.example.loginauthapi.infra.security;


import com.example.loginauthapi.Services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

public class ResetPassword {
    @GetMapping("/forgot-password")
    public ResponseEntity<String> fotgotPassword(@RequestParam String email){
        return new ResponseEntity<>(UserServices.forgotPassword(email), HttpStatus.OK);
    }
    @PutMapping("/set-password")
    public ResponseEntity<String> setPassword(@RequestParam String email, @RequestHeader String newPassword){
        return new ResponseEntity<>(UserServices.setPassword(email, newPassword), HttpStatus.OK);
    }
}