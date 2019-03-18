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

@RunWith(PactRunner.class)
@Provider("thought_machine")
@PactBroker()
@VerificationReports(value = "markdown")
public class AccountsServiceProviderTest {


    @TestTarget
    public final Target target = new HttpTarget(8080);

    @State(value = "thought machine has fixed saver account details")
    public void verifyState() {

    }

}
