package com.pact.poc;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Yuvaraj on 26/01/2018.
 */
@RestController
@RequestMapping(path = "/get")
public class BooksProviderController {

    @RequestMapping(method = RequestMethod.GET, path = "/books", produces = "application/xml")
    public ResponseEntity<String> getUsersInformation() throws IOException {
        String sampleXML = IOUtils.toString(this.getClass().getResourceAsStream("/samplexml.xml"),
                Charset.defaultCharset());
        ResponseEntity entity = new ResponseEntity<>(sampleXML, HttpStatus.OK);
        return new ResponseEntity<>(sampleXML, HttpStatus.OK);
    }
}
