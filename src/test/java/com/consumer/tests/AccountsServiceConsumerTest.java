package com.consumer.tests;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class AccountsServiceConsumerTest {

    @Rule
    public PactProviderRuleMk2 ruleMk2 = new PactProviderRuleMk2("thought_machine", this);


    @Pact(provider = "thought_machine", consumer = "atom_mule")
    public RequestResponsePact createPact(PactDslWithProvider provider) throws IOException {
        String content = FileUtils.readFileToString(new File(this.getClass().getClassLoader().getResource("fixed-savers.json")
                        .getPath()),
                Charset.defaultCharset());
        return provider.given("thought machine has fixed saver account details")
                .uponReceiving("fixed saver account details")
                .path("/accounts/fixed-savers")
                .method("GET")
                .willRespondWith()
                .status(201)
                .body(content)
                .toPact();
    }

    @Test
    @PactVerification("thought_machine")
    public void runTestUserSubbuGet() throws IOException {
        Response response = Request.Get(ruleMk2.getUrl()+"/accounts/fixed-savers").execute();
    }
}
