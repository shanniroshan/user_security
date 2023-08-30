package com.security.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.user.models.UserLoginDetails;
import com.security.user.security.services.UserLoginDetailsService;

@RestController
@RequestMapping("/api/login-details")
public class UserLoginDetailsController {

    @Autowired
    private UserLoginDetailsService userLoginDetailsService;

    @PostMapping
    public ResponseEntity<UserLoginDetails> saveUserLoginDetails(@RequestBody UserLoginDetails userLoginDetails) {
        UserLoginDetails savedDetails = userLoginDetailsService.saveUserLoginDetails(userLoginDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDetails);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserLoginDetails>> getUserLoginDetailsByUserId(@PathVariable Long userId) {
        List<UserLoginDetails> loginDetails = userLoginDetailsService.getUserLoginDetailsByUserId(userId);
        return ResponseEntity.ok(loginDetails);
    }

    // Other methods as needed
}