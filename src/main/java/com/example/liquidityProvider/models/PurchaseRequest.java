package com.example.liquidityProvider.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import enums.FXName;
import enums.RequestStatus;
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
    private Long id;

    @Enumerated()
    private FXName fxName;

    private LocalDateTime requestDate;

    private Double requestAmount;

    @Enumerated()
    private RequestStatus requestStatus;

    private String  tradersBankAccount;

    private String providerName;

    @ManyToOne
    @JoinColumn(name = "trader_email")
    @JsonBackReference
    private  Trader buyer;

}
