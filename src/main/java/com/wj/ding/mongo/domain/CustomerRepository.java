package com.wj.ding.mongo.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author LuckyDing
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    /**
     * @param firstName user firstName
     * @return customer
     */
    Customer findByFirstName(String firstName);

    /**
     * @param lastName user lastName
     * @return customer list
     */
    List<Customer> findByLastName(String lastName);

}
