package com.logging.jsonlog.controllers;

import com.logging.jsonlog.services.LogService;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/v1")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);
    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(LogController.class);

    @Autowired
    LogService logService;

    Random rd = new Random(); // creating Random object

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public ResponseEntity<Map<String, String>> getVersionInfo() {
        Map<String, String> versionInfo = new HashMap<>();

        String version = logService.calcVersion(UUID.randomUUID().toString(),
                rd.nextInt(100),
                Arrays.asList(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        log.info("version number is {}", version);

        versionInfo.put("buildNumber", version);


        return new ResponseEntity<>(versionInfo, HttpStatus.OK);
    }
}
