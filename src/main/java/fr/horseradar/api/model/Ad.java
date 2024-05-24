package fr.horseradar.api.model;

import java.time.ZonedDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import fr.horseradar.api.enumeration.Platform;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;    
	@CreationTimestamp
    private ZonedDateTime date;
	@Enumerated(EnumType.STRING)
	private Platform platform;
	private String title;
	private String body;
	@ElementCollection
	private List<String> pictures;
	@ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
	private Seller seller;
	@ManyToOne
    @JoinColumn(name = "horse_id", nullable = false)
    private Horse horse;
	
	public Ad(Seller seller, Horse horse, Platform platform, String title, String body, List<String> pictures) {
		this.seller = seller;
		this.horse = horse;
		this.platform = platform;
		this.title = title;
		this.body = body;
		this.pictures = pictures;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	
	public Platform getPlatform() {
		return platform;
	}
	
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public List<String> getPictures() {
		return pictures;
	}
	
	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}
	
	public Seller getSeller() {
		return seller;
	}
	
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

}
