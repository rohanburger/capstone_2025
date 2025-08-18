package za.ac.cput.service;
/*
    DropoffServiceImpl.java
    Dropoff Service Interface
    Author:Sharief Abdul
    Date:08/05/2025
*/

import za.ac.cput.domain.Dropoff;
import za.ac.cput.domain.Location;

import java.util.List;

public interface DropoffServiceImpl extends IService<Dropoff, String>{
    List<Dropoff> getall();
}

