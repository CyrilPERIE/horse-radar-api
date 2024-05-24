package fr.horseradar.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.horseradar.api.exception.HorseNotFoundException;
import fr.horseradar.api.model.Horse;
import fr.horseradar.api.repository.HorseRepository;

@RestController
public class HorseController {
	
	private final HorseRepository horseRepository;

	HorseController(HorseRepository horseRepository) {
	    this.horseRepository = horseRepository;
	  }
	
	  @GetMapping("/horses")
	  List<Horse> all() {
	    return horseRepository.findAll();
	  }
	  
	  @PostMapping("/horses")
	  Horse newHorse(@RequestBody Horse newHorse) {
	    return horseRepository.save(newHorse);
	  }
	  
	  @GetMapping("/horses/{id}")
	  Horse one(@PathVariable Long id) {
	    
	    return horseRepository.findById(id)
	      .orElseThrow(() -> new HorseNotFoundException(id));
	  }
	  
	  @PutMapping("/horses/{id}")
	  Horse replaceHorse(@RequestBody Horse newHorse, @PathVariable Long id) {
	    
	    return horseRepository.findById(id)
	      .map(horse -> {
	    	 horse.setDate(newHorse.getDate());
	    	 horse.setRelevance(newHorse.getRelevance());
	    	 horse.setPrice(newHorse.getPrice());
	        return horseRepository.save(horse);
	      })
	      .orElseGet(() -> {
	        newHorse.setId(id);
	        return horseRepository.save(newHorse);
	      });
	  }
	  
	  @DeleteMapping("/horses/{id}")
	  void deleteHorse(@PathVariable Long id) {
	    horseRepository.deleteById(id);
	  }
	  
}
