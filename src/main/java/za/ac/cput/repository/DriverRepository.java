package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Driver;

/*
    DriverRepository.java
    Driver RepositoryClass
    Author: Kyle Bowers
    Date: 25/05/2025
*/

@Repository
public interface DriverRepository extends JpaRepository<Driver, String>{
}
