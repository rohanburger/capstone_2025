package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Location;


public interface LocationRepository extends JpaRepository<Location, String> {
}
