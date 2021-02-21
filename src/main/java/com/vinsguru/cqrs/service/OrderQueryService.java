package com.vinsguru.cqrs.service;

import java.util.List;

import com.vinsguru.cqrs.dto.PurchaseOrderSummaryDto;

public interface OrderQueryService {
		List<PurchaseOrderSummaryDto> getSaleSummaryGroupByState();
		PurchaseOrderSummaryDto getSaleSummaryByState(String state);
		double getTotalSale();
}
