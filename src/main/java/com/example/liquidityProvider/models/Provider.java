package com.example.liquidityProvider.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long providerId;

    String providerName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "provider")
    @JsonManagedReference
    List<Currency> currencies;
}
