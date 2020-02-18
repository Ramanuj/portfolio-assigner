/**
 * 
 */
package com.portfolio.assigner.exceptions;

/**
 * Exception in case the content type of the file to processed is not supported
 * 
 * @author Ramanuj
 *
 */
public class UnsupportedContentTypeException extends Exception {

	private static final long serialVersionUID = 3615816499847395559L;

	public UnsupportedContentTypeException(String errorMessage) {
		super(errorMessage);
	}

	public UnsupportedContentTypeException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
