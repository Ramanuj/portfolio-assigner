package com.portfolio.assigner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.assigner.data.Portfolio;

/**
 * Repository to perform Database operations on Portfolio of the customers
 * 
 * @author Ramanuj
 *
 */
@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
