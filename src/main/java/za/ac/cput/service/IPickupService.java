package za.ac.cput.service;

import za.ac.cput.domain.Pickup;

import java.util.List;

public interface IPickupService extends IService<Pickup, String>{
    List<Pickup> getAll();
}
