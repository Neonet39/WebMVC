package com.services;

import com.model.UserLoginForm;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService  {
    public boolean authenticationUser(UserLoginForm userLoginForm);
}
