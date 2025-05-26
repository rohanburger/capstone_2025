package za.ac.cput.repository;

/*
    DropoffRepository.java
    Dropoff Repository Class
    Author:Sharief Abdul
    Date:08/05/2025
*/


import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Dropoff;
import za.ac.cput.domain.Location;

public interface DropoffRepository extends JpaRepository<Dropoff, String> {
}
