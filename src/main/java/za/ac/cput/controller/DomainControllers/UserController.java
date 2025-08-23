package za.ac.cput.controller.DomainControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/create")
    public User create(@RequestBody User user ){
        return userService.create(user);
    }

    @RequestMapping("/read/{userId}")
    public User read(@PathVariable Long userId){
        return userService.read(userId);
    }

    @RequestMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }
    @RequestMapping("/delete/{userId}")
    public boolean delete(@PathVariable Long userId){
        return userService.delete(userId);
    }
    @RequestMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

}
