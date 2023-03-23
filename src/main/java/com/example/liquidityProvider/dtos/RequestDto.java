package com.example.liquidityProvider.dtos;

import com.example.liquidityProvider.enums.FXName;
import com.example.liquidityProvider.enums.RequestStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record RequestDto(String providerName, FXName currency, Double amountBeingPurchased, LocalDateTime requestTime, RequestStatus status, String bankAccountNo) {
}
