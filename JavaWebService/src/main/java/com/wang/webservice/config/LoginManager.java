package com.wang.webservice.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;

import java.util.Objects;

public class LoginManager {
    public static boolean authenticate(String id, String password) throws Exception{
        Objects.requireNonNull(id);
        Objects.requireNonNull(password);


        return true;
    }
}
