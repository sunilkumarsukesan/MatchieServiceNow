Feature: This is about contact feature in salesforce

@createContact
 Scenario: Create a new contact with first name and last name
	Given enable logs
	When firstname and last name is added as Sunil , Kumar
	Then new contact is created
	And the status code should be 201
	
	
@updateContact
 Scenario: Update the existing contact
	Given enable logs
	When Mailing address is added as jsonbody from the path .//src//test//resources//jsonPayLoad//updateMailAddress.json
	And i update the contact 0035g00000EZy7CAAT
	Then the status code should be 204	

@getAllContacts
Scenario: Get all contacts
	Given enable logs
	When i get all Contact
	#Then i should find the newly created contact 
	#And the status code should be 200

	