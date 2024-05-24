package fr.horseradar.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.horseradar.api.exception.AdNotFoundException;
import fr.horseradar.api.model.Ad;
import fr.horseradar.api.repository.AdRepository;

@RestController
public class AdController {

	private final AdRepository adRepository;

	AdController(AdRepository adRepository) {
	    this.adRepository = adRepository;
	  }
	
	  @GetMapping("/ads")
	  List<Ad> all() {
	    return adRepository.findAll();
	  }
	  
	  @PostMapping("/ads")
	  Ad newAd(@RequestBody Ad newAd) {
	    return adRepository.save(newAd);
	  }
	  
	  @GetMapping("/ads/{id}")
	  Ad one(@PathVariable Long id) {
	    
	    return adRepository.findById(id)
	      .orElseThrow(() -> new AdNotFoundException(id));
	  }
	  
	  @PutMapping("/ads/{id}")
	  Ad replaceAd(@RequestBody Ad newAd, @PathVariable Long id) {
	    
	    return adRepository.findById(id)
	      .map(ad -> {
	    	 ad.setPlatform(newAd.getPlatform());
	    	 ad.setTitle(newAd.getTitle());
	    	 ad.setBody(newAd.getBody());
	    	 ad.setPictures(newAd.getPictures());
	    	 ad.setSeller(newAd.getSeller());
	    	 ad.setHorse(newAd.getHorse());
	        return adRepository.save(ad);
	      })
	      .orElseGet(() -> {
	        newAd.setId(id);
	        return adRepository.save(newAd);
	      });
	  }
	  
	  @DeleteMapping("/ads/{id}")
	  void deleteAd(@PathVariable Long id) {
	    adRepository.deleteById(id);
	  }
	  
}
