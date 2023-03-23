package com.example.liquidityProvider.services;

import com.example.liquidityProvider.dtos.RequestDto;
import com.example.liquidityProvider.exceptions.ResourceNotFoundException;
import org.springframework.security.core.Authentication;

public interface PurchaseRequestService {
    String makeRequest(RequestDto  requestDto, Authentication authentication) throws ResourceNotFoundException;



}
