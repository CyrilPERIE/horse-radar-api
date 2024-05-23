package fr.horseradar.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.horseradar.api.model.Horse;
import fr.horseradar.api.repository.HorseRepository;

@Configuration
public class LoadDatabase {

	  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	  
	  //All CommandLineRunner are run once the application context is loaded
	  @Bean
	  CommandLineRunner initDatabase(HorseRepository horseRepository) {

	    return args -> {
	      log.info("Preloading " + horseRepository.save(new Horse("Bilbo Baggins", "burglar")));
	      log.info("Preloading " + horseRepository.save(new Horse("Frodo Baggins", "thief")));
	    };
	  }
	  
}
