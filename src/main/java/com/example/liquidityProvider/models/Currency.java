package com.example.liquidityProvider.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Currency {

    @Id
    String currencyName;

    Double amountAvailable;

    Double rate;

    @ManyToOne()
    @JoinColumn(name = "provider_id")
    @JsonBackReference
    Provider provider;

}
