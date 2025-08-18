package za.ac.cput.service.Interfaces;

import za.ac.cput.domain.Dropoff;

import java.util.List;

public interface IDropoffService extends IService<Dropoff, Long> {
    List<Dropoff> getAll();
}
