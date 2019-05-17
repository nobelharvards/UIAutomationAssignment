Feature: Register account and buy dress

#Scenario Outline: Register account and buy dress
#Given Initialise browser and navigate to website
#When Register account with <email> and <password>
#Then Buy dress

#Examples:
#|email							|password|
#|bobthebuilder1@canwefixit.com	|yeswecan|

Scenario Outline: Login and buy dress
Given Initialise browser and navigate to website
When Login with <email> and <password>
Then Buy dress

Examples:
|email							|password|
|bobthebuilder@canwefixit.com	|yeswecan|