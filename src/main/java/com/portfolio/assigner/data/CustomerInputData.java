package com.portfolio.assigner.data;

/**
 * This class will contain the Input Customer Data received from the Json
 * request. Adding this class to add more fine grained control over the
 * validations we want to have on the array of records.<br>
 * 
 * @author Ramanuj
 *
 */
public class CustomerInputData {

	/**
	 * First Name of the customer
	 */
	public String firstName;

	/**
	 * Last Name of the Customer
	 */
	public String lastName;

	/**
	 * Date of Birth of the customer. It will be used to calculate the age.
	 */
	public String dateOfBirth;

	/**
	 * Asset of the customer that will be distributed to the Customer.
	 */
	public String asset;

	/**
	 * Overriding the toString method to convert the data into a String. This will
	 * enable us to use an existing text to Customer object adapter.
	 */
	@Override
	public String toString() {
		String cutomerInputdata = "";
		if (this.getFirstName() != null) {
			cutomerInputdata = this.getFirstName();
		}
		if (this.getLastName() != null) {
			cutomerInputdata = cutomerInputdata + "|" + this.getLastName();
		}
		if (this.getDateOfBirth() != null) {
			cutomerInputdata = cutomerInputdata + "|" + this.getDateOfBirth();
		}
		if (this.getAsset() != null) {
			cutomerInputdata = cutomerInputdata + "|" + this.getAsset();
		}
		return cutomerInputdata;
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
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the asset
	 */
	public String getAsset() {
		return asset;
	}

	/**
	 * @param asset the asset to set
	 */
	public void setAsset(String asset) {
		this.asset = asset;
	}

}
