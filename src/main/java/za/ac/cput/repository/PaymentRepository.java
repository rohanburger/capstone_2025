package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
/*
    PaymentRepository.java
    Payment Repository Class
    Author:Rohan Janzen Burger 230171990
    Date:18/08/2025
*/

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>  {//Crud methods implemented

}
