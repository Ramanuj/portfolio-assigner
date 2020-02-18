package com.portfolio.assigner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.assigner.data.Customer;

/**
 * Repository to perform Database operations on Customers
 * 
 * @author Ramanuj
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
