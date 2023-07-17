Description
The backend service is implemented using Spring Boot, providing a REST API endpoint to find the longest common substring in a set of strings. It uses an efficient algorithm to compute the result and returns it as JSON data.

API Endpoint
POST /lcs
Request Payload
The request payload should be a JSON object containing a set of strings:

json request

{
  "setOfStrings": ["comcast", "comcastic", "broadcaster"]
}

Response
The response will be a JSON object containing the longest common substring:

json response
{
  "lcs": "cast"
}
Error Handling
The API handles various error scenarios, such as invalid input, empty set of strings, or non-unique strings in the set. Appropriate HTTP status codes and error messages are provided in the response to guide users.


Unit Test Cases
The backend service is thoroughly tested using JUnit and Mockito to ensure its correctness. The following unit test cases have been implemented:

testProcessSetOfStrings_Success: Tests the successful computation of the longest common substring.

testProcessSetOfStrings_EmptySet: Tests the handling of an empty set of strings.

testProcessSetOfStrings_NonUniqueStrings: Tests the handling of non-unique strings in the input set.
testProcessSetOfStrings: Tests the sample strings in input payload.


API Documentation
The API is documented using Swagger. You can access the Swagger UI at: http://localhost:8080/swagger-ui/
