package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Pickup;

@Repository
public interface PickupRepository extends JpaRepository<Pickup, Long> {
}
