package com.security.user.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.user.models.UserLoginDetails;
import com.security.user.repositories.UserLoginDetailsRepository;

@Service
public class UserLoginDetailsService {

    @Autowired
    private UserLoginDetailsRepository userLoginDetailsRepository;

    public UserLoginDetails saveUserLoginDetails(UserLoginDetails userLoginDetails) {
        return userLoginDetailsRepository.save(userLoginDetails);
    }

    public List<UserLoginDetails> getUserLoginDetailsByUserId(Long userId) {
        return userLoginDetailsRepository.findByUserId(userId);
    }

   
}
