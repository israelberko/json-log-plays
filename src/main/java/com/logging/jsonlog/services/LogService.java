package com.logging.jsonlog.services;


import com.logging.jsonlog.controllers.LogController;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);
    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(LogController.class);
    Random rd = new Random(); // creating Random object

    public String calcVersion(String str, Integer num, List<String> lst){
        log.info("generating random version number");

        return Integer.toString(rd.nextInt());
    }
}
