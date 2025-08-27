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
public class driverViewRideRequestsController {

    private final SessionService sessionService;

    @Autowired
    public driverViewRideRequestsController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    // Show only Pending sessions
    @GetMapping
    public String showPendingSessions(HttpSession httpSession, Model model) {
        Driver driver = (Driver) httpSession.getAttribute("user"); // driver stored in session
        if (driver == null) {
            return "redirect:/userRegister";
        }

        List<Session> pendingSessions = sessionService.getPendingSessions(); // service handles "Pending" status
        model.addAttribute("bookings", pendingSessions);
        model.addAttribute("loggedInUser", driver);
        return "viewRideRequests"; // Thymeleaf view matches HTML file name
    }

    // Accept a booking, set price, and assign driver
    @PostMapping("/accept")
    public String acceptBooking(
            @RequestParam("sessionId") Long sessionId,
            @RequestParam("price") Float price,
            HttpSession httpSession,
            Model model
    ) {
        Driver driver = (Driver) httpSession.getAttribute("user");
        if (driver == null) {
            return "redirect:/userRegister";
        }

        // Check if driver already has an active session
        List<Session> activeSessions = sessionService.getActiveSessionsByDriver(driver.getDriverId());
        if (!activeSessions.isEmpty()) {
            model.addAttribute("error", "You already have an active session. Complete it before accepting a new one.");
            // Reload pending sessions to display
            List<Session> pendingSessions = sessionService.getPendingSessions();
            model.addAttribute("bookings", pendingSessions);
            model.addAttribute("loggedInUser", driver);
            return "viewRideRequests";
        }

        Session booking = sessionService.read(sessionId);
        if (booking == null || !"Pending".equalsIgnoreCase(booking.getSessionStatus())) {
            // Reload pending sessions if booking invalid
            List<Session> pendingSessions = sessionService.getPendingSessions();
            model.addAttribute("bookings", pendingSessions);
            model.addAttribute("loggedInUser", driver);
            return "viewRideRequests";
        }

        // Build a Payment object using Builder
        Payment payment = new Payment.Builder()
                .setPaymentamount(price)
                .build();

        // Update session using Builder + copy
        Session updatedBooking = new Session.Builder()
                .copy(booking)
                .setSessionStatus("Active") // mark session as Active
                .setDriver(driver)
                .setPayment(payment)
                .build();

        sessionService.update(updatedBooking);

        // After successful acceptance, reload pending sessions
        List<Session> pendingSessions = sessionService.getPendingSessions();
        model.addAttribute("bookings", pendingSessions);
        model.addAttribute("loggedInUser", driver);

        return "viewRideRequests";
    }

}
