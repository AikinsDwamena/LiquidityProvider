package com.example.liquidityProvider.services.impl;

import com.example.liquidityProvider.dtos.CurrencyResponseDto;
import com.example.liquidityProvider.services.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Override
    public List<CurrencyResponseDto> getAllProviderCurrency(Long providerId) {
        return null;
    }
}
