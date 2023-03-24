package com.example.liquidityProvider.services;

import com.example.liquidityProvider.dtos.ProviderRequestDto;
import com.example.liquidityProvider.models.Provider;

import java.util.List;

public interface ProviderService {
    List<Provider> getAllProviders();

    String saveProvider(ProviderRequestDto providerRequestDto);

}
