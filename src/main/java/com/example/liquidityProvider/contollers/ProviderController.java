package com.example.liquidityProvider.contollers;


import com.example.liquidityProvider.dtos.ProviderResponseDto;
import com.example.liquidityProvider.services.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @GetMapping("providers")
    public ResponseEntity<List<ProviderResponseDto>> getAllProviders() {

        return ResponseEntity.ok(providerService.getAllProviders());
    }


}
