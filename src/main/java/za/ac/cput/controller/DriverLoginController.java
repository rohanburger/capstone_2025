package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.Driver;
import za.ac.cput.service.DriverService;

@Controller
public class DriverLoginController {

    @Autowired
    private DriverService driverService;

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
