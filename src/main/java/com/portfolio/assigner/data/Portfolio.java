package com.portfolio.assigner.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Carries the portfolio information of the customer
 * 
 * @author Ramanuj
 *
 */
@Entity
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long portfolio_id;

	/**
	 * This field stores the name of the portfolio
	 */
	private String portfolioName;

	/**
	 * These fields will store the asset distribution
	 */
	private double equity;
	private double bonds;
	private double cash;

	/**
	 * @return the portfolio_id
	 */
	public Long getPortfolio_id() {
		return portfolio_id;
	}

	/**
	 * @param portfolio_id the portfolio_id to set
	 */
	public void setPortfolio_id(Long portfolio_id) {
		this.portfolio_id = portfolio_id;
	}

	/**
	 * @return the equity
	 */
	public double getEquity() {
		return equity;
	}

	/**
	 * @param equity the equity to set
	 */
	public void setEquity(double equity) {
		this.equity = equity;
	}

	/**
	 * @return the bonds
	 */
	public double getBonds() {
		return bonds;
	}

	/**
	 * @param bonds the bonds to set
	 */
	public void setBonds(double bonds) {
		this.bonds = bonds;
	}

	/**
	 * @return the cash
	 */
	public double getCash() {
		return cash;
	}

	/**
	 * @param cash the cash to set
	 */
	public void setCash(double cash) {
		this.cash = cash;
	}

	/**
	 * @return the portfolioName
	 */
	public String getPortfolioName() {
		return portfolioName;
	}

	/**
	 * @param portfolioName the portfolioName to set
	 */
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

}
