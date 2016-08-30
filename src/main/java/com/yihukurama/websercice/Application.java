package com.yihukurama.websercice;

/**
 * 启动服务
 *
 */
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;



@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
public class Application extends SpringBootServletInitializer{
	private Logger logger = Logger.getLogger(Application.class);
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("启动服务");
		return application.sources(Application.class);
    }

    
    public static void main(String[] args) throws Exception {
    		
        SpringApplication.run(Application.class, args);
    }
    
}