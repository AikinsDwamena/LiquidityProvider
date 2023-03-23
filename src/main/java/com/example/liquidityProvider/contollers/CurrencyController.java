package com.example.liquidityProvider.contollers;


import com.example.liquidityProvider.dtos.CurrencyResponseDto;
import com.example.liquidityProvider.models.Currency;
import com.example.liquidityProvider.services.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("{provider}/currencies")
    public ResponseEntity<List<CurrencyResponseDto>>  getAllProviderCurrencies(@PathVariable Long providerId) {
        return ResponseEntity.ok(currencyService.getAllProviderCurrency(providerId));
    }
}
