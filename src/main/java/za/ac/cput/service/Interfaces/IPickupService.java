package za.ac.cput.service.Interfaces;

import za.ac.cput.domain.Pickup;

import java.util.List;

public interface IPickupService extends IService<Pickup, Long> {
    List<Pickup> getAll();
}
