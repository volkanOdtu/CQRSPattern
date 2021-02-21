package com.vinsguru.cqrs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinsguru.cqrs.entity.PurchaseOrderSummary;

@Repository
public interface PurchaseOrderSummaryRepository extends JpaRepository<PurchaseOrderSummary, String>{
	 Optional<PurchaseOrderSummary> findByState(String state);
}
