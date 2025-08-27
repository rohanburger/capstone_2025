package za.ac.cput.controller.Finished;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Factory.BankDetailsFactory;
import za.ac.cput.Factory.UserFactory;
import za.ac.cput.domain.BankBranch;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.domain.User;
import za.ac.cput.service.BankBranchService;
import za.ac.cput.service.BankDetailsService;
import za.ac.cput.service.UserService;

@Controller
@RequestMapping("/userRegister")
public class UserRegistrationController {

    private UserService userService;
    private BankBranchService bankBranchService;
    private BankDetailsService bankDetailsService;
    @Autowired
    UserRegistrationController(UserService userService, BankBranchService bankBranchService,BankDetailsService bankDetailsService){
        this.userService = userService;
        this.bankBranchService = bankBranchService;
        this.bankDetailsService = bankDetailsService;
    }

    @GetMapping
    public String createUserPage(Model model) {
        model.addAttribute("branches",bankBranchService.getAll());
        return "userRegister";

    }
    @PostMapping("/create")
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("cardNumber") String cardNumber,
            @RequestParam("cardExpiry") String cardExpiry,
            @RequestParam("cardCvv") String cardCvv,
            @RequestParam("branchId") Long branchId,
            HttpSession session,
            Model model
    ) {

        if (userService.existsByEmail(email)) {
            model.addAttribute("branches", bankBranchService.getAll());
            model.addAttribute("error", "Email already exists!");
            return "userRegister";
        }

        if (bankDetailsService.existsByCardNumber(cardNumber)) {
            model.addAttribute("branches", bankBranchService.getAll());
            model.addAttribute("error", "Card number already exists!");
            return "userRegister";
        }

        BankBranch branch = bankBranchService.read(branchId);

        try {
            BankDetails bankDetails = BankDetailsFactory.createBankDetails(cardNumber,cardExpiry,cardCvv,branch);
            User user = UserFactory.createUserWithAllAttributes(name, surname, phoneNumber, email, password, bankDetails);
            userService.create(user);
            session.setAttribute("user", user);
            session.setAttribute("role", "passenger");
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("branches", bankBranchService.getAll());
            model.addAttribute("error", e.getMessage());
            return "userRegister";
        }
    }
}
