package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.BankDetails;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
}
