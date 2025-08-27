package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.Factory.DropoffFactory;
import za.ac.cput.Factory.LocationFactory;
import za.ac.cput.Factory.PickupFactory;
import za.ac.cput.Factory.SessionFactory;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.Session;
import za.ac.cput.domain.User;
import za.ac.cput.service.SessionService;
import za.ac.cput.service.UserService;

@Controller
@RequestMapping("/userSession")
public class UserSessionController {

    private SessionService sessionService;
    private UserService userService;

    @Autowired
    public UserSessionController(SessionService sessionService, UserService userService) {
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @GetMapping
    public String createSessionPage(Model model) {
        return "bookARide";
    }// Handles the /userSession GET request

    @PostMapping("/create")
    public String createSession(
            @RequestParam("passengerCount") int passengerCount,// Captures the passengerCount from the form
            @RequestParam("pickUpStreet") String pickUpStreet,// Captures the pickUpStreet from the form
            @RequestParam("pickUpSuburb") String pickUpSuburb,// Captures the pickUpSuburb from the form
            @RequestParam("pickUpCity") String pickUpCity,// Captures the pickUpCity from the form
            @RequestParam("dropOffStreet") String dropOffStreet,// Captures the dropOffStreet from the form
            @RequestParam("dropOffSuburb") String dropOffSuburb,// Captures the dropOffSuburb from the form
            @RequestParam("dropOffCity") String dropOffCity,// Captures the dropOffCity from the form
            HttpSession session,// Captures the session object from the form
            Model model
    ) {
        User sessionUser = (User) session.getAttribute("user");// Captures the user object from the session and casts it to a User object
        if (sessionUser == null) {
            model.addAttribute("error", "You must be logged in to create a session");
            return "redirect:/userRegister";
        }


        User user = userService.read(sessionUser.getUserId());// Calls the read method in the UserService class to retrieve the user with the specified userId
        if (user == null) {
            model.addAttribute("error", "User not found");
            return "bookARide";
        }

        if (!sessionService.canCreateSession(user)) {// Checks if the user can create a session
            model.addAttribute("error", "You already have an active session!");
            return "bookARide";
        }

        try {
            Location location = LocationFactory.createLocation(// Creates a new Location object with the specified pickUpStreet, pickUpSuburb, pickUpCity, dropOffStreet, dropOffSuburb, and dropOffCity
                    DropoffFactory.createDropoff(dropOffStreet, dropOffSuburb, dropOffCity),
                    PickupFactory.createPickupWithAttributes(pickUpStreet, pickUpSuburb, pickUpCity)
            );

            Session usersession = SessionFactory.createSessionFactory(// Creates a new Session object with the specified user, location, passengerCount, sessionStatus, and sessionType
                    user, null, location, passengerCount, "Pending", null
            );

            sessionService.create(usersession);// Calls the create method in the SessionService class to create the session
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "bookARide";
        }
    }

}
