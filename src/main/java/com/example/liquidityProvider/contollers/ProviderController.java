package com.example.liquidityProvider.contollers;


import com.example.liquidityProvider.dtos.ProviderRequestDto;
import com.example.liquidityProvider.models.Provider;
import com.example.liquidityProvider.services.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @GetMapping("providers")
    public ResponseEntity<List<Provider>> getAllProviders() {

        return ResponseEntity.ok(providerService.getAllProviders());
    }

    @PostMapping("providers")
    public ResponseEntity<String> saveProvider(@RequestBody ProviderRequestDto providerRequestDto) {

        return ResponseEntity.ok(providerService.saveProvider(providerRequestDto));
    }


}
