package com.example.liquidityProvider.services.impl;

import com.example.liquidityProvider.dtos.ProviderRequestDto;
import com.example.liquidityProvider.models.Provider;
import com.example.liquidityProvider.services.ProviderMapper;
import org.springframework.stereotype.Service;

@Service
public class ProviderMapperImpl implements ProviderMapper {
    @Override
    public Provider providerDtoToProvider(ProviderRequestDto providerRequestDto) {
        return Provider.builder()
                .providerName(providerRequestDto.providerName())
                .build();
    }
}
