package com.business.simple.repository;

import com.business.simple.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select p from Customer p where p.name like %?1% ")
    List<Customer> findByName(String name);
}
