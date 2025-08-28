package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Pickup;
import za.ac.cput.domain.Session;
import za.ac.cput.domain.User;

import java.util.List;

/*
    SessionRepository.java
    Session Repository Class
    Author:Rohan Janzen Burger 230171990
    Date:18/08/2025
*/
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByUserAndSessionStatus(User user, String sessionStatus);// Gets a session based on user and session status
    List<Session> findByUser_UserId(Long userId);//Gets a session based on the userId
    List<Session> findBySessionStatus(String sessionStatus);//Gets the session based on status
    List<Session> findByDriver_DriverIdAndSessionStatus(Long driverId, String sessionStatus);//Gets a session based driver id and session status
    List<Session> findByDriver_DriverId(Long driverId);//Gets a session based on driver id
}
