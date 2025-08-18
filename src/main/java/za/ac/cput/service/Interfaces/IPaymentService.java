package za.ac.cput.service.Interfaces;

import za.ac.cput.domain.Payment;

import java.util.List;

public interface IPaymentService extends IService<Payment, Long> {
    List<Payment> getAll();
}
