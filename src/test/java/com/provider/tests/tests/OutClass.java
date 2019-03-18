package com.provider.tests.tests;



import au.com.dius.pact.model.*;
import au.com.dius.pact.provider.*;

import java.util.List;
import java.util.Map;

public class OutClass {

    public static void main(String[] args) {
        ProviderInfo providerInfo = new ProviderInfo("thought_machine");
        providerInfo.setHost("localhost");
        providerInfo.setPort(8080);
        providerInfo.setPath("/");

        ConsumerInfo consumerInfo = new ConsumerInfo();
        consumerInfo.setName("atom_mule");
        consumerInfo.setPactSource("target/pacts/atom_mule-thought_machine.json");
        Pact pact = PactReader.loadPact(consumerInfo.getPactSource());
        List<Interaction> interactions = pact.getInteractions();
        Interaction interaction1 = interactions.get(0);
        RequestResponseInteraction requestResponseInteraction = (RequestResponseInteraction)interaction1;
        ProviderClient providerClient = new ProviderClient(providerInfo, new HttpClientFactory());
        Map<String, Object> response = providerClient.makeRequest(requestResponseInteraction.getRequest());

        Map<String, Object> result = (Map<String, Object>) ResponseComparison.compareResponse(requestResponseInteraction.getResponse(),
                response, (int) response.get("statusCode"), (Map) response.get("headers"), (String) response.get("data"));
        System.out.println("Done");
    }
}
