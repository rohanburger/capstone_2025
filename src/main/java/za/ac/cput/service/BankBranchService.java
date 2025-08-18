package za.ac.cput.service;

import za.ac.cput.domain.BankBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.BankBranchRepository;
import za.ac.cput.service.Interfaces.IBankBranchService;

import java.util.List;
import java.util.Optional;

@Service
public class BankBranchService implements IBankBranchService {
    private BankBranchRepository repository;

    @Autowired
     BankBranchService(BankBranchRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankBranch create(BankBranch bankBranch) {
        return this.repository.save(bankBranch);
    }

    @Override
    public BankBranch read(Long branchId) {
      return this.repository.findById(branchId).orElse(null);
    }

    @Override
    public BankBranch update(BankBranch bankBranch) {
        return this.repository.save(bankBranch);
    }

    @Override
    public boolean delete(Long branchId) {
      repository.deleteById(branchId);
      return true;
    }

    @Override
    public List<BankBranch> getAll() {
        return this.repository.findAll();
    }
}
