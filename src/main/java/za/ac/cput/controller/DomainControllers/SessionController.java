package za.ac.cput.controller.DomainControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Session;
import za.ac.cput.service.SessionService;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    private SessionService sessionService;
    @Autowired
    SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @PostMapping("/create")
    public Session create(@RequestBody Session session){
        return sessionService.create(session);
    }
    @RequestMapping("/read/{sessionId}")
    public Session read(@PathVariable Long sessionId){
        return sessionService.read(sessionId);
    }
    @RequestMapping("/update")
    public Session update(@RequestBody Session session){
        return sessionService.update(session);
    }
    @RequestMapping("/delete/{sessionId}")
    public boolean delete(@PathVariable Long sessionId){
        return sessionService.delete(sessionId);
    }
    @RequestMapping("/all")
    public List<Session> getAll(){
        return sessionService.getAll();
    }
}
