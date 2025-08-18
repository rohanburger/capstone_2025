package za.ac.cput.service.Interfaces;

import za.ac.cput.domain.Session;

import java.util.List;

public interface ISessionService extends IService<Session, Long> {
    List<Session> getAll();
}
