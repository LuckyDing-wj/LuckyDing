package com.wj.ding;

import com.wj.ding.mongo.domain.Customer;
import com.wj.ding.mongo.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LuckyDing
 */
@SpringBootApplication
public class DingApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(DingApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        customerRepository.save(new Customer("wang", "jie"));
        customerRepository.save(new Customer("ding", "xuanwen"));

    }
}
