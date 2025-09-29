package za.ac.cput.controller;

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
@RequestMapping("/userProfile")
public class UserProfileController {

    private UserService userService;
    private BankDetailsService bankDetailsService;
    private BankBranchService bankBranchService;

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

        // Sets the userProfile object to the "user" model attribute
        model.addAttribute("user", userProfile);

        // Sets the userProfile.bankdetails object to the "bankdetails" model attribute
        model.addAttribute("bankdetails", userProfile.getBankdetails());

        // Sets the bankBranchService.getAll() object to the "branches" model attribut
        model.addAttribute("branches", bankBranchService.getAll());
        return "userProfile";
    }

    @PostMapping("/update") // Handles POST requests to "/userProfile/update"
    public String updateProfile(
            @RequestParam("userId") Long userId,// Capture user ID from form
            @RequestParam("name") String userName,// Capture updated user name
            @RequestParam("surname") String userSurname, // Capture updated surname
            @RequestParam("phoneNumber") String userPhoneNum, // Capture updated phone number
            @RequestParam("email") String email,// Capture updated email
            @RequestParam("password") String password,   // Capture updated password
            @RequestParam("cardNumber") String cardNumber, // Capture updated bank card number
            @RequestParam("cardExpiry") String cardExpiry, // Capture updated expiry date
            @RequestParam("cardCvv") String cardCvv,// Capture updated CVV
            @RequestParam("branchId") Long branchId,// Capture selected bank branch ID
            HttpSession session, Model model) {// Access current HTTP session


        // Retrieve the current user from the database
        User oldUser = userService.read(userId);

        // If user is not found, redirect with error
        if (oldUser == null) return "redirect:/userProfile?error=UserNotFound";

        // Retrieve user's current bank details
        BankDetails oldBank = oldUser.getBankdetails();

        // Create a new BankDetails object using Builder pattern, updating necessary fields
        BankDetails newBank = new BankDetails.Builder()
                .copy(oldBank)// Start with a copy of the old bank details
                .setBankCardNum(cardNumber)
                .setBankCardDate(cardExpiry)
                .setBankCardCVV(cardCvv)
                .setBankBranch(bankBranchService.read(branchId)) // Link to selected branch
                .build();

        // Create a new User object with updated details
        User updatedUser = new User.UserBuilder().copy(oldUser)
                .setUserName(userName)
                .setUserSurname(userSurname)
                .setUserPhoneNum(userPhoneNum)
                .setUserEmail(email)
                .setUserPassword(password)
                .setBankdetails(newBank)
                .build();


        boolean noChanges =
                oldUser.getUserName().equals(userName) &&
                        oldUser.getUserSurname().equals(userSurname) &&
                        oldUser.getUserPhoneNum().equals(userPhoneNum) &&
                        oldUser.getUserEmail().equals(email) &&
                        oldUser.getUserPassword().equals(password) &&
                        oldBank.getBankCardNum().equals(cardNumber) &&
                        oldBank.getBankCardDate().equals(cardExpiry) &&
                        oldBank.getBankCardCVV().equals(cardCvv) &&
                        oldBank.getBankBranch().getBankBranchId().equals(branchId);

        if (noChanges) {
            model.addAttribute("message", "No changes were made");

        }else{
            userService.update(updatedUser);        // Save the updated user back to the database
            session.setAttribute("user", updatedUser);
            model.addAttribute("message", "User Profile updated successfully");
        }

        // Update the session with the new user data
        model.addAttribute("user", updatedUser);
        model.addAttribute("bankdetails", updatedUser.getBankdetails());
        model.addAttribute("branches", bankBranchService.getAll());

        return "userProfile";
    }

    @PostMapping("/delete") // Handles POST requests to "/userProfile/delete"
    public String deleteUserProfile(HttpSession session) {
        // Retrieve logged-in user from session
        User user = (User) session.getAttribute("user");

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
