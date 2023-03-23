package com.example.liquidityProvider.repsitories;

import com.example.liquidityProvider.models.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraderRepository extends JpaRepository<Trader, String> {
    Optional<Trader> findByEmail(String email);
}
