package za.ac.cput.controller.DomainControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;
    @Autowired
    PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment){
        return paymentService.create(payment);
    }

    @GetMapping("/read/{paymentId}")
    public Payment read(@PathVariable Long paymentId){
        return paymentService.read(paymentId);
    }
    @PutMapping("/update")
    public Payment update(@RequestBody Payment payment){
        return paymentService.update(payment);
    }
    @DeleteMapping("/delete/{paymentId}")
    public boolean delete(@PathVariable Long paymentId){
        return paymentService.delete(paymentId);
    }
    @GetMapping("/all")
    public List<Payment> getAll(){
        return paymentService.getAll();
    }
}
