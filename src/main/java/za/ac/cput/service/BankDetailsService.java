package za.ac.cput.service;

import za.ac.cput.domain.BankDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.BankDetailsRepository;
import za.ac.cput.service.Interfaces.IBankDetailsService;

import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsService implements IBankDetailsService {

    private  BankDetailsRepository repository;

    @Autowired
     BankDetailsService(BankDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankDetails create(BankDetails bankDetails) {
        return this.repository.save(bankDetails);
    }

    @Override
    public BankDetails read(Long bankId) {
        return this.repository.findById(bankId).orElse(null);
    }

    @Override
    public BankDetails update(BankDetails bankDetails) {
      return repository.save(bankDetails);
    }

    @Override
    public boolean delete(Long bankId) {
        repository.deleteById(bankId);
        return true;
    }

    @Override
    public List<BankDetails> getAll() {
        return this.repository.findAll();
    }

    public boolean existsByCardNumber(String cardNumber) {
        return repository.existsBybankCardNum(cardNumber);
    }
}
