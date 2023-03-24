package com.example.liquidityProvider.dtos;

import com.example.liquidityProvider.models.Currency;

import java.util.List;

public record ProviderRequestDto(String providerName, List<Currency> currencies) {
}
