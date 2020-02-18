/**
 * 
 */
package com.portfolio.assigner.rules.impl;

import com.portfolio.assigner.data.Portfolio;
import com.portfolio.assigner.rules.RuleEngine;

/**
 * This rule engine will select the portfolio based on the customer age.
 * 
 * @author Ramanuj
 *
 */
public class PortfolioAllocationRuleEngine implements RuleEngine {

	@Override
	public Portfolio executePortfolioAllocationRules(int age, double asset) {

		Portfolio portfolio = null;

		String portfolioName;
		double equityPerCent = 0, bondsPerCent = 0, cashPerCent = 0;

		// TODO needs to be through an interface
		if (age >= 0 && age <= 40) {
			portfolioName = "Aggressive Growth";
			equityPerCent = 80;
			bondsPerCent = 10;
			cashPerCent = 10;
		} else if (age >= 41 && age <= 44) {
			portfolioName = "Growth";
			equityPerCent = 70;
			bondsPerCent = 20;
			cashPerCent = 10;
		} else if (age >= 56 && age <= 65) {
			portfolioName = "Income";
			equityPerCent = 50;
			bondsPerCent = 30;
			cashPerCent = 20;
		} else {
			portfolioName = "Retirement";
			equityPerCent = 20;
			bondsPerCent = 30;
			cashPerCent = 50;
		}

		portfolio = this.getPortfolio(asset, equityPerCent, bondsPerCent, cashPerCent);
		portfolio.setPortfolioName(portfolioName);

		return portfolio;
	}

	/**
	 * Get Portfolio Distribution
	 * 
	 * @param asset
	 * @param equityPerCent
	 * @param bondsPerCent
	 * @param cashPerCent
	 * @return Portfolio
	 */
	private Portfolio getPortfolio(double asset, double equityPerCent, double bondsPerCent, double cashPerCent) {

		Portfolio portfolio = new Portfolio();

		portfolio.setEquity(this.getPerCent(asset, equityPerCent));
		portfolio.setBonds(this.getPerCent(asset, bondsPerCent));
		portfolio.setCash(this.getPerCent(asset, cashPerCent));

		return portfolio;
	}

	/**
	 * Calculate the percentage amount of the value passed
	 * 
	 * @param amount
	 * @param percentage
	 * @return
	 */
	private double getPerCent(double amount, double percentage) {
		return amount * percentage / 100;
	}

}
