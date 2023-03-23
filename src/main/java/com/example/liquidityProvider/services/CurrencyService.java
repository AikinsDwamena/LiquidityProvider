package com.example.liquidityProvider.services;

import com.example.liquidityProvider.dtos.CurrencyResponseDto;

import java.util.List;

public interface CurrencyService {
    List<CurrencyResponseDto> getAllProviderCurrency(Long providerId);
}
