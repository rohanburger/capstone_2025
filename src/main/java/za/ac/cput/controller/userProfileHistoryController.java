package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.domain.Session;
import za.ac.cput.domain.User;
import za.ac.cput.service.SessionService;

import java.util.List;

@Controller
@RequestMapping("/userBookingHistory")
public class userProfileHistoryController {

    private final SessionService sessionService;

    @Autowired
    public userProfileHistoryController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public String getUserBookingHistory(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            return "redirect:/userRegister";
        }

        // Fetch sessions for logged-in user
        List<Session> userBookings = sessionService.getSessionsForUser(user);

        // Add to model
        model.addAttribute("bookings", userBookings);
        model.addAttribute("loggedInUser", user); // optional for navbar

        return "userBookingHistory";
    }

}
