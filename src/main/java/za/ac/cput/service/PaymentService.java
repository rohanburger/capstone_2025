package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private static IPaymentService service;
    private static PaymentRepository repository;

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public boolean delete(String s) {
        repository.deleteById(s);
        return true;
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }
}
