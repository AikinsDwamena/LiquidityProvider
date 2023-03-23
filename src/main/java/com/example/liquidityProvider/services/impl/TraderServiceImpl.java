package com.example.liquidityProvider.services.impl;

import com.example.liquidityProvider.models.Trader;
import com.example.liquidityProvider.repsitories.TraderRepository;
import com.example.liquidityProvider.services.TraderService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TraderServiceImpl implements TraderService {
    private final TraderRepository traderRepository;
    @Override
    public String authenticate(Authentication authentication) {
        JwtAuthenticationToken auth = (JwtAuthenticationToken) authentication;
        Map<String, Object> claims = auth.getTokenAttributes();
        String email = (String) claims.get("email");

        String name = (String) claims.get("name");
        String profilePhoto = (String) claims.get("picture");
        Trader trader = Trader.builder().name(name).email(email).build();

        Optional<Trader> targetTrader = traderRepository.findByEmail(email);

        if (targetTrader.isEmpty() )
            traderRepository.save(trader);

        return "Login is successful";

    }
}
