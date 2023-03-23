package com.example.liquidityProvider.services;

import com.example.liquidityProvider.dtos.ProviderResponseDto;

import java.util.List;

public interface ProviderService {
    List<ProviderResponseDto> getAllProviders();

}
