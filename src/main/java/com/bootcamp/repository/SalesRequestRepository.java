package com.bootcamp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.entity.SalesRequest;

@Repository
public interface SalesRequestRepository extends  ReactiveMongoRepository<SalesRequest, ObjectId>{

}
