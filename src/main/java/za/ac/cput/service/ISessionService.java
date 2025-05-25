package za.ac.cput.service;

import za.ac.cput.domain.Session;

import java.util.List;

public interface ISessionService extends IService<Session, String> {
    List<Session> getAll();
}
