package za.ac.cput.controller.DomainControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.service.BankDetailsService;

import java.util.List;

@RestController
@RequestMapping("/bankdetails")
public class BankDetailsController {

    private BankDetailsService bankDetailsService;
    @Autowired
    BankDetailsController(BankDetailsService bankDetailsService){
        this.bankDetailsService = bankDetailsService;
    }

    @PostMapping("/create")
    public BankDetails create(@RequestBody BankDetails bankDetails){
        return bankDetailsService.create(bankDetails);
    }

    @GetMapping("/read/{bankId}")
    public BankDetails read(@PathVariable Long bankId){
        return bankDetailsService.read(bankId);
    }

    @PutMapping("/update")
    public BankDetails update(@RequestBody BankDetails bankDetails){
        return bankDetailsService.update(bankDetails);
    }

    @DeleteMapping("/delete/{bankId}")
    public boolean delete(@PathVariable Long bankId){
        return bankDetailsService.delete(bankId);
    }

    @GetMapping("/all")
    public List<BankDetails> getAll(){
        return bankDetailsService.getAll();
    }
}
