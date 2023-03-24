package com.example.liquidityProvider.services.impl;

import com.example.liquidityProvider.dtos.ProviderRequestDto;
import com.example.liquidityProvider.models.Currency;
import com.example.liquidityProvider.models.Provider;
import com.example.liquidityProvider.repsitories.CurrencyRepository;
import com.example.liquidityProvider.repsitories.ProviderRepository;
import com.example.liquidityProvider.services.ProviderMapper;
import com.example.liquidityProvider.services.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final CurrencyRepository currencyRepository;
    private final ProviderMapper providerMapper;

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public String saveProvider(ProviderRequestDto providerRequestDto) {
       Provider provider =  providerMapper.providerDtoToProvider(providerRequestDto);
        System.out.println(provider);
        Provider savedProvider =providerRepository.save(provider);
        List<Currency> currencies = providerRequestDto.currencies();
        List<Currency> newCurrencies = currencies.stream().map(currency -> new Currency(currency.getCurrencyName(),currency.getAmountAvailable(),currency.getRate(),savedProvider)).toList();

        currencyRepository.saveAll(newCurrencies);
        return "provider saved successfully";
    }
}
