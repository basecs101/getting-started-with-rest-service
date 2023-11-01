package com.basecs101.restapp.configs;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * BeanPrinterConfigClass for printing spring managed beans
 */
@Configuration
//@Slf4j
public class BeanPrinterConfigClass implements InitializingBean {

    @Value(value = "${server.port}")
    int port;
    @Autowired
    private ApplicationContext applicationContext;
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(BeanPrinterConfigClass.class);

    @Override
    @Profile("test")
    public void afterPropertiesSet() {
        log.info("port : {}", port);
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            log.info("Spring managed Bean Name: " + beanName);
            log.info("----------------------------------");
        }
    }
}
