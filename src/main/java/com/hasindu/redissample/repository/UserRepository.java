package com.hasindu.redissample.repository;

import com.hasindu.redissample.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hasindu_d
 */
@Repository
public interface UserRepository extends CrudRepository<User,String> {

}
