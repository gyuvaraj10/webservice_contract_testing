package com.provider.tests.tests;

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
@Provider("xmlProvider")
@PactFolder("target/pacts/")
public class BooksCreateServiceProviderTest {

    @TestTarget
    public final Target target = new HttpTarget(8080);

//    @State(value = "I have a user named Yuvaraj")
//    public void verifyState() {
//
//    }


    @State(value = "I have a book")
    public void verifyStateParamesh() {

    }
}
