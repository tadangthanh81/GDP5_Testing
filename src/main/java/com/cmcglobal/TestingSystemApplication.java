package com.cmcglobal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestingSystemApplication {
//	private static final Logger logger = LogManager.getLogger(TestingSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestingSystemApplication.class, args);
		
	}
	
//    public void run(ApplicationArguments applicationArguments) throws Exception {
//        logger.debug("Debugging log");
//        logger.info("Info log");
//        logger.warn("Hey, This is a warning!");
//        logger.error("Oops! We have an Error. OK");
//        logger.fatal("Damn! Fatal error. Please fix me.");
//    }

}

