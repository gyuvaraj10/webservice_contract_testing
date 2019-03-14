package com.provider.tests.tests;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;

/**
 * Created by Yuvaraj on 27/01/2018.
 */
@RunWith(PactRunner.class)
@Provider("yuvaraj_create")
@PactBroker()
@VerificationReports(value = "markdown")
//@PactFolder("target/pacts/")
//@PactBroker(host = "ec2-35-178-11-4.eu-west-2.compute.amazonaws.com", port = "80")
public class UserCreateServiceProviderTest {

    @TestTarget
    public final Target target = new HttpTarget(8080);

    @State(value = "I have a service that can create a user")
    public void verifyState() {

    }
}
