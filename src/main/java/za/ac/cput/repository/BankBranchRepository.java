package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.BankBranch;
@Repository
public interface BankBranchRepository extends JpaRepository<BankBranch, Long> {
}
