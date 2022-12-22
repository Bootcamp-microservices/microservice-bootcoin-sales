package com.bootcamp.service;

import com.bootcamp.entity.PurchaseRequest;
import com.bootcamp.entity.SalesRequest;

import reactor.core.publisher.Mono;

public interface SalesRequestService {
	
	public Mono<SalesRequest> updateSalesRequest(PurchaseRequest purchaseRequest);

}
