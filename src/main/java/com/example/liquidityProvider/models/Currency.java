package com.example.liquidityProvider.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {

    @Id
    String currencyName;

    Integer numberAvailable;

    Double price;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    @JsonBackReference
    Provider provider;

}
