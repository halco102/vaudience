# Api documentation


## GET

The endpoint is **“/api/v1/contacts”**. This endpoint is used to get all the contacts from the database.
It requires no parameters to be sent. This endpoint returns a list of Contacts(Object), List<ContacDto>.

Example
{
	"id": 1,
	"firstName": "Admir",
	"lastName": "Halilovic",
	"dateOfBirth": "1997-04-11",
	"address": {
	"id": 1,
	"city": "Lukavac",
	"postalCode": "75300"
}

The endpoint is **“/api/v1/contacts/{zip}”** where the **“zip”** is a **String**.
This endpoint is used to get one or more Contacts with the same zip code.
It requires a parameter to be sent a String.
It returns a list of Contacts(Object), List<ContactDto>

Example
{
	"id": 1,
	"firstName": "Admir",
	"lastName": "Halilovic",
	"dateOfBirth": "1997-04-11",
	"address": {
	"id": 1,
	"city": "Lukavac",
	"postalCode": "75300"

}

{
	"id": 5,
	"firstName": "Dino",
	"lastName": "Gradaskic",
	"dateOfBirth": "1998-07-19",
	"address": {
	"id": 1,
	"city": "Lukavac",
	"postalCode": "75300"
}

If the {zip} is invalid, it will return an Exception,
status ‘404’
message ‘Contact was not found’,
timestamp ‘CurrentTime in milliseconds’


The endpoint is **“/api/v1/address”**. This endpoint is used to get all the addresses from the database.
It requires no parameters to be sent. This endpoint returns a list of Address(Object), List<AddressDto>.

Example

{
	"id": 1,
	"city": "Lukavac",
	"postalCode": "75300"
}


## POST

The endpoint is **“/api/v1/contacts”**. This endpoint is used to Save a new Contact. It requires a ContactDto body in order to save the new Contact.
It has its Validation :
	
	“firstName”    cant be blank space and it has to be between 2 and 20 characters long,
	“lastName”     cant be blank space and it has to be between 2 and 20 characters long,
	“dateOfBirth” cant be blank space
	“address” cant be null

If the Validation is not met it will return 
status 400
message “”
error “Bad Request”
timestamp “Current Date and Time”

JSON body to save the entity 
{

"firstName": “{String}”,
"lastName": “{String}”,
"dateOfBirth": “{yyyy-MM-dd}”,
"address": {
"id": “{Long}”,
"city": “{String}”,
"postalCode": “{String}”
}
}


The endpoint is **“/api/v1/address”**. This endpoint is used to Save a new Address. It requires a AddressDto body in order to save the new Address.
Validation for Address:

	 “city” it cant be blank space and it has to be between 2 and 40 characters long
	 “postalCode” it cant be blank space

If the Validation is not met it will return 
status 400
message “”
error “Bad Request”
timestamp “Current Date and Time”

If the new Address has the same city as in the database, it will throw an Exception 
status 409
message “Duplicate found”
timestamp “CurrentTime in miliseconds”

JSON body to save entity
{ 
"city": "{String}",
"postalCode": "{String}"
}

