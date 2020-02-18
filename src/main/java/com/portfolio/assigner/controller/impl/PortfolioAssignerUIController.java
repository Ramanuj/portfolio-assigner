/**
 * 
 */
package com.portfolio.assigner.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.assigner.controller.PortfolioAssignerController;
import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.CustomerOutput;
import com.portfolio.assigner.service.PortfolioAssignerUIService;

/**
 * This controller will handle all the requests for portfolio assignment and customer information display
 * 
 * @author Ramanuj
 *
 */
@Controller
@RequestMapping("file")
public class PortfolioAssignerUIController implements PortfolioAssignerController {

	private static Logger logger = LoggerFactory.getLogger(PortfolioAssignerUIController.class);

	@Autowired
	@Qualifier("portfolioAssignerUIServiceImpl")
	private PortfolioAssignerUIService portfolioAssignerUIServiceImpl;

	@Override
	public List<Customer> getAllCustomers() {
		logger.info("Getting all customers from the system");
		return null;
	}

	/**
	 * Load the upload form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("form")
	public String loadFileForm(Model model) {
		logger.info("loading the form");
		return "uploadview";
	}

	/**
	 * Get all the customers
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping("getallcustomers")
	public String displayCustomers(Model model) {
		logger.info("getting all the customers");

		List<Customer> customers = portfolioAssignerUIServiceImpl.getAllCustomers();
		model.addAttribute("customers", customers);

		return "uploadstatusview";
	}

	/**
	 * Process the files passed
	 * 
	 * @param model
	 * @param files
	 * @return
	 */
	@RequestMapping("upload")
	public String upload(Model model, @RequestParam("files") MultipartFile[] files) {
		logger.info("Uploading " + files.length + " for processing.");

		CustomerOutput customers = portfolioAssignerUIServiceImpl.assignPortfolioToCustomers(files);

		model.addAttribute("customers", customers.getCustomers());

		return "uploadstatusview";
	}

}
