package com.example.liquidityProvider.services.impl;

import com.example.liquidityProvider.dtos.RequestDto;
import com.example.liquidityProvider.models.PurchaseRequest;
import com.example.liquidityProvider.models.Trader;
import com.example.liquidityProvider.services.RequestMapper;
import org.springframework.stereotype.Service;

@Service
public class RequestMapperImpl implements RequestMapper {


    @Override
    public PurchaseRequest requestDtoToRequest(RequestDto requestDto, Trader trader) {


        return PurchaseRequest.builder().requestAmount(requestDto.amountBeingPurchased())
                .requestDate(requestDto.requestTime())
                .requestStatus(requestDto.status())
                .buyer(trader)
                .fxName(requestDto.currency())
                .tradersBankAccount(requestDto.bankAccountNo())
                .providerName(requestDto.providerName()).build();
    }
}
