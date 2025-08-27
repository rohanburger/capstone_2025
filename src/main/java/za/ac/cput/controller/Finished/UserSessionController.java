package za.ac.cput.controller.Finished;

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
    }

    @PostMapping("/create")
    public String createSession(
            @RequestParam("passengerCount") int passengerCount,
            @RequestParam("pickUpStreet") String pickUpStreet,
            @RequestParam("pickUpSuburb") String pickUpSuburb,
            @RequestParam("pickUpCity") String pickUpCity,
            @RequestParam("dropOffStreet") String dropOffStreet,
            @RequestParam("dropOffSuburb") String dropOffSuburb,
            @RequestParam("dropOffCity") String dropOffCity,
            HttpSession session,
            Model model
    ) {
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            model.addAttribute("error", "You must be logged in to create a session");
            return "redirect:/userRegister";
        }


        User user = userService.read(sessionUser.getUserId());
        if (user == null) {
            model.addAttribute("error", "User not found");
            return "bookARide";
        }

        if (!sessionService.canCreateSession(user)) {
            model.addAttribute("error", "You already have an active session!");
            return "bookARide";
        }

        try {
            Location location = LocationFactory.createLocation(
                    DropoffFactory.createDropoff(dropOffStreet, dropOffSuburb, dropOffCity),
                    PickupFactory.createPickupWithAttributes(pickUpStreet, pickUpSuburb, pickUpCity)
            );

            Session usersession = SessionFactory.createSessionFactory(
                    user, null, location, passengerCount, "Pending", null
            );

            sessionService.create(usersession);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "bookARide";
        }
    }

}
