package com.zarmas.ninjabackend.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {
    private final Log LOGGER = LogFactory.getLog(ExampleComponent.class);

    public void sayHello() {
        LOGGER.info("Hello from ExampleComponent class");
    }
}
