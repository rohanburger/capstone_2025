package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.Driver;
import za.ac.cput.service.DriverService;

@Controller
@RequestMapping("/driverLogin")
public class DriverLoginController {

    private DriverService driverService;
    @Autowired
    public DriverLoginController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public String showLoginPage() {
        return "driverLogin"; // This should match your Thymeleaf/HTML template name
    }

    @PostMapping//Hanles the /driverLogin POST request
    public String driverLogin(@RequestParam("email") String email, // Captures the email and password from the form
                              @RequestParam("password") String password,
                              HttpSession session) {
        Driver driver = driverService.findByDriverEmailAndDriverPassword(email, password); // Calls the findByEmailAndPassword method in the DriverService class to find the driver with the specified email and password
        if (driver == null) {
            return "redirect:/driverLogin?error=true";
        }
        session.setAttribute("user", driver); // Set the user attribute in the session to the driver object that was found in the database
        session.setAttribute("role", "driver");// Set the role attribute in the session to "driver"
        return "redirect:/";
    }
}
