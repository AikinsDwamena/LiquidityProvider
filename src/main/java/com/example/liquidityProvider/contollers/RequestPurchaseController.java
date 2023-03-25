package com.example.liquidityProvider.contollers;

import com.example.liquidityProvider.dtos.RequestDto;
import com.example.liquidityProvider.exceptions.ResourceNotFoundException;
import com.example.liquidityProvider.models.PurchaseRequest;
import com.example.liquidityProvider.services.PurchaseRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RequestPurchaseController {

    private final PurchaseRequestService purchaseRequestService;

    @PostMapping("fx")
    public ResponseEntity<String> makeRequest(@RequestBody RequestDto requestDto, Authentication authentication) throws ResourceNotFoundException {
        return ResponseEntity.ok(purchaseRequestService.makeRequest(requestDto, authentication));
    }

    @GetMapping("fx")
    public ResponseEntity<List<PurchaseRequest>> getAllRequest( Authentication authentication) throws ResourceNotFoundException {
        return ResponseEntity.ok(purchaseRequestService.getAllRequest(authentication));
    }
}
