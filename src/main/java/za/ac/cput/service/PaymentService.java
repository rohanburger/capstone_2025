package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;
import za.ac.cput.service.Interfaces.IPaymentService;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    private final  PaymentRepository repository;

    @Autowired public PaymentService(PaymentRepository repository){
        this.repository = repository;
    }
    @Override
    public Payment create(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public Payment read(Long s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public boolean delete(Long s) {
        repository.deleteById(s);
        return true;
    }

    @Override
    public List<Payment> getAll() {
        return this.repository.findAll();
    }
}
