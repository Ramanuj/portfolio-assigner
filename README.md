# portfolio-assigner
Assign a portfolio ‘model’ to each customer based on their age using Spring boot


## Installation

run mvn clean install to download the dependencies

to run the application


## Usage

go to com.portfolio.assigner.PortfolioAssignerApplication and run 

customers can be uploaded using either the file upload or through a rest service

using form to load the customers
http://localhost:8080/file/form
http://localhost:8080/file/upload

loading through a rest service
http://localhost:8080/api/addCusomers

## Sample Json for Rest service
[
	{
		"firstName":"First Name",
		"lastName":"Last Name",
		"dateOfBirth":"06031990",
		"asset":"343534.23"
	},
  	{
		"firstName":"First Name again",
		"lastName":"Last Name again",
		"dateOfBirth":"06031990",
		"asset":"343534.23"
	},
]

## File type for upload
text and csv

TEXT Format
added customers.txt and customers.csv
