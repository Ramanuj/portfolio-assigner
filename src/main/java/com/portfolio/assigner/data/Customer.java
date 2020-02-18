package com.portfolio.assigner.data;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Carries Customer information
 * 
 * @author Ramanuj
 *
 */
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;

	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	public String firstName;

	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	public String lastName;

	@JsonFormat(pattern = "ddMMyyyy")
	public LocalDate dateOfBirth;

	public double asset;

	public int age;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Portfolio portfolio;

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public Customer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public Customer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public Customer setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	/**
	 * @return the asset
	 */
	public double getAsset() {
		return asset;
	}

	/**
	 * @param asset the asset to set
	 */
	public Customer setAsset(double asset) {
		this.asset = asset;
		return this;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the portfolio
	 */
	public Portfolio getPortfolio() {
		return portfolio;
	}

	/**
	 * @param portfolio the portfolio to set
	 */
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

}
