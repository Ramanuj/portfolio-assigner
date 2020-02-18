/**
 * 
 */
package com.portfolio.assigner.rules;

import com.portfolio.assigner.data.Portfolio;

/**
 * Rule Engine for running the portfolio assignment rules on the customer passed
 * 
 * @author Ramanuj
 *
 */
public interface RuleEngine {

	public Portfolio executePortfolioAllocationRules(int age, double asset);
}
