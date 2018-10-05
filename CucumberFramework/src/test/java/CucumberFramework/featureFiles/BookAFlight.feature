@BookAFlight
Feature: Book a flight	
	
	Scenario Outline: Login to account with correct credentials 2 
	Given user navigates to demoaut website
	And user enters "<username>" username 
	And user enters "<password>" password 
	When user clicks on the login button 
	And the user finds a flight
	And the user selects a flight
	And the user secures a purchase
	Then the user sees the flight confirmation page 
	
		Examples: 
	
		|username   |password|
		|Pino		|123  	 | 
