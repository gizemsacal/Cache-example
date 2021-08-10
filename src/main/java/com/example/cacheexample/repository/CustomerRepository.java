package com.example.cacheexample.repository;

import com.example.cacheexample.model.Customer;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    void deleteById(String id);

    Customer getById(String id);
}
