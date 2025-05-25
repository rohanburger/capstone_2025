package za.ac.cput.service;

import za.ac.cput.domain.BankBranch;
import java.util.List;

public interface BankBranchService {
    BankBranch create(BankBranch bankBranch);
    BankBranch read(String id);
    BankBranch update(BankBranch bankBranch);
    boolean delete(String id);
    List<BankBranch> getAll();
}
