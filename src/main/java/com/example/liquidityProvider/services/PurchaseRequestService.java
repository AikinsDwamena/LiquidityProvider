package com.example.liquidityProvider.services;

import com.example.liquidityProvider.dtos.RequestDto;
import com.example.liquidityProvider.exceptions.ResourceNotFoundException;
import com.example.liquidityProvider.models.PurchaseRequest;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface PurchaseRequestService {
    String makeRequest(RequestDto  requestDto, Authentication authentication) throws ResourceNotFoundException;

    List<PurchaseRequest> getAllRequest(Authentication authentication);


}
