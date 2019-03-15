package com.pact.poc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping(path = "/accounts")
public class AccountsController {

    @RequestMapping(path = "/fixed-savers", method = RequestMethod.GET)
    public ResponseEntity<List<FixedSaver>> getFixedSaverAccounts() throws IOException {
        String content = FileUtils.readFileToString(new File(this.getClass().getClassLoader().getResource("fixed-savers.json").getPath()),
                Charset.defaultCharset());
        Gson gson = new GsonBuilder().create();
        List<FixedSaver> items = gson.fromJson(content, new TypeToken<List<FixedSaver>>(){}.getType());
        return new ResponseEntity<>(items, HttpStatus.ACCEPTED);

    }

}
