package com.consumer.tests;

import au.com.dius.pact.consumer.ConsumerPactTestMk2;
import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.google.gson.Gson;
import com.pact.poc.User;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.BasicHttpEntity;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by Yuvaraj on 27/01/2018.
 */
public class UserCreateServiceTest extends ConsumerPactTestMk2 {

    @Override
    protected RequestResponsePact createPact(PactDslWithProvider pactDslWithProvider) {
        User user = new User();
        user.setEmpId("n465290");
        user.setName("YuvarajTest123");
        user.setDepartment("IT");

        return pactDslWithProvider.given("I have a service that can create a user")
                .uponReceiving("create a user")
                    .path("/pact/user")
                        .body(new Gson().toJson(user))
                        .method("POST")
                        .willRespondWith()
                            .body(new Gson().toJson(user))
                            .status(201).toPact();
    }

    @Override
    protected String providerName() {
        return "yuvaraj_create";
    }

    @Override
    protected String consumerName() {
        return "cigniti";
    }

    @Override
    protected void runTest(MockServer mockServer) throws IOException {
        User user = new User();
        user.setEmpId("n465290");
        user.setName("YuvarajTest123");
        user.setDepartment("IT");
        String url = mockServer.getUrl();
        String userJson = new Gson().toJson(user);
        InputStream stream =IOUtils.toInputStream(userJson, Charset.defaultCharset());
        BasicHttpEntity httpEntity = new BasicHttpEntity();
        httpEntity.setContent(stream);
        Response response = Request.Post(url+"/pact/user").body(httpEntity).execute();
        HttpResponse response1 = response.returnResponse();
        String userOutPutJson = IOUtils.toString(response1.getEntity().getContent(), Charset.defaultCharset());
        assert response1.getStatusLine().getStatusCode() == 201;
        assert userOutPutJson.equals(userJson);
    }
}
