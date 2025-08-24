package za.ac.cput.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navigationController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/bookARide")
    public String login() {
        return "bookARide";
    }

    @GetMapping("/viewRideRequests")
    public String viewRideRequests() {
        return "viewRideRequests";
    }

    @GetMapping("/userLogin")
    public String loginPage() {
        return "userLogin";
    }

    @GetMapping("/driverLogin")
    public String driverLoginPage() {
        return "driverLogin";
    }

    @GetMapping("/addVehicle")
    public String addVehicle() {
        return "addVehicle";
    }

    @GetMapping("/addBankDetails")
    public String addBankDetails() {
        return "addBankDetails";
    }

    @GetMapping("/userBookingHistory")
    public String userBookingHistoryPage() {
        return "userBookingHistory";
    }

    @GetMapping("/driverBookedHistory")
    public String driverBookedHistoryPage() {
        return "driverBookedHistory";
    }



}
