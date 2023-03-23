package com.example.liquidityProvider.services;

import com.example.liquidityProvider.dtos.RequestDto;
import com.example.liquidityProvider.models.PurchaseRequest;
import com.example.liquidityProvider.models.Trader;

public interface RequestMapper {
    PurchaseRequest requestDtoToRequest(RequestDto requestDto, Trader trader);
}
