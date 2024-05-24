package fr.horseradar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.horseradar.api.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
