package za.ac.cput.service.Interfaces;

import za.ac.cput.domain.BankBranch;
import java.util.List;

public interface IBankBranchService extends IService<BankBranch,Long> {
    List<BankBranch> getAll();
}
