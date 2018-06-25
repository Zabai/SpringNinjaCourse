package com.zarmas.ninjabackend.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("Task")
public class Task {
    private final Log log = LogFactory.getLog(Task.class);

    @Scheduled(fixedDelay = 5000)
    public void doTask() {
        log.info("Time is: " + new Date());
    }
}
