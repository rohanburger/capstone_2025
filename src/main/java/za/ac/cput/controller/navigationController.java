package za.ac.cput.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navigationController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @GetMapping("/bookARide.html")
    public String login() {
        return "bookARide";
    }

    @GetMapping("/viewRideRequests.html")
    public String viewRideRequests() {
        return "viewRideRequests";
    }

    @GetMapping("/register.html")
    public String register() {
        return "register";
    }

    @GetMapping("/userProfile.html")
    public String userProfile() {
        return "userProfile";
    }

    @GetMapping("/login.html")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/addVehicle.html")
    public String addVehicle() {
        return "addVehicle";
    }

    @GetMapping("/addBankDetails.html")
    public String addBankDetails() {
        return "addBankDetails";
    }

    @GetMapping("/userBookingHistory.html")
    public String userBookingHistoryPage() {
        return "userBookingHistory";
    }

    @GetMapping("/driverProfile.html")
    public String driverProfilePage() {
        return "driverProfile";
    }

    @GetMapping("/driverBookedHistory.html")
    public String driverBookedHistoryPage() {
        return "driverBookedHistory";
    }



}
