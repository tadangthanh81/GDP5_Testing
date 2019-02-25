package com.cmcglobal;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingSystemApplication {
//	Logger logger = LogManager.getLogger(TestingSystemApplication.class);
//	private static final Logger logger = LoggerFactory.getLogger(TestingSystemApplication.class);
	private static final Logger logger = Logger.getLogger(TestingSystemApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TestingSystemApplication.class, args);
	    logger.info("Run App Success ");
	}
}
