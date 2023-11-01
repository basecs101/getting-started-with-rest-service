package com.basecs101.restapp.restservice;


import java.util.concurrent.atomic.AtomicLong;

import com.basecs101.restapp.exception.CustomException;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("/greeting")
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
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

    @RequestMapping(value = "/exception", method = RequestMethod.POST)
    public void throwException(){
        throw new CustomException("Exception thrown from RestController");
    }

}
