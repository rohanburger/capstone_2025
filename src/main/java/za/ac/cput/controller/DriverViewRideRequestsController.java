package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Session;
import za.ac.cput.service.SessionService;

import java.util.List;

@Controller
@RequestMapping("/viewRideRequests")
public class DriverViewRideRequestsController {

    private final SessionService sessionService;

    @Autowired
    public DriverViewRideRequestsController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    // Show only Pending sessions
    @GetMapping
    public String showPendingSessions(HttpSession httpSession, Model model) {
        Driver driver = (Driver) httpSession.getAttribute("user"); // Get the user from the session and cast it to a Driver object
        if (driver == null) {
            return "redirect:/userRegister";
        }

        List<Session> pendingSessions = sessionService.getPendingSessions();// Get all pending sessions from the service
        model.addAttribute("bookings", pendingSessions);// Sets the pendingSessions object to the model attribute bookings
        model.addAttribute("loggedInUser", driver);// Sets the Driver object to the loggedInUser in the model
        return "viewRideRequests";
    }

    // Accept a booking, set price, and assign driver
    @PostMapping("/accept")
    public String acceptBooking(
            @RequestParam("sessionId") Long sessionId,// Capture the session ID from the form
            @RequestParam("price") Float price,// Capture the price from the form
            HttpSession httpSession,// Capture the session
            Model model// Capture the model from the form
    ) {
        Driver driver = (Driver) httpSession.getAttribute("user");// Get the user from the session and cast it to a Driver object
        if (driver == null) {
            return "redirect:/userRegister";
        }

        // Check if driver already has an active session
        List<Session> activeSessions = sessionService.getActiveSessionsByDriver(driver.getDriverId());
        if (!activeSessions.isEmpty()) {// If the driver has an active session, display an error message
            model.addAttribute("error", "You already have an active session. Complete it before accepting a new one.");

            List<Session> pendingSessions = sessionService.getPendingSessions();// Reload pending sessions
            model.addAttribute("bookings", pendingSessions);// SEts the pendingSessions object to the model attribute bookings
            model.addAttribute("loggedInUser", driver);//Sets the Driver object to the model attribute loggedInUser
            return "viewRideRequests";
        }

        Session booking = sessionService.read(sessionId);// Get the booking from the service using the session ID
        if (booking == null || !"Pending".equalsIgnoreCase(booking.getSessionStatus())) {
            // Reload pending sessions if booking invalid
            List<Session> pendingSessions = sessionService.getPendingSessions();// Reload pending sessions
            model.addAttribute("bookings", pendingSessions);//sets the pendingSessions object to the model attribute bookings
            model.addAttribute("loggedInUser", driver);// sets the Driver object to the model attribute loggedInUser
            return "viewRideRequests";
        }

        // Build a Payment object using Builder
        Payment payment = new Payment.Builder()//
                .setPaymentamount(price)
                .build();

        // Update session using Builder + copy
        Session updatedBooking = new Session.Builder()
                .copy(booking)// copy the booking from the service using the session ID
                .setSessionStatus("Pending Response")// set the session status to Active
                .setDriver(driver)
                .setPayment(payment)
                .build();

        sessionService.update(updatedBooking);

        // After successful acceptance, reload pending sessions
        List<Session> pendingSessions = sessionService.getPendingSessions();
        model.addAttribute("bookings", pendingSessions);//Sets the pendingSessions object to the model attribute bookings
        model.addAttribute("loggedInUser", driver);//Sets the driver object to the model attribute loggedInUser

        return "viewRideRequests";
    }

}
