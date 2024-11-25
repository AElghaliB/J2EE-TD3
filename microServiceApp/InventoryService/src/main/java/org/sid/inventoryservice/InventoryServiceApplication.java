package org.sid.inventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.sid.inventoryservice.repositories.ProductRepositorie;
import org.sid.inventoryservice.entities.Product;



import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);

	}


	@Bean
	CommandLineRunner start(ProductRepositorie productRepositorie, RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Product.class);
			productRepositorie.saveAll(
					List.of(
							Product.builder().name("lunnette").quantity(12).price(200).build(),
							Product.builder().name("casque").quantity(12).price(200).build(),
							Product.builder().name("sac").quantity(12).price(200).build()
					)
			);
		};
	}


}
