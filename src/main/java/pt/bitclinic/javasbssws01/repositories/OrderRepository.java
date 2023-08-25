package pt.bitclinic.javasbssws01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.bitclinic.javasbssws01.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
