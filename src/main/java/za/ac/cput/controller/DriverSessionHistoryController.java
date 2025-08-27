package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Session;
import za.ac.cput.service.SessionService;

import java.util.List;

@Controller
@RequestMapping("/driverBookedHistory")
public class DriverSessionHistoryController {

    private  SessionService sessionService;

    @Autowired
    public DriverSessionHistoryController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public String viewDriverHistory(HttpSession httpSession, Model model) {// Handles the /driverBookedHistory GET request
        Driver driver = (Driver) httpSession.getAttribute("user");// Gets the user from the session and casts it to a Driver object
        if (driver == null) {
            return "redirect:/userRegister";
        }

        // Get all sessions for this driver
        List<Session> driverSessions = sessionService.getAllSessionsByDriver(driver.getDriverId());
        model.addAttribute("bookings", driverSessions);// sets the driverSessions object to bookings in the model
        model.addAttribute("loggedInUser", driver);// sets the Driver object to the loggedInUser in the model
        return "driverBookedHistory";
    }
}
