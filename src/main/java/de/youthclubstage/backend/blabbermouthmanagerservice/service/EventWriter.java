package de.youthclubstage.backend.blabbermouthmanagerservice.service;

import de.youthclubstage.blabbermouth.core.annotation.EventhandlerMethod;
import de.youthclubstage.blabbermouth.core.model.EventMessage;
import org.springframework.stereotype.Service;

@Service
public class EventWriter {

    @EventhandlerMethod(process = -1 , state = -1)
    public EventMessage allMessages(EventMessage message){
        return null;
    }
}
