package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.BankBranch;

public interface BankBranchRepository extends JpaRepository<BankBranch, String> {
}
