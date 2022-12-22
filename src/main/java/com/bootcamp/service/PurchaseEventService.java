package com.bootcamp.service;

import org.springframework.stereotype.Component;

import com.bootcamp.event.Event;
import com.bootcamp.event.PurchaseCreatedEvent;

import lombok.extern.slf4j.Slf4j;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;


@Slf4j
@Component
public class PurchaseEventService {
	

	@Autowired
	private SalesRequestService requestService;

	@KafkaListener(
			topics = "topic-bootcoin-1" ,
			containerFactory = "kafkaListenerContainerFactory",
	groupId = "grupo1")
	public void consumer(Event<?> event) {
		if (event.getClass().isAssignableFrom(PurchaseCreatedEvent.class)) {
			PurchaseCreatedEvent createdEvent = (PurchaseCreatedEvent) event;
			log.info("Received account created event .... with Id={}, data={}",
					createdEvent.getId(),
					createdEvent.getData().getNumberAccount());
			requestService.updateSalesRequest(createdEvent.getData()).subscribe();
		
		}

	}
	
}
