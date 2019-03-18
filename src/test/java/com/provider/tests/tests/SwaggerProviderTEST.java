//package com.provider.tests.tests;
//
//import au.com.dius.pact.model.OptionalBody;
//import au.com.dius.pact.model.RequestResponseInteraction;
//import au.com.dius.pact.model.Response;
//import com.atlassian.oai.validator.OpenApiInteractionValidator;
//import com.atlassian.oai.validator.pact.*;
//import com.atlassian.oai.validator.report.ValidationReport;
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//
//public class SwaggerProviderTEST {
////    @Rule
////    public ValidatedPactProviderRule provider =
////            new ValidatedPactProviderRule("http://localhost:8080/v2/api-docs", null, "atom_mule", this);
//
//
//    @Test
//    public void test() {
////        final RequestResponseInteraction interaction = new RequestResponseInteraction();
////        Response response = new Response();
////        response.setBody(OptionalBody.body());
////        interaction.setResponse();
//        final OpenApiInteractionValidator validator = OpenApiInteractionValidator
//                .createFor("http://localhost:8080/v2/api-docs")
//                .build();
//        final ValidationReport report = validator.validate(
//                new PactRequest(interaction.getRequest()),
//                new PactResponse(interaction.getResponse()));
//        Assert.assertTrue(report.hasErrors());
//
////        final PactProviderValidator validator =
////                PactProviderValidator
////                        .createFor("http://localhost:8080/v2/api-docs")
////                        .withConsumer("atom_mule", "/Users/yuvaraj.gunisetti/poc/webservice_contract_testing/src/test/resources/swagger-mock-validator/pact.json")
////                        .build();
////
////        final PactProviderValidationResults results = validator.validate();
////
////        String report = results.getValidationFailureReport();
////        Assert.assertFalse(results.hasErrors());
//    }
//
//
//}
