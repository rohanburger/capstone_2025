package za.ac.cput.service.Interfaces;

import za.ac.cput.domain.User;

import java.util.List;

public interface IUserService extends IService<User, Long> {
    List<User> getAll(); //retrieves a list of all passengers
}
