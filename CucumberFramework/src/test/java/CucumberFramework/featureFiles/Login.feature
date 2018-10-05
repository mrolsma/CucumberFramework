Feature: Login to account 
	Existing user should be able to login to account using correct account
	
#	Background:
#		Given user navigates to demoaut website
#	
#	
#Scenario: Login to account with correct credentials 
#	And user enters "valid" username
#	And user enters "valid" password 
#	When user clicks on the login button 
#	Then user should be taking to the succesfull login page
#	
#Scenario: Login to account with incorrect username 
#	And user enters "invalid" username  
#	And user enters "invalid" password 
#	When user clicks on the login button 
#	Then user should not be taking to the succesfull login page
#	
#Scenario: Login to account with correct credentials with data table
#	And user enters valid username and valid password
#	|Pino|123|
	
	Scenario Outline: Login to account with correct credentials 2 
	Given user navigates to demoaut website
	And user enters "<username>" username 
	And user enters "<password>" password 
	When user clicks on the login button 
	Then user should be taking to the succesfull login page 
	
	Examples: 
	
		|username   |password|
		|Pino		|123  	 | 
		|Pino       |123   |
	 