package com.gizlo.es.userexterno.repository.contract;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gizlo.es.userexterno.repository.model.UserExterno;

@Repository
public interface IUserExternoRepository extends MongoRepository<UserExterno, String> {


}
