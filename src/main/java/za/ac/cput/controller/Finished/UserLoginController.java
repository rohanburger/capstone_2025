package za.ac.cput.controller.Finished;

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
    public String userLogin(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session) {
        User user = userService.findByEmailAndPassword(email, password);
        if (user == null) {
            return "redirect:/userLogin?error=true";
        }
        session.setAttribute("user", user);
        session.setAttribute("role", "passenger");
        return "redirect:/";
    }
}
