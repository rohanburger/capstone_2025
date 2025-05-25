package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.BankDetails;

public interface BankDetailsRepository extends JpaRepository<BankDetails, String> {
}
