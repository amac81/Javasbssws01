package pt.bitclinic.javasbssws01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.bitclinic.javasbssws01.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
