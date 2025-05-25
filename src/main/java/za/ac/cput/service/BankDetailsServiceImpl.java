package za.ac.cput.service;

import za.ac.cput.domain.BankDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.BankDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsServiceImpl implements BankDetailsService {

    private final BankDetailsRepository repository;

    @Autowired
    public BankDetailsServiceImpl(BankDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankDetails create(BankDetails bankDetails) {
        return repository.save(bankDetails);
    }

    @Override
    public BankDetails read(String bankId) {
        Optional<BankDetails> optional = repository.findById(bankId);
        return optional.orElse(null);
    }

    @Override
    public BankDetails update(BankDetails bankDetails) {
        if (repository.existsById(bankDetails.getBankBranch().getBankBranchId())) {
            return repository.save(bankDetails);
        }
        return null;
    }

    @Override
    public boolean delete(String bankId) {
        if (repository.existsById(bankId)) {
            repository.deleteById(bankId);
            return true;
        }
        return false;
    }

    @Override
    public List<BankDetails> getAll() {
        return repository.findAll();
    }
}
