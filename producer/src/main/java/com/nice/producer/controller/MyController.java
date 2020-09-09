package com.nice.producer.controller;

import com.nice.producer.service.ProducerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="nice")
public class MyController {

    private static Logger logger = LogManager.getLogger(MyController.class);

    @Autowired
    private ProducerService service;

    @PostMapping("/message")
    public ResponseEntity<String> handleMessage(@RequestParam String message) {
        try {
            return ResponseEntity.ok(this.service.handleMessage(message));
        } catch (Exception e) {
            logger.warn("Caught exception in getResult: " + e.toString());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
