package com.example.liquidityProvider.services;

import com.example.liquidityProvider.dtos.ProviderRequestDto;
import com.example.liquidityProvider.models.Provider;

public interface ProviderMapper {
    Provider providerDtoToProvider(ProviderRequestDto providerRequestDto);
}
