package com.example.liquidityProvider.services.impl;

import com.example.liquidityProvider.services.TokenAttributesExtractor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class TokenAttributesExtractorImpl implements TokenAttributesExtractor {
    public String extractEmailFromToken(Authentication authentication) {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        return (String) jwtAuthenticationToken.getTokenAttributes().get("email");
    }
}
