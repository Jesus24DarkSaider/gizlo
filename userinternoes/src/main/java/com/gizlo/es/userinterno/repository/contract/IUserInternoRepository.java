package com.gizlo.es.userinterno.repository.contract;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gizlo.es.userinterno.repository.model.UserInterno;

@Repository
public interface IUserInternoRepository extends MongoRepository<UserInterno, String> {

	
	
}
