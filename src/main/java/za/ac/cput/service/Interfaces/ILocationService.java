package za.ac.cput.service.Interfaces;
//
import za.ac.cput.domain.Location;

import java.util.List;

public interface ILocationService extends IService<Location, Long> {
    List<Location> getall();
}
