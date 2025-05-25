package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Pickup;
import za.ac.cput.domain.Session;
@Repository
public interface SessionRepository extends JpaRepository<Session, String> {

    Session findBySessionId(String sessionId);

}
