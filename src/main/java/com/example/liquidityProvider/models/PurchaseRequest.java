package com.example.liquidityProvider.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private String fxName;

    private LocalDateTime requestDate;

    private Double requestAmount;

    private String  requestStatus;

    private String  tradersAccount;

    @ManyToOne
    @JoinColumn(name = "trader_email")
    @JsonBackReference
    private  Trader buyer;

}
