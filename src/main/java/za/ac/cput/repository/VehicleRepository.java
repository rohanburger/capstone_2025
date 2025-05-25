package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Vehicle;

/*
    VehicleRepository.java
    Vehicle Repository Class
    Author: Kyle Bowers
    Date: 25/05/2025
*/

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
