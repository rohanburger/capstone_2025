package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Session;
import za.ac.cput.domain.User;
import za.ac.cput.repository.SessionRepository;
import za.ac.cput.service.Interfaces.ISessionService;

import java.util.List;

@Service
public class SessionService implements ISessionService {

    private SessionRepository repository;

    @Autowired SessionService(SessionRepository repository){
        this.repository = repository;
    }

    @Override
    public Session create(Session session) {
        return this.repository.save(session);
    }

    @Override
    public Session read(Long s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Session update(Session session) {
        return this.repository.save(session);
    }

    @Override
    public boolean delete(Long s) {
        repository.deleteById(s);
        return true;
    }
    @Override
    public List<Session> getAll() {
        return repository.findAll();
    }


    public boolean canCreateSession(User user) {
        if (user == null) return false;
        List<Session> pendingSessions = repository.findByUserAndSessionStatus(user, "Pending");
        List<Session> pendingResponseSessions = repository.findByUserAndSessionStatus(user, "Pending Response");
        List<Session> activeSessions  = repository.findByUserAndSessionStatus(user, "Active");

        return pendingSessions.isEmpty() && activeSessions.isEmpty() && pendingResponseSessions.isEmpty();
    }

    public List<Session> getSessionsForUser(User user) {
        return repository.findByUser_UserId(user.getUserId());
    }

    public List<Session> getPendingSessions() {
        return repository.findBySessionStatus("Pending");
    }

    public List<Session> getActiveSessionsByDriver(Long driverId) {
        return repository.findByDriver_DriverIdAndSessionStatus(driverId, "Active");
    }

    public List<Session> getAllSessionsByDriver(Long driverId) {
        return repository.findByDriver_DriverId(driverId);
    }


}
