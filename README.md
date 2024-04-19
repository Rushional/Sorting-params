# What is this?
This is a simple API with a single endpoint. It accepts http request parameters with values, then sorts them by parameter name, makes a string of them, and hashes it.

# How to run it?
Both the tests and the app itself require 3 environment variables:
* PARAMS_HASHING_HEADER_TOKEN - this is the value that has to be included in a Token header in each request. Without it, the API returns status 403.
* HASHING_SECRET_KEY - secret key for the hashing process
* SORT_PARAMS_OPERATION_NUMBER - operationid, the number of the operation requested. Currently there's only one - sorting and hashing incoming parameters, but there could be more.

No additional setup is required, the code can be compiled and run after setting the environment variables. 

# Also!
* The path of the endpoit is /params/{operation id}, where operation id is a number defined in environment variables.
* The API has unit and intergation tests.

# Postman
Here's a [link](https://api.postman.com/collections/25314724-5730d10d-d805-445e-95d5-68d29d2cd85b?access_key=PMAT-01HVV7MS5DB2WVKM8NC9FAW8RJ) to my Postman collection JSON for this API, you can import it and use it yourself

Here's an example of a successful request: 
![image](https://github.com/Rushional/Sorting-params/assets/56831898/1b042cff-de21-4e4c-960f-ef330b7b268d)

What happens when the Token header is incorrect:
![image](https://github.com/Rushional/Sorting-params/assets/56831898/81938fc2-b6fb-44d3-b9a0-1dc08c7e7a3f)

Missing Token header:
![image](https://github.com/Rushional/Sorting-params/assets/56831898/9df78cfa-d3a5-4841-910d-5a9a13cc1c3b)

Noteworthy: when making a request with zero parameters, the API will return a hash of an empty string:)
![image](https://github.com/Rushional/Sorting-params/assets/56831898/1c69a41a-dd49-4754-9732-013451292f0f)
