package pt.bitclinic.javasbssws01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.bitclinic.javasbssws01.entities.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
