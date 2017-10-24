Feature: Submit Meter Read for Anonymous Readd

#Background:
#Given I launch the application

@current
Scenario: Landing a submit meter read page for anonymous

Given I am login with the credentials
When I should navigate to account summary page
Then I should verify the submit meter read landing page

@Errorscenario

Scenario: To validate the client side validation
When user enter the username and password
Then user verify the error scenario

#UDNE-2 Anonymous Meter read first page

@positive @validate
Scenario: To validate that if the customer is able to enter the account number, post code and email address in SMR page

Given I should navigate to the SMR page
When I should enter the account number as "600783816" ,postcode as "KA18 2AF" and email address as "shobanbabu.manohar@cognizant.com"
Then I click on next button

@negative @validate
Scenario: To validate that if the customer is getting proper client side error message when giving in proper error message

Given I should navigate to the SMR page
When I should enter the account number as "600783a" ,postcode as " 2AF" and email address as "shobanbabasdeu.manoharcognizant.com"
Then I should verify UI error message

@negative @validate
Scenario: To validate that if the customer is getting proper client side error message when giving in proper error message

Given I should navigate to the SMR page
When I should enter the account number as "600783a" ,postcode as " 2AF" and email address as "shobanbabasdeu.manoharcognizant.com"
Then I should verify UI error message with invalid deatils

@singleRegister @Regression

Scenario: To validate that if the customer is getting meter read details when giving valid details for Single Registers

Given I should navigate to the SMR page
When I should enter the account number as "602028090" ,postcode as "PL5 1QY" and email address as "shobanbabasdeu.manohar@cognizant.com"
Then I should verify UI of meter deatils
Then I should submit the meter read for Single Registers

@MultiRegister @Regression

Scenario: To validate that if the customer is getting meter read deatils when giving valid deatils for Multiple Registers

Given I should navigate to the SMR page
When I should enter the account number as "600712768" ,postcode as "EX33 2BJ" and email address as "shobanbabasdeu.manohar@cognizant.com"
Then I should verify UI of meter deatils
Then I should submit the meter for Multiple Registers

@Multimeter @Regression

Scenario: To validate that if the customer is getting meter read deatils when giving valid deatils for Multiple Meters

Given I should navigate to the SMR page
When I should enter the account number as "600596676" ,postcode as "NE38 8QB" and email address as "shobanbabasdeu.manohar@cognizant.com"
Then I should verify UI of meter deatils
Then I should submit the meter for Multiple Meter







