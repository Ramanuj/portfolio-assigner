package com.portfolio.assigner.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.util.StringUtils;

import com.portfolio.assigner.common.AppConstants;
import com.portfolio.assigner.exceptions.InvalidDateFormatException;

/**
 * This will validate the customer input record
 * 
 * @author Ramanuj
 *
 */
public class CustomerRecordValidator {

	/**
	 * This method will validate if all the required fields are present.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param asset
	 * @return String
	 */
	public String validateAllRequiredInputs(String firstName, String lastName, String dateOfBirth, String asset) {

		String validationMessage = null;

		if (StringUtils.isEmpty(firstName)) {
			return AppConstants.ERR_MSG_FIRST_NAME_NOT_PRESENT;
		} else if (StringUtils.isEmpty(lastName)) {
			return AppConstants.ERR_MSG_LAST_NAME_NOT_PRESENT;
		} else if (StringUtils.isEmpty(dateOfBirth)) {
			return AppConstants.ERR_MSG_DATE_OF_BIRTH_NOT_PRESENT;
		} else if (StringUtils.isEmpty(asset)) {
			return AppConstants.ASSET_NOT_PRESENT;
		}

		return validationMessage;
	}

	/**
	 * Validate date of birth. <br>
	 * If the date of birth
	 * 
	 * @param dateOfBirth
	 * @return LocalDates
	 * @throws InvalidDateFormatException
	 */
	public LocalDate dateOfBirth(String dateOfBirth) throws InvalidDateFormatException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConstants.ACCEPTABLE_DATEFORMAT);
		try {
			return LocalDate.parse(dateOfBirth, formatter);
		} catch (Exception e) {
			throw new InvalidDateFormatException("Date passed is in invalid format, Excepted date format ddMMyyyy", e);
		}
	}

	/**
	 * Validate assets. <br>
	 * If the asset can not be parsed as double then throw a NumberFormatException
	 * 
	 * @return Double
	 */
	public Double asset(String asset) {

		try {
			return Double.valueOf(asset);
		} catch (Exception e) {
			throw new NumberFormatException("Asset value is invalid");
		}
	}

}
