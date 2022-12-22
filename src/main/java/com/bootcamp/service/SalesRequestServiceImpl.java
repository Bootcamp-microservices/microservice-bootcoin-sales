package com.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.entity.PurchaseRequest;
import com.bootcamp.entity.SalesRequest;
import com.bootcamp.repository.SalesRequestRepository;

import reactor.core.publisher.Mono;

@Service
public class SalesRequestServiceImpl implements SalesRequestService {

	@Autowired
	private SalesRequestRepository repository;
	
	@Override
	public Mono<SalesRequest> updateSalesRequest(PurchaseRequest purchaseRequest) {
		System.out.println("Ingreso updateSalesRequest");
		 Mono<SalesRequest> monoSalesRequest = repository.findById(purchaseRequest.getIdSalesRequest()).
				 map(a-> {
					 a.setPurchaseRequest(purchaseRequest);
					 System.out.println("purchaseRequest :"+a);
					 repository.save(a).subscribe();
					 return a;
					});
		 
		return monoSalesRequest;
	}

}
