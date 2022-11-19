package com.webapiassessment.repository;

import com.webapiassessment.entity.Customer;
import com.webapiassessment.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByCustomer(Customer c);
}