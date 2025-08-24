package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.Interfaces.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {

    private UserRepository repository;
    @Autowired public UserService(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User update(User passenger) {
        return this.repository.save(passenger);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll(); //retrieves a list of Passenger
    }


    public User findByEmailAndPassword(String email, String password) {
        return repository.findByUserEmailAndUserPassword(email, password).orElse(null);
    }


    public boolean existsByEmail(String email) {
        return repository.existsByUserEmail(email);
    }



}
