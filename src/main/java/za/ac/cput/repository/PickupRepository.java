package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Pickup;

public interface PickupRepository extends JpaRepository<Pickup, String> {
}
