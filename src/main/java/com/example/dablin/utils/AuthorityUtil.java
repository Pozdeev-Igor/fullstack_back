package com.example.dablin.utils;

import com.example.dablin.domain.User;

public class AuthorityUtil {
    public static Boolean hasRole(String role, User user) {
        return user.getAuthorities()
                   .stream()
                   .filter(auth -> auth.getAuthority().equals(role))
                   .count() > 0;
    }
}
