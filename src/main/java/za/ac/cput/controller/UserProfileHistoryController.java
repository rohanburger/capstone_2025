package za.ac.cput.controller;

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
        User user = (User) httpSession.getAttribute("user");// Get the user from the session and cast it to a User object
        if (user == null) {
            return "redirect:/userRegister";
        }

        List<Session> userBookings = sessionService.getSessionsForUser(user);// Get all sessions for this user

        model.addAttribute("bookings", userBookings);//Sets the userBookings object to the model attribute bookings
        model.addAttribute("loggedInUser", user); //Sets the loggedInUser object to the model attribute loggedInUser

        return "userBookingHistory";
    }

    @PostMapping("/cancel")
    public String cancelBooking(@RequestParam("sessionId") Long sessionId,// Capture the session ID from the form
                                HttpSession httpSession,// Capture the session from the form
                                Model model) {// Capture the model from the form
        User user = (User) httpSession.getAttribute("user");// Get the user from the session and cast it to a User object
        if (user == null) {
            return "redirect:/userRegister";
        }

        Session booking = sessionService.read(sessionId);// Get the booking from the service using the session ID
        if (booking != null && booking.getUser().getUserId().equals(user.getUserId())) {// Check if the booking is not null and if the user ID matches the user ID in the session

            // Prevent cancelling a completed booking
            if ("Completed".equalsIgnoreCase(booking.getSessionStatus())||"Active".equalsIgnoreCase(booking.getSessionStatus())) { // Checks if the booking is in the Completed or Active state
                List<Session> userBookings = sessionService.getSessionsForUser(user); // Reload all bookings for the user from the service using the user ID
                model.addAttribute("bookings", userBookings);// Sets the userBookings object to the model attribute bookings
                model.addAttribute("loggedInUser", user);// Sets the loggedInUser object to the model attribute loggedInUser
                model.addAttribute("error", "You cannot cancel a active or completed booking.");
                return "userBookingHistory";
            }

            Session updatedBooking = new Session.Builder()// Create a new Session object using the Builder class
                    .copy(booking)// Copy the booking from the service using the session ID
                    .setSessionStatus("Cancelled")
                    .build();

            sessionService.update(updatedBooking);// Update the booking in the service using the updated booking object
        }

        // Refresh the data after update
        List<Session> userBookings = sessionService.getSessionsForUser(user);// Reload all bookings for the user from the service using the user ID
        model.addAttribute("bookings", userBookings);// Sets the userBookings object to the model attribute bookings
        model.addAttribute("loggedInUser", user);// Sets the loggedInUser object to the model attribute loggedInUser
        return "userBookingHistory";
    }
    //rejects sets to pending
    @PostMapping("/reject")
    public String rejectBooking(@RequestParam("sessionId") Long sessionId, HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");// Get the user from the session and cast it to a User object
        if (user == null) {
            return "redirect:/userRegister";
        }

        Session booking = sessionService.read(sessionId);// Get the booking from the service using the session ID
        if (booking != null && booking.getUser().getUserId().equals(user.getUserId())) {
            // Check if the booking is not null and if the user ID matches the user ID in the session

            Session updatedBooking = new Session.Builder()// Create a new Session object using the Builder class
                    .copy(booking)// Copy the booking from the service using the session ID
                    .setDriver(null)
                    .setSessionStatus("Pending")
                    .setPayment(null)
                    .build();

            sessionService.update(updatedBooking);
        }

        List<Session> userBookings = sessionService.getSessionsForUser(user);// Reload all bookings for the user from the service using the user ID
        model.addAttribute("bookings", userBookings);// Sets the userBookings object to the model attribute bookings
        model.addAttribute("loggedInUser", user);// Sets the loggedInUser object to the model attribute loggedInUser

        return "redirect:/userBookingHistory";
    }

    //accepts sets to active
    @PostMapping("/acceptResponse")
    public String acceptBooking(@RequestParam("sessionId") Long sessionId, HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");// Get the user from the session and cast it to a User object
        if (user == null) {
            return "redirect:/userRegister";
        }

        Session booking = sessionService.read(sessionId);// Get the booking from the service using the session ID
        if (booking != null && booking.getUser().getUserId().equals(user.getUserId())) {
            // Check if the booking is not null and if the user ID matches the user ID in the session

            Session updatedBooking = new Session.Builder()// Create a new Session object using the Builder class
                    .copy(booking)// Copy the booking from the service using the session ID
                    .setSessionStatus("Active")
                    .build();
            sessionService.update(updatedBooking);
        }

        List<Session> userBookings = sessionService.getSessionsForUser(user);// Reload all bookings for the user from the service using the user ID
        model.addAttribute("bookings", userBookings);// Sets the userBookings object to the model attribute bookings
        model.addAttribute("loggedInUser", user);// Sets the loggedInUser object to the model attribute loggedInUser
        return "userBookingHistory";
    }

    @PostMapping("/completed")
    public String completeBooking(@RequestParam("sessionId") Long sessionId,// Capture the session ID from the form
                                  HttpSession httpSession,// Capture the session from the form
                                  Model model) {// Capture the model from the form
        User user = (User) httpSession.getAttribute("user");// Get the user from the session and cast it to a User object
        if (user == null) {
            return "redirect:/userRegister";
        }

        Session booking = sessionService.read(sessionId);// Get the booking from the service using the session ID
        if (booking != null && booking.getUser().getUserId().equals(user.getUserId())) {// Check if the booking is not null and if the user ID matches the user ID in the session

            if ("Cancelled".equalsIgnoreCase(booking.getSessionStatus())|| "Pending".equalsIgnoreCase(booking.getSessionStatus())) {// Checks if the booking is in the Cancelled or Pending state
                List<Session> userBookings = sessionService.getSessionsForUser(user);// Reload all bookings for the user from the service using the user ID
                model.addAttribute("bookings", userBookings);// Sets the userBookings object to the model attribute bookings
                model.addAttribute("loggedInUser", user);// Sets the loggedInUser object to the model attribute loggedInUser
                model.addAttribute("error", "You cannot complete a pending or cancelled booking.");
                return "userBookingHistory";
            }

            Session updatedBooking = new Session.Builder()// Create a new Session object using the Builder class
                    .copy(booking)// Copy the booking from the service using the session ID
                    .setSessionStatus("Completed")// Set the session status to Completed
                    .build();

            sessionService.update(updatedBooking);// Update the booking in the service using the updated booking object
        }

        // Refresh the data after update
        List<Session> userBookings = sessionService.getSessionsForUser(user);// Reload all bookings for the user from the service using the user ID
        model.addAttribute("bookings", userBookings);// Sets the userBookings object to the model attribute bookings
        model.addAttribute("loggedInUser", user);// Sets the user object to the model attribute loggedInUser
        return "userBookingHistory";
    }

}
