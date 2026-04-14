Feature: Validating Place API's

@AddPlace
Scenario: Verify if place is being Successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "post" http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
	
	
Examples:

	|name	| language	| address		|
#	|Luffy	| English	| Elabaf		|
#	|Ichigo	| Japanese	| Karakura Town	|
	|Naruto	| Hindi		| Hidden Leaf	|	
	

@DeletePlace
Scenario:Verify id Delete place functionalityis working
	Given DeletePlace Payload
	When user calls "deletePlaceAPI" with "post" http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
