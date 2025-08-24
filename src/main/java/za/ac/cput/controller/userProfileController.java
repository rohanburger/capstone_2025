package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Factory.BankDetailsFactory;
import za.ac.cput.domain.BankBranch;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.domain.User;
import za.ac.cput.service.BankBranchService;
import za.ac.cput.service.BankDetailsService;
import za.ac.cput.service.UserService;

@Controller
@RequestMapping("/userProfile")
public class userProfileController {

    private UserService userService;
    private BankDetailsService bankDetailsService;
    private BankBranchService bankBranchService;

    @Autowired
    userProfileController(UserService userService, BankDetailsService bankDetailsService, BankBranchService bankBranchService){
        this.userService = userService;
        this.bankDetailsService = bankDetailsService;
        this.bankBranchService = bankBranchService;
    }

    @GetMapping
    public String getUserProfile(HttpSession session , Model model){
        User user = (User) session.getAttribute("user");

        if(user == null){
            return "redirect:/userRegister";
        }

        User userProfile = userService.read(user.getUserId());
        model.addAttribute("user",userProfile);
        model.addAttribute("bankdetails", userProfile.getBankdetails());
        model.addAttribute("branches",bankBranchService.getAll());
        return "userProfile";

    }
    @PostMapping("/update")
    public String updateProfile(
            @RequestParam("userId") Long userId,
            @RequestParam("name") String userName,
            @RequestParam("surname") String userSurname,
            @RequestParam("phoneNumber") String userPhoneNum,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("cardNumber") String cardNumber,
            @RequestParam("cardExpiry") String cardExpiry,
            @RequestParam("cardCvv") String cardCvv,
            @RequestParam("branchId") Long branchId,
            HttpSession session) {


        User oldUser = userService.read(userId);
        if (oldUser == null) return "redirect:/userProfile?error=UserNotFound";

        BankDetails oldBank = oldUser.getBankdetails();
        BankDetails newBank = new BankDetails.Builder()
                .copy(oldBank)
                .setBankCardNum(cardNumber)
                .setBankCardDate(cardExpiry)
                .setBankCardCVV(cardCvv)
                .setBankBranch(bankBranchService.read(branchId))
                .build();

        User updatedUser = new User.UserBuilder().copy(oldUser)
                .setUserName(userName)
                .setUserSurname(userSurname)
                .setUserPhoneNum(userPhoneNum)
                .setUserEmail(email)
                .setUserPassword(password)
                .setBankdetails(newBank)
                .build();

        userService.update(updatedUser);
        session.setAttribute("user", updatedUser);

        return "redirect:/userProfile";
    }

    @PostMapping("/delete")
    public String deleteUserProfile(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            userService.delete(user.getUserId());  // Make sure UserService has a delete method
            session.invalidate(); // Log out user after deletion
        }
        return "redirect:/"; // Redirect to homepage after deletion
    }



    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
