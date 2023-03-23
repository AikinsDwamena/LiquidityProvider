package com.example.liquidityProvider.services;

import org.springframework.security.core.Authentication;

public interface TokenAttributesExtractor {
    String extractEmailFromToken (Authentication authentication);
}
