package pt.bitclinic.javasbssws01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.bitclinic.javasbssws01.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
