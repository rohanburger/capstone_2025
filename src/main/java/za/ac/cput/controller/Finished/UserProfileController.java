package za.ac.cput.controller.Finished;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.domain.User;
import za.ac.cput.service.BankBranchService;
import za.ac.cput.service.BankDetailsService;
import za.ac.cput.service.UserService;

@Controller // Marks this class as a Spring MVC Controller to handle web requests
@RequestMapping("/userProfile") // All routes in this class will start with "/userProfile"
public class UserProfileController {

    // Inject services to interact with the database and business logic
    private UserService userService;                // Handles user data operations
    private BankDetailsService bankDetailsService;  // Handles bank details operations
    private BankBranchService bankBranchService;    // Handles bank branch operations

    // Constructor-based dependency injection for services
    @Autowired
    UserProfileController(UserService userService, BankDetailsService bankDetailsService, BankBranchService bankBranchService){
        this.userService = userService;
        this.bankDetailsService = bankDetailsService;
        this.bankBranchService = bankBranchService;
    }

    @GetMapping // Handles GET requests to "/userProfile"
    public String getUserProfile(HttpSession session , Model model){
        // Retrieve the currently logged-in user object stored in the session
        User user = (User) session.getAttribute("user");

        // If no user is found in the session, redirect to the registration page
        if(user == null){
            return "redirect:/userRegister";
        }

        // Fetch the latest user details from the database using the user's ID
        User userProfile = userService.read(user.getUserId());

        // Add the user object to the model for use in the view
        model.addAttribute("user", userProfile);

        // Add the user's bank details to the model
        model.addAttribute("bankdetails", userProfile.getBankdetails());

        // Add all bank branches to the model (e.g., for dropdown selection in view)
        model.addAttribute("branches", bankBranchService.getAll());

        // Return the "userProfile" view (Thymeleaf/JSP page) to be rendered
        return "userProfile";
    }

    @PostMapping("/update") // Handles POST requests to "/userProfile/update"
    public String updateProfile(
            @RequestParam("userId") Long userId,         // Capture user ID from form
            @RequestParam("name") String userName,       // Capture updated user name
            @RequestParam("surname") String userSurname, // Capture updated surname
            @RequestParam("phoneNumber") String userPhoneNum, // Capture updated phone number
            @RequestParam("email") String email,         // Capture updated email
            @RequestParam("password") String password,   // Capture updated password
            @RequestParam("cardNumber") String cardNumber, // Capture updated bank card number
            @RequestParam("cardExpiry") String cardExpiry, // Capture updated expiry date
            @RequestParam("cardCvv") String cardCvv,     // Capture updated CVV
            @RequestParam("branchId") Long branchId,     // Capture selected bank branch ID
            HttpSession session) {                       // Access current HTTP session


        // Retrieve the current user from the database
        User oldUser = userService.read(userId);

        // If user is not found, redirect with error
        if (oldUser == null) return "redirect:/userProfile?error=UserNotFound";

        // Retrieve user's current bank details
        BankDetails oldBank = oldUser.getBankdetails();

        // Create a new BankDetails object using Builder pattern, updating necessary fields
        BankDetails newBank = new BankDetails.Builder()
                .copy(oldBank)                                // Start with a copy of the old bank details
                .setBankCardNum(cardNumber)                   // Update card number
                .setBankCardDate(cardExpiry)                  // Update expiry date
                .setBankCardCVV(cardCvv)                      // Update CVV
                .setBankBranch(bankBranchService.read(branchId)) // Link to selected branch
                .build();                                     // Build the new bank details object

        // Create a new User object with updated details
        User updatedUser = new User.UserBuilder().copy(oldUser)
                .setUserName(userName)                        // Update user's name
                .setUserSurname(userSurname)                  // Update surname
                .setUserPhoneNum(userPhoneNum)                // Update phone number
                .setUserEmail(email)                          // Update email
                .setUserPassword(password)                    // Update password
                .setBankdetails(newBank)                      // Link new bank details
                .build();                                     // Build updated user object

        // Save the updated user back to the database
        userService.update(updatedUser);

        // Update the session with the new user data
        session.setAttribute("user", updatedUser);

        // Redirect to the user profile page to display updated data
        return "redirect:/userProfile";
    }

    @PostMapping("/delete") // Handles POST requests to "/userProfile/delete"
    public String deleteUserProfile(HttpSession session) {
        // Retrieve logged-in user from session
        User user = (User) session.getAttribute("user");

        // If user exists, delete the account and log them out
        if (user != null) {
            userService.delete(user.getUserId()); // Delete user by ID
            session.invalidate();                 // Clear session (log out)
        }

        // Redirect to homepage after deletion
        return "redirect:/";
    }

    @PostMapping("/logout") // Handles POST requests to "/userProfile/logout"
    public String logout(HttpSession session) {
        // Invalidate session to log out the user
        session.invalidate();

        // Redirect to homepage after logging out
        return "redirect:/";
    }
}
