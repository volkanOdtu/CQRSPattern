package com.vinsguru.cqrs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinsguru.cqrs.dto.PurchaseOrderSummaryDto;
import com.vinsguru.cqrs.entity.PurchaseOrderSummary;
import com.vinsguru.cqrs.repository.PurchaseOrderRepository;
import com.vinsguru.cqrs.repository.PurchaseOrderSummaryRepository;
import com.vinsguru.cqrs.service.OrderQueryService;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {
	
	@Autowired
	private PurchaseOrderSummaryRepository purchaseOrderSummaryRepository;
	
	@Override
	public List<PurchaseOrderSummaryDto> getSaleSummaryGroupByState() {
		
		return this.purchaseOrderSummaryRepository.findAll()
					.stream()
					.map(this::entityToDto)
	                .collect(Collectors.toList());
	}

	@Override
	public PurchaseOrderSummaryDto getSaleSummaryByState(String state) {
	       return this.purchaseOrderSummaryRepository.findByState(state)
                   .map(this::entityToDto)
                   .orElseGet(() -> new PurchaseOrderSummaryDto(state, 0));

	}

	@Override
	public double getTotalSale() {
		return this.purchaseOrderSummaryRepository.findAll()
                .stream()
                .mapToDouble(PurchaseOrderSummary::getTotalSale)
                .sum();
	}

	private PurchaseOrderSummaryDto entityToDto(PurchaseOrderSummary purchaseOrderSummary ) {
		PurchaseOrderSummaryDto dto = new PurchaseOrderSummaryDto();
		
		dto.setState(purchaseOrderSummary.getState());
		dto.setTotalSale(purchaseOrderSummary.getTotalSale());
		
		return dto;
	}
}
