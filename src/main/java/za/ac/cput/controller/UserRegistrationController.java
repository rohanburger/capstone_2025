package za.ac.cput.controller;


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
    public String createUserPage(Model model) {// Handles the /userRegister GET request
        model.addAttribute("branches",bankBranchService.getAll());// Adds the bank branch list to the model
        return "userRegister";

    }
    @PostMapping("/create")
    public String createUser(//
            @RequestParam("name") String name,// Captures the name from the form
            @RequestParam("surname") String surname,// Captures the surname from the form
            @RequestParam("phoneNumber") String phoneNumber,// Captures the phoneNumber from the form
            @RequestParam("email") String email,// Captures the email from the form
            @RequestParam("password") String password,// Captures the password from the form
            @RequestParam("cardNumber") String cardNumber,// Captures the cardNumber from the form
            @RequestParam("cardExpiry") String cardExpiry,// Captures the cardExpiry from the form
            @RequestParam("cardCvv") String cardCvv,// Captures the cardCvv from the form
            @RequestParam("branchId") Long branchId,// Captures the branchId from the form
            HttpSession session,// Captures the session object from the form
            Model model// Captures the model object from the form
    ) {

        if (userService.existsByEmail(email)) {// Checks if the email is already in use
            model.addAttribute("branches", bankBranchService.getAll());// Adds the bank branch list to the model
            model.addAttribute("error", "Email already exists!");
            return "userRegister";
        }

        if (bankDetailsService.existsByCardNumber(cardNumber)) {// Checks if the card number is already in use
            model.addAttribute("branches", bankBranchService.getAll());// Adds the bank branch list to the model
            model.addAttribute("error", "Card number already exists!");
            return "userRegister";
        }

        BankBranch branch = bankBranchService.read(branchId);//Creates a new BankBranch object with the specified branchId

        try {
            BankDetails bankDetails = BankDetailsFactory.createBankDetails(cardNumber,cardExpiry,cardCvv,branch);//Creates a new BankDetails object with the specified cardNumber, cardExpiry, and cardCvv
            User user = UserFactory.createUserWithAllAttributes(name, surname, phoneNumber, email, password, bankDetails);//Creates a new User object with the specified name, surname, phoneNumber, email, password, and bankDetails
            userService.create(user);//Calls the create method in the UserService class to create the user
            session.setAttribute("user", user);//Sets the user object to the session attribute "user"
            session.setAttribute("role", "passenger");//Sets the role attribute in the session to "passenger"
            return "redirect:/";
        } catch (IllegalArgumentException e) {//Handles any IllegalArgumentExceptions that may be thrown during the creation of the user
            model.addAttribute("branches", bankBranchService.getAll());//Adds the bank branch list to the model
            model.addAttribute("error", e.getMessage());//If an IllegalArgumentException is thrown, display the exception message
            return "userRegister";
        }
    }
}
