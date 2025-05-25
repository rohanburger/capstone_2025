package za.ac.cput.service;
/*
    LocationServiceImpl.java
    Location Service Interface
    Author:Sharief Abdul
    Date:08/05/2025
*/
import za.ac.cput.domain.Location;

import java.util.List;

public interface LocationServiceImpl extends IService<Location, String>{
    List<Location> getall();
}
