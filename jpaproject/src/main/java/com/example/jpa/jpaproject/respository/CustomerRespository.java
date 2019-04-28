package com.example.jpa.jpaproject.respository;

import com.example.jpa.jpaproject.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface CustomerRespository extends CrudRepository<Customer,Long> {
    List<Customer> findByLastName(String lastName);

    @Transactional
    @Modifying
    @Query("update Customer u set u.firstName = ?1 where u.lastName = ?2")
    int setFixedFirstNameFor(String firstName, String lastName);

//    List<Customer> findByFirstNameOrLastName(String name);
}
