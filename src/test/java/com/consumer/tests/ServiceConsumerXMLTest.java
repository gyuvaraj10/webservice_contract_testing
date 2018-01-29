package com.consumer.tests;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Yuvaraj on 29/01/2018.
 */
public class ServiceConsumerXMLTest {

    @Rule
    public PactProviderRuleMk2 mockServer = new PactProviderRuleMk2("xmlProvider", this);


    @Pact(consumer = "xmlConsumer")
    public RequestResponsePact createPact(PactDslWithProvider provider) throws IOException {
        String xml = IOUtils.toString(this.getClass().getResourceAsStream("/samplexml.xml"),
                Charset.defaultCharset());
        return provider.given("I have a book")
                .uponReceiving("a request to receive the list of books")
                    .path("/get/books")
                        .method("GET")
                    .willRespondWith()
                        .body(xml)
                        .status(200)
                    .toPact();
    }

    @Test
    @PactVerification("xmlProvider")
    public void runTestWithXMLConsumer() throws IOException {
        Response response = Request.Get(mockServer.getUrl()+"/get/books").execute();
        assert  response.returnResponse().getStatusLine().getStatusCode() == 200;
    }
}
