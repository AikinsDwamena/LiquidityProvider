package com.example.liquidityProvider.services.impl;

import com.example.liquidityProvider.dtos.RequestDto;
import com.example.liquidityProvider.enums.RequestStatus;
import com.example.liquidityProvider.exceptions.ResourceNotFoundException;
import com.example.liquidityProvider.models.PurchaseRequest;
import com.example.liquidityProvider.models.Trader;
import com.example.liquidityProvider.repsitories.PurchaseRequestRepository;
import com.example.liquidityProvider.repsitories.TraderRepository;
import com.example.liquidityProvider.services.PurchaseRequestService;
import com.example.liquidityProvider.services.RequestMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PurchaseRequestServiceImpl implements PurchaseRequestService {

    private final PurchaseRequestRepository purchaseRequestRepository;
    private final TraderRepository traderRepository;
    private final RequestMapper requestMapper;
    private final TokenAttributesExtractorImpl tokenAttributesExtractor;

    @Override
    public String makeRequest(RequestDto requestDto, Authentication authentication) throws ResourceNotFoundException {
        String userEmail = tokenAttributesExtractor.extractEmailFromToken(authentication);
        Trader requestOwner = traderRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User doesn't exist in Database"));
        PurchaseRequest purchaseRequest = requestMapper.requestDtoToRequest(requestDto, requestOwner);
        if(purchaseRequest.getRequestAmount() < 5){
            purchaseRequest.setRequestStatus(RequestStatus.CANCELLED);
            purchaseRequestRepository.save(purchaseRequest);
            return "request has been cancelled";
        }else if (purchaseRequest.getRequestAmount() == 10) {
            return "request is pending";
        }

        purchaseRequest.setRequestStatus(RequestStatus.FULFILLED);
        purchaseRequestRepository.save(purchaseRequest);
        return "request has been fulfilled";
    }

    @Override
    public List<PurchaseRequest> getAllRequest(Authentication authentication) {
        String userEmail = tokenAttributesExtractor.extractEmailFromToken(authentication);
        Trader owner = traderRepository.findByEmail(userEmail).orElseThrow(()->new RuntimeException("User isn't in database"));

        List<PurchaseRequest> requests = purchaseRequestRepository.findByBuyer(owner);
        System.out.println(requests);
        return requests;
//                .orElseThrow(()->new RuntimeException("User has no requests"));
    }
}
