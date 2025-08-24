package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        session.invalidate(); // Ends the user session
        return "redirect:/";   // Redirect to homepage or login page
    }
}
