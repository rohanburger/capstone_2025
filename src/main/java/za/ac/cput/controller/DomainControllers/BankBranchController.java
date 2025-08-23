package za.ac.cput.controller.DomainControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.BankBranch;
import za.ac.cput.service.BankBranchService;

import java.util.List;

@RestController
@RequestMapping("/bankbranch")
public class BankBranchController {

    private BankBranchService bankBranchService;
    @Autowired BankBranchController(BankBranchService bankBranchService){
        this.bankBranchService = bankBranchService;
    }

    @PostMapping("/create")
    public BankBranch create(@RequestBody BankBranch bankBranch) {
        return bankBranchService.create(bankBranch);
    }

    @GetMapping("/read/{branchId}")
    public BankBranch read(@PathVariable Long branchId){
        return bankBranchService.read(branchId);
    }

    @PutMapping("/update")
    public BankBranch update(@RequestBody BankBranch bankBranch) {
        return bankBranchService.update(bankBranch);
    }

    @DeleteMapping("/delete/{branchId}")
    public boolean delete(@PathVariable Long branchId) {
        return bankBranchService.delete(branchId);
    }

    @GetMapping("/all")
    public List<BankBranch> getAll() {
        return bankBranchService.getAll();
    }

}
