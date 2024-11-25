package org.sid.inventoryservice.repositories;


import org.sid.inventoryservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface ProductRepositorie extends JpaRepository<Product, Long> {

}
