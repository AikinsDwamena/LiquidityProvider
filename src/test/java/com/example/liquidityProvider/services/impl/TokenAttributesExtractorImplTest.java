package com.example.liquidityProvider.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.time.Instant;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class TokenAttributesExtractorImplTest {
    @InjectMocks
    private TokenAttributesExtractorImpl tokenAttributesExtractor;
    private JwtAuthenticationToken jwtAuthenticationToken;

    @BeforeEach
    void setup() {
        String tokenValue = "token";
        String email = "test@gmail.com";
        String picture = "xxxxxx";
        String given_name = "Emma";
        String family_name = "tk";
        Instant issuedAt = Instant.now();
        Instant expiredAt = Instant.now().plusSeconds(100000);
        Map<String, Object> headers = Map.of("aud", "aud");
        Map<String, Object> claims = Map.of("email", email, "picture", picture, "given_name", given_name, "family_name", family_name);
        Jwt jwt = new Jwt(tokenValue, issuedAt, expiredAt, headers, claims);

        jwtAuthenticationToken = new JwtAuthenticationToken(jwt);
    }

    @Test
    void testThat_extractEmailFromToken_returnsTheEmailFromTheToken() {
        String expectedEmail = "test@gmail.com";
        String actualEmail = tokenAttributesExtractor.extractEmailFromToken(jwtAuthenticationToken);
        Assertions.assertEquals(expectedEmail, actualEmail);
    }


}