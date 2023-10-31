package com.basecs101.gettingstartedwithrestapp.restservice;


import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Slf4j
public class GreetingController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GreetingController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * returns a greeting msg with id
     * @param msgValue
     * @return Greeting
     * Example request -> `<a href="http://localhost:8080/greeting?msg=vikram">...</a>`
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "msg", defaultValue = "World") String msgValue) {

        return new Greeting(counter.incrementAndGet(), String.format(template, msgValue));
    }

    @GetMapping("/testLog")
    public String testLog(){
        log.error("greeting method called...error log");
        log.warn("greeting method called...warn log");
        log.info("greeting method called...info log");
        log.debug("greeting method called...debug log");
        log.trace("greeting method called... trace log");
        return "Log method called";
    }

}
