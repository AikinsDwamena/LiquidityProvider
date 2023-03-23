package com.example.liquidityProvider.services.impl;

import com.example.liquidityProvider.dtos.RequestDto;
import com.example.liquidityProvider.enums.FXName;
import com.example.liquidityProvider.enums.RequestStatus;
import com.example.liquidityProvider.exceptions.ResourceNotFoundException;
import com.example.liquidityProvider.models.PurchaseRequest;
import com.example.liquidityProvider.models.Trader;
import com.example.liquidityProvider.repsitories.PurchaseRequestRepository;
import com.example.liquidityProvider.repsitories.TraderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PurchaseRequestServiceImplTest {

    private final Trader trader = Trader.builder().name("Aikins Dwamena")
            .email("aikins.dwamena@turntabl.io")
            .build();
    private final RequestDto requestDto = RequestDto.builder().requestTime(LocalDateTime.now())
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
            .requestDate(LocalDateTime.now())
            .requestAmount(6000.0)
            .providerName("Nazdaq")
            .build();
    @Mock
    private TokenAttributesExtractorImpl tokenAttributesExtractor;
    @Mock
    private TraderRepository traderRepository;
    @Mock
    private PurchaseRequestRepository purchaseRequestRepository;
    @Mock
    private RequestMapperImpl requestMapper;
    @InjectMocks
    private PurchaseRequestServiceImpl purchaseRequestServiceimpl;
    private JwtAuthenticationToken jwtAuthenticationToken;

    @BeforeEach
    void setUp() {
        //create jwt
        String tokenValue = "token";
        String email = "aikins.dwamena@turntabl.io";
        String picture = "xxxxxx";
        String given_name = "John";
        String family_name = "Doe";
        Instant issuedAt = Instant.now();
        Instant expiredAt = Instant.now().plusSeconds(100000);
        Map<String, Object> headers = Map.of("aud", "aud");
        Map<String, Object> claims = Map.of("email", email, "picture", picture, "given_name", given_name, "family_name", family_name);

        //initialize jwt token
        Jwt jwt = new Jwt(tokenValue, issuedAt, expiredAt, headers, claims);

        //set jwtauthtoken
        jwtAuthenticationToken = new JwtAuthenticationToken(jwt);

    }

    @Test
    void makeRequest_givenAuthenticationAndRequestDto_shouldReturnSuccess() throws ResourceNotFoundException {
        String expectedResult = "request has been successfully made";
        Mockito.doReturn("aikins.dwamena@turntabl.io").when(tokenAttributesExtractor).extractEmailFromToken(any());
        Mockito.doReturn(Optional.of(trader)).when(traderRepository).findByEmail(any());
        Mockito.doReturn(purchaseRequest).when(requestMapper).requestDtoToRequest(any(), any());

        purchaseRequestServiceimpl.makeRequest(requestDto, jwtAuthenticationToken);

        Mockito.verify(tokenAttributesExtractor, Mockito.times(1)).extractEmailFromToken(any());
        Mockito.verify(requestMapper, Mockito.times(1)).requestDtoToRequest(any(), any());
        Mockito.verify(purchaseRequestRepository, Mockito.times(1)).save(any());
        Assertions.assertEquals(expectedResult, purchaseRequestServiceimpl.makeRequest(requestDto, jwtAuthenticationToken));
    }

    @Test
    void makeRequest_givenAuthenticationAndRequestDto_shouldThrowError()  {
        Mockito.doReturn("aikins.dwamena@turntabl.io").when(tokenAttributesExtractor).extractEmailFromToken(any());
        Mockito.doReturn(Optional.empty()).when(traderRepository).findByEmail(any());


        Assertions.assertThrows(ResourceNotFoundException.class, () ->
            purchaseRequestServiceimpl.makeRequest(requestDto, jwtAuthenticationToken)
        );
    }

}