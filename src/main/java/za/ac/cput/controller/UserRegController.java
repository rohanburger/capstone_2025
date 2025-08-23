package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.BankBranch;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/userRegister")
public class UserRegController {
    private UserService userService;
    @Autowired
    UserRegController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public String createUserForm() {
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
            @RequestParam("branchName") String branchName,
            @RequestParam("branchCode") String branchCode,
            HttpSession session
    ) {

        BankBranch branch = new BankBranch.Builder()
                .setBankBranchName(branchName)
                .setBankBranchCode(branchCode)
                .build();

        BankDetails bankDetails = new BankDetails.Builder()
                .setBankCardNum(cardNumber)
                .setBankCardDate(cardExpiry)
                .setBankCardCVV(cardCvv)
                .setBankBranch(branch)
                .build();

        Set<BankDetails> bankDetailsSet = new HashSet<>();
        bankDetailsSet.add(bankDetails);

        User user = new User.UserBuilder()
                .setUserName(name)
                .setUserSurname(surname)
                .setUserPhoneNum(phoneNumber)
                .setUserEmail(email)
                .setUserPassword(password)
                .setBankdetails(bankDetailsSet)
                .build();


        userService.create(user);
        session.setAttribute("user", user);
        session.setAttribute("role", "passenger");

        return "redirect:/";
    }

//    @RequestMapping("/create")
//    public User create(@RequestBody User user ){
//        return userService.create(user);
//    }
//
//    @RequestMapping("/read/{userId}")
//    public User read(@PathVariable Long userId){
//        return userService.read(userId);
//    }
//
//    @RequestMapping("/update")
//    public User update(@RequestBody User user){
//        return userService.update(user);
//    }
//    @RequestMapping("/delete/{userId}")
//    public boolean delete(@PathVariable Long userId){
//        return userService.delete(userId);
//    }
//    @RequestMapping("/all")
//    public List<User> getAll(){
//        return userService.getAll();
//    }

}
