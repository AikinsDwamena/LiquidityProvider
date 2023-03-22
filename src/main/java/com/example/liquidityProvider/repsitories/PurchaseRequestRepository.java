package com.example.liquidityProvider.repsitories;

import com.example.liquidityProvider.models.PurchaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest,Long> {

}
