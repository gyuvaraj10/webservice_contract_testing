package com.soap.consumer.xml.test;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuvaraj on 29/01/2018.
 */
public class GetCitiesByCountryConsumerSOAPv12Test {

    @Rule
    public PactProviderRuleMk2 mockServer = new PactProviderRuleMk2("getCitiesByCountry",
            this);

    private static String RESPONSE_XML;
    private static String REQUEST_XML;

    static {
        try {
            RESPONSE_XML = IOUtils.toString(GetCitiesByCountryConsumerSOAPv12Test.class.getResourceAsStream("/getCitiesByCountryv1.2Response.xml"),
                    Charset.defaultCharset());
            REQUEST_XML = IOUtils.toString(GetCitiesByCountryConsumerSOAPv12Test.class.getResourceAsStream("/getCitiesByCountryv1.2.xml"),
                    Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public GetCitiesByCountryConsumerSOAPv12Test() throws IOException {
    }

    @Pact(consumer = "getCitiesByCountryConsumer")
    public RequestResponsePact createPact(PactDslWithProvider provider) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/soap+xml");
        return provider.given("cities by country are available")
                .uponReceiving("a request to get the list of cities by country")
                    .path("/globalweather.asmx")
                    .method("POST")
                    .headers("Content-Type", "application/soap+xml")
                    .headers("SOAPAction", "http://www.webserviceX.NET/GetCitiesByCountry")
                    .body(REQUEST_XML)
                    .willRespondWith()
                        .status(200)
                        .body(RESPONSE_XML)
                        .headers(headers)
                        .toPact();
    }

    @Test
    @PactVerification("getCitiesByCountry")
    public void runTest() throws Exception {
        Response response = Request.Post(mockServer.getUrl() + "/globalweather.asmx")
                .addHeader("Content-Type", "application/soap+xml")
                .addHeader("SOAPAction", "http://www.webserviceX.NET/GetCitiesByCountry")
                .bodyString(REQUEST_XML, ContentType.TEXT_XML)
                .execute();
        assert  response.returnResponse().getStatusLine().getStatusCode() == 200;
    }
}
