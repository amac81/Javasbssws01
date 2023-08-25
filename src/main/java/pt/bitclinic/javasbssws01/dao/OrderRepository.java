package pt.bitclinic.javasbssws01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.bitclinic.javasbssws01.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
