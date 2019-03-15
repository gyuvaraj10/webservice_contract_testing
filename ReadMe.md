This framework uses pact library to do the contract testing. This POC is sample only.
 
 
To generate the pact files run "ServiceConsumerTest", "UserCreateServiceTest" classes from com.consumer.tests package.

Make sure the 8080 port is available on your machine.

To run the provider tests run the following steps
1. Run the spring boot application and make sure the services are running by hitting the actual services
http://localhost:8080/pact/user -- GET
http://localhost:8080/pact/user -- POST

2. Run the test "UserCreateServiceProviderTest" that uses the pact files provided in the pact folder.

    

1. Run mvn spring-boot:run to run the server.
    http://localhost:8080/swagger-ui.html#/ to launch the swagger ui
    http://localhost:8080/v2/api-docs for the api documentation
    
 http://localhost:8080/accounts/fixed-savers for the fixed savers account   