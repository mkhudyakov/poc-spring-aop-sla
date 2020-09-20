package com.poc.spring.aop.sla.controller;

import com.poc.spring.aop.sla.annotation.LatencyWatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.ALL_VALUE;

@LatencyWatcher
@RestController
public class StatusController {

    @GetMapping(value = "/status", consumes = ALL_VALUE, produces = ALL_VALUE)
    public String getStatus() {
        return "OK";
    }
}
