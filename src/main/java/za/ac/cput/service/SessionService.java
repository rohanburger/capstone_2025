package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Session;
import za.ac.cput.repository.SessionRepository;

import java.util.List;

@Service
public class SessionService implements ISessionService {

    @Autowired
    private static ISessionService service;
    private static SessionRepository repository;

    @Override
    public Session create(Session session) {
        return this.repository.save(session);
    }

    @Override
    public Session read(String s) {
        return repository.findBySessionId(s);
    }

    @Override
    public Session update(Session session) {
        return this.repository.save(session);
    }

    @Override
    public boolean delete(String s) {
        repository.deleteById(s);
        return true;
    }

    @Override
    public List<Session> getAll() {
        return repository.findAll();
    }
}
