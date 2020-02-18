package com.portfolio.assigner.util;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.assigner.common.AppConstants;
import com.portfolio.assigner.common.InputType;
import com.portfolio.assigner.exceptions.InValidFileException;
import com.portfolio.assigner.exceptions.UnsupportedContentTypeException;

/**
 * This utility will have the utility methods for file operations
 * 
 * @author Ramanuj
 *
 */
public class FileOperationsUtil {

	private static Logger logger = LoggerFactory.getLogger(FileOperationsUtil.class);

	/**
	 * The method will return an InputType if it is valid and the file is not empty
	 * 
	 * @param file
	 * @return Optional<InputType>
	 * @throws UnsupportedContentTypeException
	 * @throws InValidFileException
	 */
	public static Optional<InputType> getFileInputType(MultipartFile file) throws UnsupportedContentTypeException, InValidFileException {

		String type = file.getContentType();
		logger.info(String.format("Check content type %s for allowed types", type));

		// check if we have supported content type of the file uploaded
		if (!(AppConstants.MIME_TEXT_PLAIN.equalsIgnoreCase(type) || AppConstants.MIME_APPLICATION_VND_MSEXCEL.equalsIgnoreCase(type))) {
			throw new UnsupportedContentTypeException(String.format("The content type of the file %s is not supported", file.getOriginalFilename()));
		}

		// if the file is empty then throw an empty file exception
		if (file.getSize() <= 0) {
			throw new InValidFileException(String.format("The file %s is invalid and can't be processed", file.getOriginalFilename()));
		}

		return getInputTypeOfExt(file.getOriginalFilename());
	}

	/**
	 * Maps the InputType to the extension of the file returned
	 * 
	 * @param filename
	 * @return
	 */
	private static Optional<InputType> getInputTypeOfExt(String filename) {
		return getFileExtension(filename).map(f -> Enum.valueOf(InputType.class, f.toUpperCase()));
	}

	/**
	 * Get the extension of the file passed
	 * 
	 * @param filename
	 * @return Optional
	 */
	private static Optional<String> getFileExtension(String filename) {
		return Optional.ofNullable(filename).filter(f -> f.contains(".")).map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}

}
