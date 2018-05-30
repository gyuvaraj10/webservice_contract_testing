package com.consumer.tests;

import au.com.dius.pact.consumer.ConsumerPactTestMk2;
import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;


import com.google.gson.Gson;
import com.pact.poc.User;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Response;
import org.junit.Assert;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuvaraj on 26/01/2018.
 */
public class ServiceConsumerTest extends ConsumerPactTestMk2 {

    @Override
    protected RequestResponsePact createPact(PactDslWithProvider pactDslWithProvider) {
        User user = new User();
        user.setEmpId("n465290");
        user.setName("Yuvaraj");
        user.setDepartment("IT");

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=utf-8");
        return pactDslWithProvider
                .given("I have a user named Yuvaraj")
                .uponReceiving("a get request to get the user information")
                .path("/pact/user")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body(new Gson().toJson(user))
                .toPact();
    }

    @Override
    protected String providerName() {
        return "yuvaraj";
    }

    @Override
    protected String consumerName() {
        return "cigniti";
    }

    @Override
    protected void runTest(MockServer mockServer) throws IOException {
        User user = new User();
        user.setEmpId("n465290");
        user.setName("Yuvaraj");
        user.setDepartment("IT");
        ServiceConsumerClient client = new ServiceConsumerClient(mockServer.getUrl());
        Response userInformation = client.getUserInformation();
        HttpResponse httpResponse = userInformation.returnResponse();
//        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
//        Assert.assertEquals(IOUtils.toString(httpResponse.getEntity().getContent(),
//                Charset.defaultCharset()), new Gson().toJson(user));
    }
}
