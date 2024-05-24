package fr.horseradar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.horseradar.api.model.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {

}
