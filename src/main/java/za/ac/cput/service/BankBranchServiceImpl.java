package za.ac.cput.service;

import za.ac.cput.domain.BankBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.BankBranchRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankBranchServiceImpl implements BankBranchService {

    private final BankBranchRepository repository;

    @Autowired
    public BankBranchServiceImpl(BankBranchRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankBranch create(BankBranch bankBranch) {
        return repository.save(bankBranch);
    }

    @Override
    public BankBranch read(String branchId) {
        Optional<BankBranch> optional = repository.findById(branchId);
        return optional.orElse(null);
    }

    @Override
    public BankBranch update(BankBranch bankBranch) {
        if (repository.existsById(bankBranch.getBankBranchId())) {
            return repository.save(bankBranch);
        }
        return null;
    }

    @Override
    public boolean delete(String branchId) {
        if (repository.existsById(branchId)) {
            repository.deleteById(branchId);
            return true;
        }
        return false;
    }

    @Override
    public List<BankBranch> getAll() {
        return repository.findAll();
    }
}
