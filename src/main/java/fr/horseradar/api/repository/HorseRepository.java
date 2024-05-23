package fr.horseradar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.horseradar.api.model.Horse;

public interface HorseRepository extends JpaRepository<Horse, Long> {
	
	

}
