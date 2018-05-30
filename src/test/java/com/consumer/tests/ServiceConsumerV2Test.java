package com.consumer.tests;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.google.gson.Gson;
import com.pact.poc.User;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Yuvaraj on 28/01/2018.
 */
public class ServiceConsumerV2Test {

    @Rule
    public PactProviderRuleMk2 ruleMk2 = new PactProviderRuleMk2("user_provider", this);


    @Pact(provider = "user_provider", consumer = "user_consumer")
    public RequestResponsePact createPact(PactDslWithProvider provider) {
        User user = new User();
        user.setEmpId("n465291");
        user.setName("subbu");
        user.setDepartment("IT");
        String userJson = new Gson().toJson(user);
        return provider.given("user named subbu is available")
                .uponReceiving("get me a user subbu")
                    .path("/pact/user")
                    .method("GET")
                .willRespondWith()
                    .status(200)
                    .body(userJson)
                .toPact();
    }

    @Pact(provider = "user_provider", consumer = "user_consumer2")
    public RequestResponsePact createPact2(PactDslWithProvider provider) {
        User user = new User();
        user.setEmpId("n465292");
        user.setName("paramesh");
        user.setDepartment("IT");
        String userJson = new Gson().toJson(user);
        return provider.given("user named subbu is available")
                .uponReceiving("get me a user paramesh")
                .path("/pact/user")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(userJson)
                .toPact();
    }

    @Test
    @PactVerification("user_provider")
    public void runTestUserSubbuGet() throws IOException {
        Response response = Request.Get(ruleMk2.getUrl()+"/pact/user").execute();
//        assert  response.returnResponse().getStatusLine().getStatusCode() == 200;
    }

}
