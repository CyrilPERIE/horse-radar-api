package fr.horseradar.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.horseradar.api.enumeration.Platform;
import fr.horseradar.api.model.Ad;
import fr.horseradar.api.model.Horse;
import fr.horseradar.api.model.Seller;
import fr.horseradar.api.repository.AdRepository;
import fr.horseradar.api.repository.HorseRepository;
import fr.horseradar.api.repository.SellerRepository;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(HorseRepository horseRepository, SellerRepository sellerRepository, AdRepository adRepository) {
        return args -> {
            // Create Sellers
            Seller seller1 = new Seller();
            seller1.setUsername("john_doe");
            seller1.setUrl("http://example.com/john");

            Seller seller2 = new Seller();
            seller2.setUsername("jane_smith");
            seller2.setUrl("http://example.com/jane");

            Seller seller3 = new Seller();
            seller3.setUsername("bob_brown");
            seller3.setUrl("http://example.com/bob");

            // Save Sellers
            sellerRepository.saveAll(Arrays.asList(seller1, seller2, seller3));

            // Create Horses
            Horse horse1 = new Horse();
            horse1.setDate(new Date());
            horse1.setRelevance(10.0f);
            horse1.setPrice(1000);

            Horse horse2 = new Horse();
            horse2.setDate(new Date());
            horse2.setRelevance(9.5f);
            horse2.setPrice(1500);

            Horse horse3 = new Horse();
            horse3.setDate(new Date());
            horse3.setRelevance(8.5f);
            horse3.setPrice(1200);

            Horse horse4 = new Horse();
            horse4.setDate(new Date());
            horse4.setRelevance(7.5f);
            horse4.setPrice(1800);
            
            // Save Horses
            horseRepository.saveAll(Arrays.asList(horse1, horse2, horse3, horse4));

            // Create Ads
            Ad ad1 = new Ad(seller1, horse1, Platform.LEBONCOIN, "Ad Title 1", "Ad Body 1", Arrays.asList("pic1.jpg", "pic2.jpg"));
            Ad ad2 = new Ad(seller1, horse2, Platform.MARKETPLACE, "Ad Title 2", "Ad Body 2", Arrays.asList("pic3.jpg", "pic4.jpg"));
            Ad ad3 = new Ad(seller1, horse3, Platform.INSTAGRAM, "Ad Title 3", "Ad Body 3", Arrays.asList("pic5.jpg", "pic6.jpg"));
            Ad ad4 = new Ad(seller2, horse1, Platform.EQUIRADAR, "Ad Title 4", "Ad Body 4", Arrays.asList("pic7.jpg", "pic8.jpg"));
            Ad ad5 = new Ad(seller2, horse2, Platform.LEBONCOIN, "Ad Title 5", "Ad Body 5", Arrays.asList("pic9.jpg", "pic10.jpg"));
            Ad ad6 = new Ad(seller2, horse3, Platform.MARKETPLACE, "Ad Title 6", "Ad Body 6", Arrays.asList("pic11.jpg", "pic12.jpg"));
            Ad ad7 = new Ad(seller3, horse1, Platform.INSTAGRAM, "Ad Title 7", "Ad Body 7", Arrays.asList("pic13.jpg", "pic14.jpg"));
            Ad ad8 = new Ad(seller3, horse2, Platform.EQUIRADAR, "Ad Title 8", "Ad Body 8", Arrays.asList("pic15.jpg", "pic16.jpg"));
            Ad ad9 = new Ad(seller3, horse3, Platform.LEBONCOIN, "Ad Title 9", "Ad Body 9", Arrays.asList("pic17.jpg", "pic18.jpg"));
            Ad ad10 = new Ad(seller3, horse4, Platform.MARKETPLACE, "Ad Title 10", "Ad Body 10", Arrays.asList("pic19.jpg", "pic20.jpg"));

            // Save Ads
            adRepository.saveAll(Arrays.asList(ad1, ad2, ad3, ad4, ad5, ad6, ad7, ad8, ad9, ad10));

        };
    }
}
