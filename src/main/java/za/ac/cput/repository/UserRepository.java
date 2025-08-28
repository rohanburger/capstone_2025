package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserEmailAndUserPassword(String email, String password); //Get a user based on email and password
    // Optional returns .isempty instead of providing a null
    boolean existsByUserEmail(String email);//Checks if user email exists

}
