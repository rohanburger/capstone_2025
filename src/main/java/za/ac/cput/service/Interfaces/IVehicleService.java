package za.ac.cput.service.Interfaces;

import za.ac.cput.domain.Vehicle;

import java.util.List;

public interface IVehicleService extends IService<Vehicle, Long> {
    List<Vehicle> getAll();
}
