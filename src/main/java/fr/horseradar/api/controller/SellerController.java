package fr.horseradar.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.horseradar.api.exception.SellerNotFoundException;
import fr.horseradar.api.model.Seller;
import fr.horseradar.api.repository.SellerRepository;

@RestController
public class SellerController {

	private final SellerRepository sellerRepository;

	SellerController(SellerRepository sellerRepository) {
	    this.sellerRepository = sellerRepository;
	  }
	
	  @GetMapping("/sellers")
	  List<Seller> all() {
	    return sellerRepository.findAll();
	  }
	  
	  @PostMapping("/sellers")
	  Seller newSeller(@RequestBody Seller newSeller) {
	    return sellerRepository.save(newSeller);
	  }
	  
	  @GetMapping("/sellers/{id}")
	  Seller one(@PathVariable Long id) {
	    
	    return sellerRepository.findById(id)
	      .orElseThrow(() -> new SellerNotFoundException(id));
	  }
	  
	  @PutMapping("/sellers/{id}")
	  Seller replaceSeller(@RequestBody Seller newSeller, @PathVariable Long id) {
	    
	    return sellerRepository.findById(id)
	      .map(seller -> {
	    	seller.setUsername(newSeller.getUsername());
	    	seller.setUrl(newSeller.getUrl());
	        return sellerRepository.save(seller);
	      })
	      .orElseGet(() -> {
	        newSeller.setId(id);
	        return sellerRepository.save(newSeller);
	      });
	  }
	  
	  @DeleteMapping("/sellers/{id}")
	  void deleteAd(@PathVariable Long id) {
	    sellerRepository.deleteById(id);
	  }
	  
}
