package com.example.ldv.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityUtil {
    public static String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = "";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }
        return userName;
    }
}
