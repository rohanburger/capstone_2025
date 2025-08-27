package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

@Controller
public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/userLogin")
    public String userLogin(@RequestParam("email") String email,// Captures the email and password from the form
                            @RequestParam("password") String password,// Captures the email and password from the form
                            HttpSession session) {// Handles the /userLogin POST request
        User user = userService.findByEmailAndPassword(email, password);// Calls the findByEmailAndPassword method in the UserService class to find the user with the specified email and password
        if (user == null) {
            return "redirect:/userLogin?error=true";
        }
        session.setAttribute("user", user);// Set the user attribute in the session to the user object that was found in the database
        session.setAttribute("role", "passenger");// Set the role attribute in the session to "passenger"
        return "redirect:/";
    }
}
