package com.poc.spring.aop.sla.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private static final Logger LOG = LoggerFactory.getLogger(LogService.class);

    public void log(String method, long latencyMilliseconds) {
        LOG.info(String.format("Latency for %s is %d ms", method, latencyMilliseconds));
    }
}
