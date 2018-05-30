package com.consumer.tests;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import io.pactfoundation.consumer.dsl.LambdaDsl;
import org.junit.Test;

public class V3ConsumergenerationTest {

    @Test
    public void test() {
        DslPart dslPart = LambdaDsl.newJsonBody(body->{
           body.stringValue("ss","sss")
                   .object("obj", x->{
                        x.booleanType("boo");
                   });
        }).build();
        System.out.println(dslPart.getBody().toString());
    }
}
