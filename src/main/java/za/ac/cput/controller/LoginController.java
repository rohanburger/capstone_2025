package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.User;
import za.ac.cput.service.DriverService;
import za.ac.cput.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private DriverService driverService;

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


    @PostMapping("/driverLogin")
    public String driverLogin(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              HttpSession session) {
        Driver driver = driverService.findByDriverEmailAndDriverPassword(email, password);
        if (driver == null) {
            return "redirect:/driverLogin?error=true";
        }
        session.setAttribute("user", driver);
        session.setAttribute("role", "driver");
        return "redirect:/";
    }
}
