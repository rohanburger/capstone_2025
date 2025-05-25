package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, String>  {//Crud methods implemented

}
