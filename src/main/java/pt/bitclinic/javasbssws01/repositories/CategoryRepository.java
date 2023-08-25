package pt.bitclinic.javasbssws01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.bitclinic.javasbssws01.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
