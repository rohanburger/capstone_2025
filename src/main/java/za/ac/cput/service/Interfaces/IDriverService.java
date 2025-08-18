package za.ac.cput.service.Interfaces;

import za.ac.cput.domain.Driver;
import java.util.List;

public interface IDriverService extends IService<Driver, Long> {
    List<Driver> getAll();
}
