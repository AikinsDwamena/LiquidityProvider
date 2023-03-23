package com.example.liquidityProvider.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.example.liquidityProvider.enums.FXName;
import com.example.liquidityProvider.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PurchaseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FXName fxName;

    private LocalDateTime requestDate;

    private Double requestAmount;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    private String  tradersBankAccount;

    private String providerName;

    @ManyToOne
    @JoinColumn(name = "trader_email")
    @JsonBackReference
    private  Trader buyer;



}
