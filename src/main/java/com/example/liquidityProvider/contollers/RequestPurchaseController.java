package com.example.liquidityProvider.contollers;

import com.example.liquidityProvider.dtos.RequestDto;
import com.example.liquidityProvider.services.RequestPurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RequestPurchaseController {

    private final RequestPurchaseService requestPurchaseService;

    @PostMapping("fx")
    public ResponseEntity<String> makeRequest(@RequestBody RequestDto requestDto){
        requestPurchaseService.makeRequest(requestDto);
        return ResponseEntity.ok(requestPurchaseService.makeRequest(requestDto));
    }
}
