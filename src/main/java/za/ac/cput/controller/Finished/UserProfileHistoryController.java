package za.ac.cput.controller.Finished;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.Session;
import za.ac.cput.domain.User;
import za.ac.cput.service.SessionService;

import java.util.List;

@Controller
@RequestMapping("/userBookingHistory")
public class UserProfileHistoryController {

    private final SessionService sessionService;

    @Autowired
    public UserProfileHistoryController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public String getUserBookingHistory(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            return "redirect:/userRegister";
        }

        List<Session> userBookings = sessionService.getSessionsForUser(user);

        model.addAttribute("bookings", userBookings);
        model.addAttribute("loggedInUser", user); // optional for navbar

        return "userBookingHistory";
    }

    @PostMapping("/cancel")
    public String cancelBooking(@RequestParam("sessionId") Long sessionId,
                                HttpSession httpSession,
                                Model model) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            return "redirect:/userRegister";
        }

        Session booking = sessionService.read(sessionId);
        if (booking != null && booking.getUser().getUserId().equals(user.getUserId())) {

            // Prevent cancelling a completed booking
            if ("Completed".equalsIgnoreCase(booking.getSessionStatus())||"Active".equalsIgnoreCase(booking.getSessionStatus())) {
                List<Session> userBookings = sessionService.getSessionsForUser(user);
                model.addAttribute("bookings", userBookings);
                model.addAttribute("loggedInUser", user);
                model.addAttribute("error", "You cannot cancel a active or completed booking.");
                return "userBookingHistory";
            }

            Session updatedBooking = new Session.Builder()
                    .copy(booking)
                    .setSessionStatus("Cancelled")
                    .build();

            sessionService.update(updatedBooking);
        }

        // Refresh the data after update
        List<Session> userBookings = sessionService.getSessionsForUser(user);
        model.addAttribute("bookings", userBookings);
        model.addAttribute("loggedInUser", user);
        return "userBookingHistory";
    }

    @PostMapping("/completed")
    public String completeBooking(@RequestParam("sessionId") Long sessionId,
                                  HttpSession httpSession,
                                  Model model) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            return "redirect:/userRegister";
        }

        Session booking = sessionService.read(sessionId);
        if (booking != null && booking.getUser().getUserId().equals(user.getUserId())) {

            if ("Cancelled".equalsIgnoreCase(booking.getSessionStatus())|| "Pending".equalsIgnoreCase(booking.getSessionStatus())) {
                List<Session> userBookings = sessionService.getSessionsForUser(user);
                model.addAttribute("bookings", userBookings);
                model.addAttribute("loggedInUser", user);
                model.addAttribute("error", "You cannot complete a pending or cancelled booking.");
                return "userBookingHistory";
            }

            Session updatedBooking = new Session.Builder()
                    .copy(booking)
                    .setSessionStatus("Completed")
                    .build();

            sessionService.update(updatedBooking);
        }

        // Refresh the data after update
        List<Session> userBookings = sessionService.getSessionsForUser(user);
        model.addAttribute("bookings", userBookings);
        model.addAttribute("loggedInUser", user);
        return "userBookingHistory";
    }

}
