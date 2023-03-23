package com.example.liquidityProvider.services.impl;

import com.example.liquidityProvider.dtos.RequestDto;
import com.example.liquidityProvider.enums.FXName;
import com.example.liquidityProvider.enums.RequestStatus;
import com.example.liquidityProvider.models.PurchaseRequest;
import com.example.liquidityProvider.models.Trader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;

@ExtendWith(MockitoExtension.class)
class RequestMapperImplTest {

    @InjectMocks
    private  RequestMapperImpl requestMapper;

    private final Trader trader = Trader.builder().name("Aikins Dwamena")
            .email("aikins.dwamena@turntabl.io")
            .build();
    private final RequestDto requestDto = RequestDto.builder().requestTime(LocalDateTime.of(1998, Month.JULY,11,0,0))
            .providerName("Nazdaq")
            .bankAccountNo("12345678")
            .status(RequestStatus.PENDING)
            .amountBeingPurchased(6000.0)
            .currency(FXName.CEDI)
            .build();
    private final PurchaseRequest purchaseRequest = PurchaseRequest.builder()
            .buyer(trader)
            .fxName(FXName.CEDI)
            .tradersBankAccount("12345678")
            .requestStatus(RequestStatus.PENDING)
            .requestDate(LocalDateTime.of(1998, Month.JULY,11,0,0))
            .requestAmount(6000.0)
            .providerName("Nazdaq")
            .build();


    @Test
    void requestDtoToPurchaseRequest_givenRequestDtoShouldReturnPurchaseRequest(){


        Assertions.assertEquals(purchaseRequest.getBuyer(),requestMapper.requestDtoToRequest(requestDto,trader).getBuyer());
        Assertions.assertEquals(purchaseRequest.getRequestAmount(),requestMapper.requestDtoToRequest(requestDto,trader).getRequestAmount());
        Assertions.assertEquals(purchaseRequest.getRequestDate(),requestMapper.requestDtoToRequest(requestDto,trader).getRequestDate());

    }


}