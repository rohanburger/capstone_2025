package za.ac.cput.service;

import za.ac.cput.domain.Passenger;

import java.util.List;

public interface IPassengerService extends IService<Passenger, String>{
    List<Passenger> getAll(); //retrieves a list of all passengers
}
