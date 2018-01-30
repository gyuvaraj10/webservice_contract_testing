package com.soap.provider.xml.test;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;

/**
 * Created by Yuvaraj on 27/01/2018.
 */
@RunWith(PactRunner.class)
@Provider("getCitiesByCountry")
@PactFolder("target/pacts/")
public class GetCitiesSOAPResponseProviderTest {

    @TestTarget
    public final Target target = new HttpTarget("173.201.44.188", 80);

    @State(value = "cities by country are available")
    public void verifySoapResponse() {

    }
}
