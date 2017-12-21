package com.services.servicesImpl;

import com.model.UserLoginForm;
import com.config.security.token.TokenAuthentication;
import com.config.security.token.TokenUtils;
import com.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class AuthenicationServiceImpl implements AuthenticationService {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenicationServiceImpl.class);

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public boolean authenticationUser(UserLoginForm userLoginForm) {
        String login = userLoginForm.getLogin();
        String password = userLoginForm.getPassword();

        if (login != null && password != null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(login);
                if (userDetails != null && userDetails.getUsername().equals(login) && userDetails.getPassword().equals(password)) {
                    String token = TokenUtils.createToken(userDetails);

                    TokenAuthentication authentication = new TokenAuthentication(userDetails, null, userDetails.getAuthorities());
                    authentication.setToken(token);

                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    LOG.info("Create token: " + token);
                    return true;
                }
            }

        return false;
    }
}
