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
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String currencyName;

    Integer numberAvailable;

    Double price;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    @JsonBackReference
    Provider provider;

}
