package com.bootcamp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "salesRequest")
public class SalesRequest {
	
	private ObjectId id;
	private String idSeller;
	private Double price;
	private String limits;
	private String status;
	private PurchaseRequest purchaseRequest;
	

}
